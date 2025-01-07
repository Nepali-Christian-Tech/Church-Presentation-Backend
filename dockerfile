# Use the official OpenJDK image as a base
FROM openjdk:22-jdk

# Set the working directory
WORKDIR /backend
COPY . /backend
CMD ["./gradlew", "clean", "bootJar"]
COPY build/libs/church-presentation-backend-0.0.1-SNAPSHOT.jar app.jar
# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
