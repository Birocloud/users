FROM openjdk:8-jre-alpine

RUN mkdir /app

WORKDIR /app

ADD ./users-api-1.0-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "./users-api-1.0-SNAPSHOT.jar"]