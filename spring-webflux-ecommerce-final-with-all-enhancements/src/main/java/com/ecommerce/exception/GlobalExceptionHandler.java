
package com.ecommerce.exception;

import com.ecommerce.wrapper.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleAllExceptions(Exception ex) {
        logger.error("Unexpected exception occurred: ", ex);
        return new ResponseEntity<>(new ApiResponse("An unexpected error occurred"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
