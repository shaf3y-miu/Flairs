#DockerFile
FROM openjdk:8-alpine
COPY target/world.jar world.jar
ENTRYPOINT ["java", "-jar", "world.jar"]