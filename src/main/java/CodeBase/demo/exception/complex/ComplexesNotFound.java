package CodeBase.demo.exception.complex;

public class ComplexesNotFound extends RuntimeException {
    public ComplexesNotFound() {
        super("No sos dueño de un complejo");
    }
}
