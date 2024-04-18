FROM openjdk:latest
COPY ./target/Group8seMethods-0.1.0.2.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "Group8seMethods", "db:3306", "10000"]
