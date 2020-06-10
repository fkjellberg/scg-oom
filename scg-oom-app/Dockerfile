FROM adoptopenjdk/openjdk11:jre-11.0.7_10-alpine

ENV JAVA_OPTS=""

ARG JAR_FILE=target/scg-oom-app-*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /app.jar
