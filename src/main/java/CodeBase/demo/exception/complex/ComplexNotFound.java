package CodeBase.demo.exception.complex;

public class ComplexNotFound extends RuntimeException {
    public ComplexNotFound(Long id) {
        super("Cancha con id " + id + " no encontrada");
    }
}
