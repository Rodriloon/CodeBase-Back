# CodeBase Backend - Plataforma White Label

Este es el backend de la plataforma White Label, diseñado para ser escalable y adaptable a múltiples tipos de negocios (Peluquerías, Canchas de Fútbol, Kioscos, etc.).

## 🚀 Tecnologías

- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA (Hibernate)**
- **PostgreSQL (Neon)**
- **OpenAPI / Swagger** (Documentación automática)
- **Lombok**

## 🏗 Arquitectura

El proyecto sigue una arquitectura en capas limpia y modular:

- **Model**: Entidades JPA con auditoría automática (`BaseEntity`).
- **Repository**: Capa de acceso a datos.
- **Service**: Lógica de negocio.
- **Controller**: Endpoints REST.
- **DTO**: Objetos de transferencia de datos (validaciones con Jakarta Validation).
- **Mapper**: Conversión entre Entidades y DTOs.

### Módulos Principales

1.  **Retail (Productos)**:
    -   Gestión de inventario para venta (snacks, bebidas, productos de belleza).
    -   Entidad: `Product`.

2.  **Reservas (Booking)**:
    -   Gestión de recursos y turnos.
    -   Entidades: `Resource` (Canchas, Profesionales) y `Booking` (Turnos).
    -   **Validación de conflictos**: El sistema impide automáticamente reservas superpuestas.

### Características Transversales
- **Auditoría**: Todos los modelos heredan de `BaseEntity` (`createdAt`, `updatedAt`).
- **Soft Delete**: El borrado es lógico (`deleted = true`), preservando la integridad histórica de los datos.

## 🛠 Configuración y Ejecución

1.  **Requisitos**: Java 21 instalado.
2.  **Variables de Entorno**:
    Configura las siguientes variables en tu entorno o en `src/main/resources/application.properties`:
    ```properties
    DB_URL=jdbc:postgresql://<tuhost>:5432/<tubase>
    DB_USERNAME=<usuario>
    DB_PASSWORD=<password>
    ```
3.  **Ejecutar**:
    ```bash
    ./mvnw spring-boot:run
    ```

## 📚 Documentación API

Una vez levantado el servidor, accede a la documentación interactiva en:
👉 **http://localhost:8080/swagger-ui.html**
