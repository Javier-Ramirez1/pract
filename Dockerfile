# Imagen base con Java 17
FROM eclipse-temurin:17

# Carpeta dentro del contenedor
WORKDIR /app

# Copiar el jar generado
COPY target/*.jar app.jar

# Puerto de Spring Boot
EXPOSE 8080

# Ejecutar la app
ENTRYPOINT ["java","-jar","app.jar"]