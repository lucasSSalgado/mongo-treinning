package treining.mongo.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ObjNotFindException.class)
    public ResponseEntity<StandartError> objNotFound(ObjNotFindException obj, HttpServletRequest request) {
        String msg = "Erro de Requisicao";
        HttpStatus status = HttpStatus.NOT_FOUND;
        Instant instant = Instant.now();
        StandartError se = new StandartError(msg, status.value(), instant, obj.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(se);
    }
}
