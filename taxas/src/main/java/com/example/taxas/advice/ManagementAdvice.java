package com.example.taxas.advice;

import com.example.taxas.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ManagementAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Errors> handleValidationExceptions(MethodArgumentNotValidException exception) {
        List<Errors> errors = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError ->
                errors.add(new Errors(fieldError.getField(), fieldError.getDefaultMessage()))
        );
        return errors;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Errors handleResourceNotFound(ResourceNotFoundException exception) {
        return new Errors("resource", exception.getMessage());
    }
}
