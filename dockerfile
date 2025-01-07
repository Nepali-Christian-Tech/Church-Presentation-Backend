# Use the official OpenJDK image as a base
FROM openjdk:22-jdk

# Set the working directory
WORKDIR /app

# Copy the entire project to the container
COPY . .

# Build the JAR file without using cache
RUN ./gradlew build -x test --no-cache

# Copy the Spring Boot jar file into the container
COPY build/libs/church-presentation-backend-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]