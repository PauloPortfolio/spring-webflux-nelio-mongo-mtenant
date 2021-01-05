FROM openjdk:13-alpine

WORKDIR /opt/api

ARG JAR_FILE
COPY ${JAR_FILE} /opt/api/api.jar

SHELL ["/bin/sh", "-c"]

EXPOSE ${PORT_API}
EXPOSE ${PORT_DEBUG}

#CMD java ${DEBUG_OPTIONS} -jar api.jar --spring.profiles.active=${PROFILE}
CMD java ${DEBUG_OPTIONS} -jar api.jar
#CMD java ${DEBUG_OPTIONS} ${JAVA_OPTIONS} -jar api.jar