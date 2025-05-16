FROM amazoncorretto:17-alpine-jdk

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

ARG PROFILES
ARG ENV

ENTRYPOINT sh -c "java \
  -Dspring.profiles.active=${PROFILES} \
  -Dserver.env=${ENV} \
  -jar app.jar"
