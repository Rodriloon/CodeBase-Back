package CodeBase.demo.exception;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(Long id) {
        super("Recurso con id " + id + " no encontrado");
    }
    public ResourceNotFound(String message) {
        super(message);
    }
}
