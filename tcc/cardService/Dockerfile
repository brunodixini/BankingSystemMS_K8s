FROM openjdk:11.0.4-jre-slim-buster
ARG JAR_FILE=target/crudmicronaut-0.1.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080


docker build -t brunodixini/contacorrente:v1

docker build -t brunodixini/cashback:v1

docker push brunodixini/contacorrente:v1

docker push brunodixini/cashback:v1

