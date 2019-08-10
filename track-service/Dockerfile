FROM openjdk:11
WORKDIR usr/src
ADD ./target/track-service-0.0.1-SNAPSHOT.jar /usr/src/track-service-0.0.1-SNAPSHOT.jar
EXPOSE 8079
ENTRYPOINT ["java","-jar","track-service-0.0.1-SNAPSHOT.jar"]