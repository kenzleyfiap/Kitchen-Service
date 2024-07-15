FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY target/kitchen-1.0.0.jar kitchen-1.0.0.jar

EXPOSE 8084
CMD ["java","-jar","product-1.0.0.jar"]