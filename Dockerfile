FROM openjdk:11.0.14-jre

COPY ./build/libs/back-0.0.1-SNAPSHOT.jar /backend.jar
CMD java -jar /backend.jar