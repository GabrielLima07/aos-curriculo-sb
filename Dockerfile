FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine

COPY --from=build /app/target/curriculum-0.0.1-SNAPSHOT.jar app.jar

ARG DATASOURCE_URL
ARG DATASOURCE_USERNAME
ARG DATASOURCE_PASSWORD

ENV SPRING_DATASOURCE_URL=${DATASOURCE_URL}
ENV SPRING_DATASOURCE_USERNAME=${DATASOURCE_USERNAME}
ENV SPRING_DATASOURCE_PASSWORD=${DATASOURCE_PASSWORD}

RUN addgroup -S app && adduser -S app -G app

USER app


ENTRYPOINT ["java", "-jar", "/app.jar"]