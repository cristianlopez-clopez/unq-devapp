FROM adoptopenjdk/openjdk11:alpine-jre as builder
ARG DEPENDENCY_FILE=build/libs/\*.jar
WORKDIR app
COPY --from=build ${DEPENDENCY_FILE} app/app.jar
ENTRYPOINT ["java","-jar","app/app.jar"]