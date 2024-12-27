package dev.naimsulejmani.gr3fakenews.controllers.advices;


import dev.naimsulejmani.gr3fakenews.dtos.ErrorResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@ControllerAdvice
public class RestControllerAdvice {

//    @ExceptionHandler(EntityNotFoundException.class)
//    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException e, HttpServletRequest request) {
//        ErrorResponse errorResponse = new ErrorResponse();
//        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
//        errorResponse.setStatusMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
//        errorResponse.setErrorMessage(e.getMessage());
//        errorResponse.setPath(request.getRequestURI());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
//    }
//
//
//    @ExceptionHandler({IllegalArgumentException.class, DataIntegrityViolationException.class})
//    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(Exception e, HttpServletRequest request) {
//        ErrorResponse errorResponse = new ErrorResponse();
//        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
//        errorResponse.setStatusMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
//        errorResponse.setErrorMessage(e.getMessage());
//        errorResponse.setPath(request.getRequestURI());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(e.getMessage());
        errorResponse.setPath(request.getRequestURI());
        errorResponse.setMethod(request.getMethod());

        if (e instanceof EntityNotFoundException || e instanceof UsernameNotFoundException) {
            status = HttpStatus.NOT_FOUND;
        } else if (e instanceof IllegalArgumentException ||
                e instanceof DataIntegrityViolationException ||
                e instanceof MethodArgumentNotValidException ||
                e instanceof HandlerMethodValidationException ||
                e instanceof ConstraintViolationException
        ) {
            status = HttpStatus.BAD_REQUEST;
        }

//        if(e instanceof HandlerMethodValidationException hm) {
//            hm.getParameterValidationResults().stream()
//                    .forEach(v-> errorResponse.setErrorMessage(errorResponse.getErrorMessage())+"; "+v.toString());
//        }

//        switch (e) {
//            case EntityNotFoundException ex1 -> status = HttpStatus.NOT_FOUND;
//            case UsernameNotFoundException ex2 -> status = HttpStatus.NOT_FOUND;
//            case IllegalArgumentException ex3 -> status = HttpStatus.BAD_REQUEST;
//            case DataIntegrityViolationException ex4 -> status = HttpStatus.BAD_REQUEST;
//            case MethodArgumentNotValidException ex5 -> status = HttpStatus.BAD_REQUEST;
//            default -> status = HttpStatus.INTERNAL_SERVER_ERROR;
//        }

        errorResponse.setStatus(status.value());
        errorResponse.setStatusMessage(status.getReasonPhrase());
        return ResponseEntity.status(status).body(errorResponse);
    }
}
