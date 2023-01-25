package com.example.football_aggregator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    protected ResponseEntity<Object> handleApiRequestException(ApiRequestException exception){
        //1.Create payload containing exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(
                exception.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("GMT+2"))
        );
        //2.Return response entity
        return new ResponseEntity<>(apiException,badRequest);
    }
}
