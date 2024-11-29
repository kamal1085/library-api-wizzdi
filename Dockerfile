#FROM maven:3.8.5-openjdk-11 AS build
#
#WORKDIR /app
#
#COPY pom.xml .
#COPY src ./src
#
#RUN mvn clean package -DskipTests
#
#FROM openjdk:11-jdk-slim
#
#WORKDIR /app
#
#COPY --from=build /app/target/compareNoCode-0.0.1-SNAPSHOT.jar app.jar
#
#EXPOSE 8080
#
## Run the application
#ENTRYPOINT ["java", "-jar", "app.jar"]
#
# Use Maven to build the application
FROM maven:3.8.5-openjdk-11 AS build

# Set working directory
WORKDIR /app

# Copy project files
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use a lightweight Java image for runtime
FROM openjdk:11-jdk-slim

# Set working directory
WORKDIR /app

# Copy JAR file from build stage
COPY --from=build /app/target/compareNoCode-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
