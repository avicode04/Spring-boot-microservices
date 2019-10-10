FROM openjdk:11
ADD ./target/movie-service-0.0.1-SNAPSHOT.jar /usr/src/movie-service-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
EXPOSE 8090
ENTRYPOINT ["java","-jar", "movie-service-0.0.1-SNAPSHOT.jar"]
