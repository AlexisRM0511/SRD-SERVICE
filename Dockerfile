FROM openjdk:17-oracle
MAINTAINER Spring Boot
COPY target/document-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
