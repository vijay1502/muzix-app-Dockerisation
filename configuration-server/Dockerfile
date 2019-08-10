FROM openjdk:11
WORKDIR usr/src
ADD ./target/configuration-server-0.0.1-SNAPSHOT.jar /usr/src/configuration-server-0.0.1-SNAPSHOT.jar
EXPOSE 8096
ENTRYPOINT ["java","-jar","configuration-server-0.0.1-SNAPSHOT.jar"]