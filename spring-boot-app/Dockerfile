# -------- builder stage --------
FROM maven:3.9.9-eclipse-temurin-17 AS builder
WORKDIR /workspace

# copy only the pom first to leverage docker cache for dependencies
COPY spring-boot-app/pom.xml spring-boot-app/pom.xml
RUN mvn -f spring-boot-app/pom.xml -B dependency:go-offline

# copy sources and build
COPY spring-boot-app/ spring-boot-app/
RUN mvn -f spring-boot-app/pom.xml -B -DskipTests clean package

# -------- runtime stage --------
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# copy the jar from builder (adjust if your artifact name differs)
COPY --from=builder /workspace/spring-boot-app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
