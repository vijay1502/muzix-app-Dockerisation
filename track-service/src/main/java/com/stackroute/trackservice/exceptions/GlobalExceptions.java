package com.stackroute.trackservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {
    @ExceptionHandler(TrackNotFoundException.class)
    public ResponseEntity<?> noTrackFound(TrackNotFoundException e){
        return new ResponseEntity<String>("Track Not Found", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TrackIdAlreadyExistsException.class)
    public ResponseEntity<?> idAlreadyExists(TrackIdAlreadyExistsException ex){
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllException(Exception ex){
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
    }
}
