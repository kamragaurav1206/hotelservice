package com.yash.hotelservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> handlerResourceNotFoundException(ResourceNotFoundException exception){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setMessage(exception.getMessage());
        apiResponse.setStatusCode(HttpStatus.NOT_FOUND);
        apiResponse.setSuccess(true);
        return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<APIResponse>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<APIResponse> apiResponses = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach((error)->{
            APIResponse apiResponse = new APIResponse();
            apiResponse.setMessage(error.getDefaultMessage());
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST);
            apiResponse.setSuccess(false);
            apiResponses.add(apiResponse);
        });
        return ResponseEntity.badRequest().body(apiResponses);
    }

}
