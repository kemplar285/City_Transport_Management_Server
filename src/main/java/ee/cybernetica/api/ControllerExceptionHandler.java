package ee.cybernetica.api;

import ee.cybernetica.exception.BusLineNotFoundException;
import ee.cybernetica.exception.BusNotFoundException;
import ee.cybernetica.exception.BusStopNotFoundException;
import ee.cybernetica.model.ErrorMessage;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ErrorMessage> handleMediaTypeExceptions(HttpMediaTypeNotSupportedException ex){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setDetail("Request body must be " + MediaType.APPLICATION_JSON_VALUE);
        errorMessage.setTitle(ex.getMessage());
        errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        String errorDetail = "";
        for (FieldError error : ex.getFieldErrors()) {
            errorDetail = errorDetail + error;
        }
        errorMessage.setDetail(errorDetail);
        errorMessage.setTitle("Validation failed");
        errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusLineNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleBusLineNotFoundExceptions(BusLineNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setDetail(ex.getMessage());
        errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorMessage.setTitle(HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleBusNotFoundExceptions(BusNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setDetail(ex.getMessage());
        errorMessage.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorMessage.setTitle(HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BusStopNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleBusNotFoundExceptions(BusStopNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setDetail(ex.getMessage());
        errorMessage.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorMessage.setTitle(HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorMessage> handleMessageNotReadableExceptions(HttpMessageNotReadableException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setDetail("Request body is not readable");
        errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorMessage.setTitle(HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorMessage> handleIllegalArgumentExceptions(IllegalArgumentException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setDetail(ex.getMessage());
        errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorMessage.setTitle("Illegal argument");
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorMessage> handleRequestMethodNotSupportedExceptions(HttpRequestMethodNotSupportedException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setDetail(ex.getMessage());
        errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorMessage.setTitle("Illegal argument");
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> handleConstraintViolationExceptions(ConstraintViolationException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setDetail(ex.getMessage());
        errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorMessage.setTitle("Constraint violation");
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorMessage> handleConstraintViolationExceptions(DataIntegrityViolationException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setDetail("Unable to make changes");
        errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorMessage.setTitle("Data integrity violation");
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ErrorMessage> handleEmptyResultDataAccessExceptions(EmptyResultDataAccessException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setDetail(ex.getMessage());
        errorMessage.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorMessage.setTitle("Not found");
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }





}
