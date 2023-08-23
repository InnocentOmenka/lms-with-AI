#FROM openjdk:17
#ADD ./target/demo-for-authentication-0.0.1-SNAPSHOT.jar demo-for-authentication-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java", "-jar", "demo-for-authentication-0.0.1-SNAPSHOT.jar"]
#EXPOSE 8080

#FROM openjdk:17
#ADD ./target/week-nine-0.0.1-SNAPSHOT.jar week-nine-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java", "-jar", "week-nine-0.0.1-SNAPSHOT.jar"]
#EXPOSE 8080

#FROM openjdk:17-jdk-alpine
#VOLUME /tmp
#COPY target/*.jar app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]
#EXPOSE 8080

FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
#WORKDIR /app

# Copy the JAR file from the target directory to the container's working directory
COPY /target/demo-for-authentication-0.0.1-SNAPSHOT.jar app.jar

# Set the command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

# Expose the port that your Spring Boot application is listening on
EXPOSE 8080
