FROM openjdk:11.0.16
WORKDIR /app
COPY ./target/tipocambio-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "tipocambio-0.0.1-SNAPSHOT.jar"]