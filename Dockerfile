# Install Maven container
FROM maven:3.6.1-jdk-11 AS build

# Copy project files into image
COPY . /project/app

# Build Maven Project
WORKDIR /project/app
RUN mvn package

FROM openjdk:11-jre-slim
COPY --from=build /project/app/target/studenttracker-0.0.1-SNAPSHOT.jar /usr/local/lib/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]