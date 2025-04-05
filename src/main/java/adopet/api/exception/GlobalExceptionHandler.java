package adopet.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> trataException(Exception ex) {

        var statusHttp = HttpStatus.BAD_REQUEST;

        ResponseError response = new ResponseError(
                ex.getMessage(),
                statusHttp,
                LocalDateTime.now()
        );

        return ResponseEntity.status(statusHttp).body(response);

    }

}
