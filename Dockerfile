# Use official Java 17 image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# FIX mvnw PERMISSION
RUN chmod +x mvnw

# Build project
RUN ./mvnw clean install -DskipTests

# Expose port
EXPOSE 8080

# Run application
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]
