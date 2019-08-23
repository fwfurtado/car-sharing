FROM openjdk:8-jre-slim

ARG JAR_FILE

RUN mkdir /app

COPY ${JAR_FILE} /app/application.jar

WORKDIR /app

EXPOSE 8471

CMD ["java", "-jar", "application.jar"]
