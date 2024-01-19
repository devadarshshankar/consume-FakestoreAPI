package dev.adarsh.productservice.controllers;

import dev.adarsh.productservice.dtos.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler
    private ResponseEntity<ErrorResponseDto> handleNotFoundException(Exception exception){
        ErrorResponseDto errorResponseDto=new ErrorResponseDto();
        errorResponseDto.setMessage(exception.getMessage());

        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }
}
