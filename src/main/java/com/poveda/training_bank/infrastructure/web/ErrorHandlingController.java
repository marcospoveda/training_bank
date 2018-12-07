package com.poveda.training_bank.infrastructure.web;

import com.poveda.training_bank.infrastructure.exceptions.*;
import com.poveda.training_bank.infrastructure.web.resources.ErrorHandlerResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorHandlingController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorHandlerResult resourceNotFound(final NotFoundException exception, HttpServletRequest request){
        return new ErrorHandlerResult(request.getRequestURI()).addErrors(exception.getMessage(), HttpStatus.NOT_FOUND.value());
    }


    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorHandlerResult badrequest(final ValidationException exception, HttpServletRequest request){
        return new ErrorHandlerResult(request.getRequestURI()).addErrors(exception.getErrors().toString(), HttpStatus.BAD_REQUEST.value());
    }

}
