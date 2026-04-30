FROM eclipse-temurin:25-alpine AS builder

WORKDIR /app

COPY mvnw .

COPY .mvn .mvn

COPY pom.xml .

COPY src src

RUN ./mvnw dependency:resolve

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:25-jre-alpine AS runner

WORKDIR /app

COPY --from=builder /app/target/*jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]