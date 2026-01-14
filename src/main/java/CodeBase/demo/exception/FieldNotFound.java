package CodeBase.demo.exception;

public class FieldNotFound extends RuntimeException {
    public FieldNotFound(Long id) {
        super("Cancha con id " + id + " no encontrada");
    }
    public FieldNotFound(String message) {
        super(message);
    }
}
