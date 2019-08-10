FROM openjdk:11
WORKDIR usr/src
ADD ./target/eureka-server-0.0.1-SNAPSHOT.jar /usr/src/eureka-server-0.0.1-SNAPSHOT.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","eureka-server-0.0.1-SNAPSHOT.jar"]