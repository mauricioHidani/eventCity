package com.devsuperior.demo.controllers.handlers;

import com.devsuperior.demo.dto.ExceptionResponse;
import com.devsuperior.demo.services.exceptions.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Clock;
import java.time.Instant;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(NotFoundException e,
                                                              HttpServletRequest req) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ExceptionResponse res = ExceptionResponse
                .builder()
                .timestamp(Instant.now(Clock.systemUTC()))
                .status(status.value())
                .error(e.getMessage())
                .path(req.getRequestURI())
                .build();

        return ResponseEntity
                .status(status)
                .body(res);
    }
}
