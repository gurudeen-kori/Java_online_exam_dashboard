# Use a lightweight base image
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the packaged jar
COPY target/online-exam-dashboard-1.0.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
