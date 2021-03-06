package nl.novi.lindeboom.web2packflow.exception;

import nl.novi.lindeboom.web2packflow.payload.response.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Date;

/**
 * GlobalExceptionHandler handles all exceptions thrown as a result of an API request
 * payload.response.ErrorResponse.class is used to provide a default structure for the error message
 * handled errors:
 * - Validation error
 * – record not found
 * – Error processing JSON data
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ErrorResponse errorResponse = new ErrorResponse(new Date(), "Validation error",
                ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> exception(RecordNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(new Date(), "Record not found",
                "");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

        @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<Object> exception(DataIntegrityViolationException ex) {
            ErrorResponse errorResponse = new ErrorResponse(new Date(), "Error processing JSON data",
                    ex.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
