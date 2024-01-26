# Use a base image with JDK and Maven
FROM maven:3.8.4-jdk-11 AS builder

# Set the working directory
WORKDIR /app

# Copy the entire project
COPY . .

# Build the project
RUN mvn clean install -DskipTests

# Use a smaller base image for the runtime
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy necessary artifacts from the builder image
COPY --from=builder /app/security/target/*.jar security.jar
COPY --from=builder /app/common/target/*.jar common.jar
COPY --from=builder /app/service/target/*.jar service.jar
COPY --from=builder /app/repository/target/*.jar repository.jar

# Expose the ports your applications will run on (adjust as needed)
EXPOSE 8081 8082 8083 8084

# Command to run the applications
CMD ["java", "-jar", "security.jar"]
CMD ["java", "-jar", "common.jar"]
CMD ["java", "-jar", "service.jar"]
CMD ["java", "-jar", "repository.jar"]