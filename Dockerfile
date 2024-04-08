FROM eclipse-temurin:17-jdk-focal

WORKDIR /trainApp

COPY .mvn .mvn
COPY  mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY  src ./src
COPY flyway ./flyway

CMD ["./mvnw", "spring-boot:run"]