FROM maven:3.9.9 AS build

COPY src /app/src
COPY pom.xml /app

WORKDIR /app

RUN mvn clean package -DskipTests
FROM openjdk:21-slim

COPY --from=build /app/target/dockerTeste-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

EXPOSE 8080

ARG variavel

ENV minha_variavel=$variavel

CMD ["java", "-jar", "app.jar"]