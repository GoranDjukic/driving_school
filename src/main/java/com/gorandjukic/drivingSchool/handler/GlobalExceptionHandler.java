package com.gorandjukic.drivingSchool.handler;

import com.gorandjukic.drivingSchool.domain.exception.GenericBadRequestException;
import com.gorandjukic.drivingSchool.domain.exception.GenericNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GenericNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(GenericNotFoundException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.name()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GenericBadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(GenericBadRequestException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.name()), HttpStatus.BAD_REQUEST);
    }

    public static class ErrorResponse {
        private final String message;
        private final String code;

        public ErrorResponse(String message, String code) {
            this.message = message;
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public String getCode() {
            return code;
        }
    }

}
