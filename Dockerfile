#
# Build stage
#
FROM maven:3.6.3-openjdk-11-slim AS build
COPY src /home/app/src/
COPY pom.xml /home/app/
WORKDIR /home/app/
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:11.0.10-jre-slim
COPY --from=build /home/app/target/auth-1.0.0.jar /usr/local/lib/auth-1.0.0.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/usr/local/lib/auth-1.0.0.jar"]