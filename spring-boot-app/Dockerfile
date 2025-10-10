# -------- builder stage --------
FROM maven:3.9.9-eclipse-temurin-17 AS builder
WORKDIR /workspace

COPY spring-boot-app/pom.xml spring-boot-app/pom.xml
RUN mvn -f spring-boot-app/pom.xml -B dependency:go-offline

COPY spring-boot-app/ spring-boot-app/
RUN mvn -f spring-boot-app/pom.xml -B -DskipTests clean package

# -------- runtime stage --------
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

COPY --from=builder /workspace/spring-boot-app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
