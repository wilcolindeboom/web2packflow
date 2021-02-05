package nl.novi.lindeboom.web2packflow.exception;


import nl.novi.lindeboom.web2packflow.payload.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ErrorResponse errorResponse = new ErrorResponse(new Date(), "Validation error",
                ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


//    @ExceptionHandler(value = RecordNotFoundException.class)
//    public ResponseEntity<Object> exception(RecordNotFoundException exception) {
//        return ResponseEntity.notFound().build();
//    }
//
//    @ExceptionHandler(value = BadRequestException.class)
//    public ResponseEntity<Object> exception(BadRequestException exception) {
//        return ResponseEntity.badRequest().build();
//    }
//
//    @ExceptionHandler(value = UserNotFoundException.class)
//    public ResponseEntity<Object> exception(UserNotFoundException exception) {
//        return ResponseEntity.badRequest().build();
//    }
//
//    @ExceptionHandler(value = ForbiddenException.class)
//    public ResponseEntity<Object> exception(ForbiddenException exception) {
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
//    }

}
