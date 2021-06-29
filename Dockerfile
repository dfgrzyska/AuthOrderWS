# syntax=docker/dockerfile:1
FROM openjdk:16-alpine3.13

COPY opa-ws/target/opa-ws.jar /opa-ws.jar
CMD ["java", "-jar", "/opa-ws.jar"]