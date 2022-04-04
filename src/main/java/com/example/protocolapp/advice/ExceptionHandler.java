package com.example.protocolapp.advice;

import com.example.protocolapp.exception.ProtocolNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @org.springframework.web.bind.annotation.ExceptionHandler(ProtocolNotFoundException.class)
    public String answerNotFoundHandler(ProtocolNotFoundException ex){
        return ex.getMessage();
    }
}
