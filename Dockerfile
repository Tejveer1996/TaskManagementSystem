FROM openjdk:17-jdk

COPY target/TaskManagementSystem.jar .

EXPOSE 8080

ENTRYPOINT ["java","-jar","TaskManagementSystem.jar"]
