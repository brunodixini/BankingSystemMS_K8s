FROM openjdk:11.0.4-jre-slim-buster
ARG JAR_FILE=target/loan-service-0.1.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080
