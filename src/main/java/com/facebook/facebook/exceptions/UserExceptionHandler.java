package com.facebook.facebook.exceptions;

import com.facebook.facebook.modal.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;

@RestControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<Response> productExceptionHandler(UserException productException) {
        String exceptionMessage = productException.getMessage();
        Response response = Response.builder().statusCode(HttpStatus.BAD_REQUEST.value()).data(new ArrayList<>()).message(exceptionMessage).build();
        System.out.println(response);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Response> usernameNotFoundException(UserException productException) {
        String exceptionMessage = productException.getMessage();
        Response response = Response.builder().statusCode(HttpStatus.BAD_REQUEST.value()).data(new ArrayList<>()).message(exceptionMessage).build();
        System.out.println(response);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
