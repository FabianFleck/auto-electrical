package br.com.auto.electrical.error;

import br.com.auto.electrical.error.exception.BadRequestException;
import br.com.auto.electrical.error.exception.UnprocessableEntityException;
import br.com.auto.electrical.error.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ApiError apiError = new ApiError(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal server error",
                ex.getLocalizedMessage());
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequestException(BadRequestException ex, WebRequest request) {
        ApiError apiError = new ApiError(
                ex.getStatus().value(),
                "Error from BadRequestException",
                ex.getLocalizedMessage());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<ApiError> handleUnprocessableEntityException(UnprocessableEntityException ex, WebRequest request) {
        ApiError apiError = new ApiError(
                ex.getStatus().value(),
                "Error from UnprocessableEntityException",
                ex.getLocalizedMessage());
        return new ResponseEntity<>(apiError, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
