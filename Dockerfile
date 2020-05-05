FROM openjdk:11.0-jre

COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]