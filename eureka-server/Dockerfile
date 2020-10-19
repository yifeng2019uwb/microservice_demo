# Alpine because it's lighter
FROM openjdk:8-jdk-alpine
MAINTAINER Wendell Adriel <wendelladriel.ti@gmail.com>

# Set ENV variables
ENV PORT=8761

# Add JAR file and run it as entrypoint
ADD target/discovery-service.jar eureka-server.jar
ENTRYPOINT ["java", "-jar", "/eureka-server.jar"]

# Expose the port
EXPOSE 8761