package io.onecraft.spring.presentation.support;

import io.onecraft.spring.domain.exception.TechnicalDesignNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class PresentationExceptionHandler {

    /**
     * This method is used to handle the TechnicalDesignNotFoundException exception. It is annotated with
     * {@link ExceptionHandler}, which is a Spring annotation used to specify that * the method should handle the given
     * exception.
     *
     * @param e The exception to handle.
     * @return The payload of the response.
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TechnicalDesignNotFoundException.class)
    public String handleTechnicalDesignNotFoundException(TechnicalDesignNotFoundException e) {
        return e.getMessage();
    }

    /**
     * This method is used to handle the MethodArgumentNotValidException exception. It is annotated with
     * {@link ExceptionHandler}, which is a Spring annotation used to specify that the method should handle the given
     * exception.
     *
     * @param ex The exception to handle.
     * @return The payload of the response.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
