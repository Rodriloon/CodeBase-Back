package CodeBase.demo.exception;

import java.time.LocalDateTime;

import CodeBase.demo.exception.complex.ComplexNotFound;
import CodeBase.demo.exception.user.ForbiddenOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SuppressWarnings("unused")
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(FieldNotFound.class)
    public ResponseEntity<ErrorResponse> handleFieldNotFound(FieldNotFound ex) {
        return buildError(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(ComplexNotFound.class)
    public ResponseEntity<ErrorResponse> handleComplexNotFound(ComplexNotFound ex) {
        return buildError(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(ForbiddenOperation.class)
    public ResponseEntity<ErrorResponse> handleForbiddenOperation(ComplexNotFound ex) {
        return buildError(HttpStatus.FORBIDDEN, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult()
                .getFieldErrors()
                .getFirst()
                .getDefaultMessage();

        return buildError(HttpStatus.BAD_REQUEST, message);
    }

    private ResponseEntity<ErrorResponse> buildError(HttpStatus status, String message) {
        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                status.value(),
                status.name(),
                message,
                "" // Path can be injected or handled differently
        );
        return ResponseEntity.status(status).body(error);
    }
}
