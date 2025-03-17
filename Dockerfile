# Base image with Java 17
FROM openjdk:17
#Work directory in the container
WORKDIR /app
#Copy JAR file at container
COPY target/viveLibre-app-0.0.1-SNAPSHOT.jar app.jar
# Port running the app
EXPOSE 8081
#Command to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
