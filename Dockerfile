# Use an official lightweight OpenJDK runtime as the base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file into the image
COPY .

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
