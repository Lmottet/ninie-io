FROM maven:3.9.9-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests -B


FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/ninie.io-0.0.1-SNAPSHOT.jar app.jar
EXPOSE $PORT
ENV JAVA_OPTS="-Dserver.port=$PORT -Dserver.address=0.0.0.0"
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]
