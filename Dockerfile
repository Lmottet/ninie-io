# --- Build stage ---
FROM maven:3.9.9-eclipse-temurin-21-alpine AS build
WORKDIR /app

# --- Step 1: Copy Maven wrapper and POMs for caching ---
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY data/pom.xml data/
COPY business/pom.xml business/
COPY discord/pom.xml discord/
COPY api/pom.xml api/

# Make wrapper executable
RUN chmod +x mvnw

# --- Step 2: Download all dependencies for caching ---
RUN ./mvnw dependency:go-offline -B

# --- Step 3: Copy source code ---
COPY . .

# --- Step 4: Build API module with layered JAR ---
RUN ./mvnw clean package -pl api -am -DskipTests -B -Dspring-boot.repackage.layered=true


FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy the API module jar from build stage
COPY --from=build /app/api/target/api-0.0.1-SNAPSHOT.jar app.jar

# Expose port dynamically (Render sets $PORT)
EXPOSE $PORT
ENV JAVA_OPTS="-Dserver.port=$PORT -Dserver.address=0.0.0.0"

# Run the app
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
