package CodeBase.demo.exception;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound(Long id) {
        super("Producto con id " + id + " no encontrado");
    }
}
