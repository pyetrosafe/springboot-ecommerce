# Source: https://spring.io/guides/gs/spring-boot-docker

FROM maven:3.9.9-eclipse-temurin-17-alpine
# FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

# RUN addgroup -S spring && adduser -S spring -G spring
# USER spring:spring

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

RUN mvn install

CMD ["./mvnw", "spring-boot:run"]

