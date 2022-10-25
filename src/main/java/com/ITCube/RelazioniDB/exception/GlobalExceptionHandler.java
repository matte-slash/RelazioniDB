package com.ITCube.RelazioniDB.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object>
    handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                 HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String,Object> body= new HashMap<String,Object>();

        List<String> errors=ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x->x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> handleBookNotFoundException(
            BookNotFoundException ex,WebRequest request){

        Map<String,Object> body=new HashMap<>();

        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<Object> handleAuthorNotFoundException(
            BookNotFoundException ex,WebRequest request){

        Map<String,Object> body=new HashMap<>();

        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Object> handleIllegalStateException(
            BookNotFoundException ex,WebRequest request){

        Map<String,Object> body=new HashMap<>();

        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(
            ConstraintViolationException ex, WebRequest request){

        Map<String,Object> body=new HashMap<>();

        body.put("messaage", ex.getMessage());

        return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);
    }

}