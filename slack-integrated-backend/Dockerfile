FROM eclipse-temurin:17

LABEL maintainer="jackmu@umich.edu"

WORKDIR /app

COPY target/auth-backend.jar /app/auth-backend.jar

ENTRYPOINT ["java", "-jar", "auth-backend.jar"]