FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY . . 


RUN mvn clean install

FROM openjdk:17-alpine


COPY --from=build /app/target/teste-pougos-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]

