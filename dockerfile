
FROM adoptopenjdk:11-jdk-hotspot


WORKDIR /app


COPY . /app


RUN ./gradlew build


EXPOSE 8080

CMD ["java", "-jar", "todolist.jar"]
