FROM openjdk:17-oracle
MAINTAINER Spring Boot
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} document-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app.jar"]
