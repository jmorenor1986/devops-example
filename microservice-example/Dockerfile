FROM openjdk:8-jdk-alpine
ARG JAR_FILE=microservice-example/target/microservice-example-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]