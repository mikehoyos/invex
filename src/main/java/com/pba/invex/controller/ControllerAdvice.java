package com.pba.invex.controller;

import com.pba.invex.exceptions.BusinessExeptions;
import com.pba.invex.exceptions.ErrorVO;
import com.pba.invex.exceptions.RequestExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorVO> runtimeExceptionHandler(RuntimeException ex){
        ErrorVO error = ErrorVO.builder().code("E-XXX").message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RequestExceptions.class)
    public ResponseEntity<ErrorVO> requestExceptionHandler(RequestExceptions ex){
        ErrorVO error = ErrorVO.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = BusinessExeptions.class)
    public ResponseEntity<ErrorVO> businessExceptionHandler(BusinessExeptions ex){
        ErrorVO error = ErrorVO.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
