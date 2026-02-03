package CodeBase.demo.exception.user;

public class ForbiddenOperation extends RuntimeException {
    public ForbiddenOperation(String message) {
        super(message);
    }
}
