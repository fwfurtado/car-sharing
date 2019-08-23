FROM openjdk:jre-slim

ARG JAR_FILE

RUN mkdir /application

COPY ${JAR_FILE} /application/application.jar

EXPOSE 7000

WORKDIR /application

CMD ["java", "-jar", "application.jar"]
