FROM openjdk:17-alpine
EXPOSE 8080
ARG JAR_FILE=./build/libs/Api.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","-Duser.timezone=Asia/Seoul","-Dspring.profiles.active=dev","/app.jar"]