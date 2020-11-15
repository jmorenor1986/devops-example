FROM openjdk:8-jdk-alpine
ARG JAR_FILE=/var/jenkins_home/workspace/TEST/build/microservice-example/target/microservice-example-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]