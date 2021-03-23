package com.ayantsoft.springbootdeploy.springbootdeploy.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationControllerAdvice.class);

    @ExceptionHandler(value = { InvalidInputException.class })
    public ResponseEntity<String> handleInvalidInputException(InvalidInputException ex) {
    	logger.error("Invalid Input Exception: ",ex.getMessage());
        return new ResponseEntity<String>("Invalid Input Exception",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { ResourceNotFoundException.class })
    public ResponseEntity<String> HandleResourceNotFoundException(ResourceNotFoundException ex) {
    	logger.error("ResourceNotFoundException: ",ex.getMessage());
        return new ResponseEntity<String>("Resource Not Found",HttpStatus.BAD_REQUEST);
    }
	
	
}
