# 使用一个基础的 OpenJDK 镜像
FROM openjdk:21-jdk-slim
WORKDIR /app
ARG JAR_FILE=target/player-boot-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 3020
ENTRYPOINT ["java","-jar","/app/app.jar"]