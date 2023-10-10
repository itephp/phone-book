FROM eclipse-temurin:11-alpine as base
VOLUME /tmp

FROM base as production
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

FROM base as development
