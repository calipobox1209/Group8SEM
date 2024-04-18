FROM openjdk:latest
COPY ./target/Group8seMethods.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "Group8seMethods.jar", "db:3306", "10000"]
