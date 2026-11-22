FROM eclipse-temurin:24-jre

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 10000

ENTRYPOINT ["java", "-jar", "app.jar"]