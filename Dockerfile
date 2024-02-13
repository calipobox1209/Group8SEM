FROM openjdk:latest
COPY ./target/Group8seMethods-0.1.0.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "Group8seMethods-0.1.0.1-jar-with-dependencies.jar"]