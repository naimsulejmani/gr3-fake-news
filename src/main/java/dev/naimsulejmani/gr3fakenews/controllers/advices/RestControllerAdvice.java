package dev.naimsulejmani.gr3fakenews.controllers.advices;


import dev.naimsulejmani.gr3fakenews.dtos.ErrorResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException e, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setStatusMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
        errorResponse.setErrorMessage(e.getMessage());
        errorResponse.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }


    @ExceptionHandler({IllegalArgumentException.class, DataIntegrityViolationException.class})
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(Exception e, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setStatusMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorResponse.setErrorMessage(e.getMessage());
        errorResponse.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> handleExcepion(Exception e, HttpServletRequest request) {
//
//        int status = HttpStatus.INTERNAL_SERVER_ERROR.value();
//        String statusMessage = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
//        ErrorResponse errorResponse = new ErrorResponse();
//        errorResponse.setErrorMessage(e.getMessage());
//        errorResponse.setPath(request.getRequestURI());
//
//        if(e instanceof IllegalArgumentException) {
//            status = HttpStatus.BAD_REQUEST.value();
//            statusMessage = HttpStatus.BAD_REQUEST.getReasonPhrase();
//        } else if(e instanceof EntityNotFoundException) {
//            status = HttpStatus.NOT_FOUND.value();
//            statusMessage = HttpStatus.NOT_FOUND.getReasonPhrase();
//        }
//
//
//        return ResponseEntity.status(status).body(errorResponse);
//    }
}
