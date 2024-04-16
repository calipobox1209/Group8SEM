FROM openjdk:latest
COPY ./target/popApplication /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "popApplication", "db:3306", "10000"]
