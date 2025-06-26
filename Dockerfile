# --------------------------------------------------
# 1) Build stage: compile & package with Maven + JDK-17
# --------------------------------------------------
FROM maven:3.9.0-eclipse-temurin-17-alpine AS build

WORKDIR /app

# copy only the pom first for dependency caching
COPY pom.xml .
# if you use any settings.xml or .m2, COPY them here too

# download dependencies
RUN mvn dependency:go-offline -B

# copy your source and build
COPY src ./src
RUN mvn clean package -B

# --------------------------------------------------
# 2) Runtime stage: slim JRE only
# --------------------------------------------------
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# copy the fat-jar from the build stage
COPY --from=build /app/target/ninie.io-0.0.1-SNAPSHOT.jar app.jar

# (Optional) If you ever add a health‐check endpoint:
# EXPOSE 8080

# Allow overriding JVM flags at deploy time
ENV JAVA_OPTS=""

# Discord bots don’t serve HTTP—Render will keep the container running as a
# “Background Worker” service. Entry point runs your jar.
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]
