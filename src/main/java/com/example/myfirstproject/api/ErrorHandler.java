package com.example.myfirstproject.api;

import com.example.myfirstproject.exception.AppError;
import com.example.myfirstproject.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler (CustomerNotFoundException.class)
    public ResponseEntity<AppError> handleCustomerNotFoundException(CustomerNotFoundException exception, WebRequest webRequest) {
        AppError appError = new AppError();
        appError.setCode(1919);
        appError.setMsg(exception.getMessage());
        return new ResponseEntity<>(appError, HttpStatus.NOT_FOUND);
    }
}
