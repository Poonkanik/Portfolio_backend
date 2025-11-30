# Use official Java 17 image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Give execute permission to mvnw (IMPORTANT)
RUN chmod +x mvnw

# Build the project (skip tests → faster)
RUN ./mvnw clean install -DskipTests

# Expose port used by Spring Boot
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]

