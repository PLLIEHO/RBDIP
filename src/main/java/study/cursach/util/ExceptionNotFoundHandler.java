package study.cursach.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionNotFoundHandler {
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<?> handleNotFound(Throwable ex) {
        return ResponseEntity.status(404).body("Wrong url");
    }
}