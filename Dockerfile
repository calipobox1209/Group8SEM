FROM openjdk:latest
COPY ./target/Group8seMethods /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "Group8seMethods", "db:3306", "10000"]
