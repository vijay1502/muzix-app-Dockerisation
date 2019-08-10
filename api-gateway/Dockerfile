FROM openjdk:11
WORKDIR usr/src
ADD ./target/microservice-0.0.1-SNAPSHOT.jar /usr/src/microservice-0.0.1-SNAPSHOT.jar
EXPOSE 8076
ENTRYPOINT ["java","-jar","microservice-0.0.1-SNAPSHOT.jar"]