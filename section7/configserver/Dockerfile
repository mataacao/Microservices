#Start with a base image containing Java Runtime
FROM eclipse-temurin:21-jdk-jammy

#Information around who maintains the image
LABEL maintainer="crazybytes.com"

RUN apt-get update && \
    apt-get install -y ca-certificates && \
    update-ca-certificates

#Add the application's jar to the image
COPY target/configserver-0.0.1-SNAPSHOT.jar configserver-0.0.1-SNAPSHOT.jar

# Expose the port that the application will run on
EXPOSE 8071

#execute the application
ENTRYPOINT ["java", "-jar", "configserver-0.0.1-SNAPSHOT.jar"]