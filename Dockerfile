#FROM openjdk:17
#ADD ./target/demo-for-authentication-0.0.1-SNAPSHOT.jar demo-for-authentication-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java", "-jar", "demo-for-authentication-0.0.1-SNAPSHOT.jar"]
#EXPOSE 8080

#FROM openjdk:17
#ADD ./target/week-nine-0.0.1-SNAPSHOT.jar week-nine-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java", "-jar", "week-nine-0.0.1-SNAPSHOT.jar"]
#EXPOSE 8080

FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080