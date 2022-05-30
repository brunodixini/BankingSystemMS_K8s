#Start with a base image containing Java runtime
FROM openjdk:11-slim as build

#Information around who maintains the image
MAINTAINER ramkumar.com

# Add the application's jar to the container
COPY target/customer-1.0.0.jar customer-1.0.0.jar

#execute the application
ENTRYPOINT ["java","-jar","/customer-1.0.0.jar"]