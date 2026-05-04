#Start with a base image containing Java Runtime
FROM eclipse-temurin:21-jdk

#Information around who maintains the image
LABEL maintainer="crazybytes.com"

#Add the application's jar to the image
COPY target/card-0.0.1-SNAPSHOT.jar card-0.0.1-SNAPSHOT.jar

# Expose the port that the application will run on
EXPOSE 9000

#execute the application
ENTRYPOINT ["java", "-jar", "card-0.0.1-SNAPSHOT.jar"]