FROM openjdk:14

ENV ENVIRONMENT=prod

MAINTAINER Thanh Duong <thanh.duong2503@hotmail.de>

ADD backend/target/todo.jar app.jar

CMD [ "sh", "-c", "java -Dserver.port=$PORT -Dspring.data.mongodb.uri=$MONGODB_URI -jar /app.jar" ]