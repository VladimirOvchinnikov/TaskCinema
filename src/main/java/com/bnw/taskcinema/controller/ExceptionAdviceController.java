package com.bnw.taskcinema.controller;


import com.bnw.taskcinema.dto.common.ResponseDto;
import com.bnw.taskcinema.exception.HeaderParseException;
import com.bnw.taskcinema.exception.NotDefaultValueException;
import com.bnw.taskcinema.exception.NotHeadersException;
import com.bnw.taskcinema.exception.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdviceController {


    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ResponseDto> handleValidationException(ValidationException e) {
        ResponseDto response = new ResponseDto();
        response.setId("-1");
        response.setCode("sssss");
        response.setError(e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(NotDefaultValueException.class)
    public ResponseEntity<ResponseDto> handleNotDefaultValueException(NotDefaultValueException e) {
        ResponseDto response = new ResponseDto();
        response.setId("-1");
        response.setCode("sssss");
        response.setError(e.getMessage());
        return ResponseEntity.internalServerError().body(response);
    }

    @ExceptionHandler(NotHeadersException.class)
    public ResponseEntity<ResponseDto> handleNotHeadersException(NotHeadersException e) {
        ResponseDto response = new ResponseDto();
        response.setId("-1");
        response.setCode("sssss");
        response.setError(e.getMessage());
        return ResponseEntity.internalServerError().body(response);
    }


    @ExceptionHandler(HeaderParseException.class)
    public ResponseEntity<ResponseDto> handleHeaderParseException(HeaderParseException e) {
        ResponseDto response = new ResponseDto();
        response.setId(e.getId());
        response.setCode(e.getCode());
        response.setError(e.getMessage());
        return ResponseEntity.internalServerError().body(response);
    }

}
