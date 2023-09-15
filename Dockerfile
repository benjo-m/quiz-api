FROM amazoncorretto:17
WORKDIR /app
COPY ./target/quiz-api-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "quiz-api-0.0.1-SNAPSHOT.jar"]