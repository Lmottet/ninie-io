FROM maven:3.9.9-eclipse-temurin-21-alpine AS build
WORKDIR /app

COPY pom.xml .
COPY data/pom.xml data/
COPY business/pom.xml business/
COPY discord/pom.xml discord/
COPY api/pom.xml api/

COPY . .

RUN mvn clean package -pl api -am -DskipTests -B
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

COPY --from=build /app/api/target/api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE $PORT
ENV JAVA_OPTS="-Dserver.port=$PORT -Dserver.address=0.0.0.0"

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]
