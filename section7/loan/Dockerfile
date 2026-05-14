#Start with a base image containing Java Runtime
FROM eclipse-temurin:21-jdk

#Information around who maintains the image
LABEL maintainer="crazybytes.com"

#Add the application's jar to the image
COPY target/loan-0.0.1-SNAPSHOT.jar loan-0.0.1-SNAPSHOT.jar

# Expose the port that the application will run on
EXPOSE 8090

#execute the application
ENTRYPOINT ["java", "-jar", "loan-0.0.1-SNAPSHOT.jar"]