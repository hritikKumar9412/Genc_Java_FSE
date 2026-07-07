package com.hritik.springsecurityjwtpractice.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiError> handleBadCredentials(
            BadCredentialsException ex,
            HttpServletRequest request) {

        ApiError error = new ApiError(

                LocalDateTime.now(),

                HttpStatus.UNAUTHORIZED.value(),

                "Unauthorized",

                ex.getMessage(),

                request.getRequestURI()

        );

        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> validation(

            MethodArgumentNotValidException ex,

            HttpServletRequest request) {

        ApiError error = new ApiError(

                LocalDateTime.now(),

                HttpStatus.BAD_REQUEST.value(),

                "Validation Error",

                ex.getBindingResult()
                        .getFieldError()
                        .getDefaultMessage(),

                request.getRequestURI()

        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> exception(

            Exception ex,

            HttpServletRequest request) {

        ApiError error = new ApiError(

                LocalDateTime.now(),

                HttpStatus.INTERNAL_SERVER_ERROR.value(),

                "Internal Server Error",

                ex.getMessage(),

                request.getRequestURI()

        );

        return new ResponseEntity<>(error,
                HttpStatus.INTERNAL_SERVER_ERROR);

    }

}