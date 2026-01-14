# ⚽ Fútbol Manager 5 - Backend API

Backend para la plataforma de gestión de canchas deportivas "Fútbol Manager 5" (versión White Label). Desarrollado con **Java 21** y **Spring Boot 3**.

## 🚀 Tecnologías

*   **Java 21**: Lenguaje principal.
*   **Spring Boot 3**: Framework de aplicación.
*   **Spring Data JPA**: Persistencia de datos.
*   **H2 Database**: Base de datos en memoria para desarrollo (se reinicia con la app).
*   **PostgreSQL**: (Soporte configurado para producción).
*   **Lombok**: Reducción de boilerplate code.
*   **Swagger / OpenAPI**: Documentación de API.

## 🏗️ Arquitectura

El proyecto sigue una arquitectura en capas limpia para facilitar el mantenimiento y la adaptación a otros negocios (White Label):

```
src/main/java/CodeBase/demo/
├── controller/  # Endpoints REST (API Layer)
├── service/     # Lógica de Negocio (Business Layer)
├── repository/  # Acceso a Datos (Data Layer)
├── model/       # Entidades JPA (Domain Layer)
├── dto/         # Data Transfer Objects
├── mapper/      # Conversión entre Entity <-> DTO
├── config/      # Configuraciones (CORS, DataLoader)
└── exception/   # Manejo global de errores
```

### Principales Entidades

*   **Field**: Representa una cancha (atributos: superficie, capacidad, techada).
*   **Booking**: Reserva asociada a una cancha y un cliente.
*   **BaseEntity**: Clase padre con ID, Auditoría (creado/modificado) y Soft Delete.

## ⚙️ Configuración y Ejecución

**Requisito Importante**: Asegúrate de tener **JDK 21** instalado y configurado.

### Ejecutar Localmente

1.  Clonar el repositorio.
2.  Configurar la variable `JAVA_HOME` si no está en el PATH del sistema (ejemplo en PowerShell):
    ```powershell
    $env:JAVA_HOME = 'C:\Users\rodri\Downloads\OpenJDK21U-jdk_x64_windows_hotspot_21.0.9_10\jdk-21.0.9+10'
    ```
3.  Ejecutar con Maven Wrapper:
    ```powershell
    ./mvnw spring-boot:run
    ```
4.  La API estará disponible en `http://localhost:8080`.

### Datos de Prueba

El sistema incluye un **DataLoader** que carga automáticamente 3 canchas de ejemplo si la base de datos está vacía al iniciar.

## 🔌 API Endpoints (Ejemplos)

*   `GET /api/v1/fields`: Listar todas las canchas.
*   `POST /api/v1/fields`: Crear una nueva cancha.
*   `POST /api/v1/bookings`: Crear una reserva (verifica conflictos de horario).
    ```bash
    ./mvnw spring-boot:run
    ```

## 📚 Documentación API

Una vez levantado el servidor, accede a la documentación interactiva en:
👉 **http://localhost:8080/swagger-ui.html**
