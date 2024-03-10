
package com.ecommerce.handler;

import com.ecommerce.controller.ProductOfferController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ServerWebInputException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ProductOfferController.class);

    @ExceptionHandler(ServerWebInputException.class)
    public ResponseEntity<String> handleServerWebInputException(ServerWebInputException ex) {
        logger.error("Exception caught in GlobalExceptionHandler: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    // More exception handlers can be added as needed

}
