package com.example.messagingclustering.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.ConnectException;
import java.rmi.ConnectIOException;

@RestController
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = ConnectionRefusedException.class)
    public ResponseEntity handleJmsException(){

        ApiError error =new ApiError("Connection refused");
        return new ResponseEntity<ApiError>(error,HttpStatus.BAD_REQUEST);
    }
}
