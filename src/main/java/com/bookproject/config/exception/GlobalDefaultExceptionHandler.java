package com.bookproject.config.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    private final ExceptionMessage exceptionMessage;

    public GlobalDefaultExceptionHandler(ExceptionMessage exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ExceptionResponse> notFoundExceptionHandler(NotFoundException e) {

        log.error("Error [{}]", e.getMessage());
        String message = exceptionMessage.getMessage(e.getErrorCode());
        ExceptionResponse exceptionResponse = new ExceptionResponse(e.getErrorCode(), message);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
