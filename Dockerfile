FROM bellsoft/liberica-openjdk-debian:21

WORKDIR /app

COPY target/moex-api-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]