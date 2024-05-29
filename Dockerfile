FROM openjdk:17-jdk-alpine

COPY src/main/resources/application.properties /app/application.properties

ARG DATASOURCE_URL
ARG DATASOURCE_USERNAME
ARG DATASOURCE_PASSWORD

ENV DATASOURCE_URL $DATASOURCE_URL
ENV DATASOURCE_USERNAME $DATASOURCE_USERNAME
ENV DATASOURCE_PASSWORD $DATASOURCE_PASSWORD

RUN addgroup -S app && adduser -S app -G app

USER app

COPY target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]