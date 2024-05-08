package com.stepit.lecture.genericshop.exception.handler;


import com.stepit.lecture.genericshop.address.exception.AddressesNotFoundException;
import com.stepit.lecture.genericshop.exception.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Log4j2
@RestControllerAdvice
@SuppressWarnings("unused")
public class GlobalExceptionHandler extends DefaultHandlerExceptionResolver {

    @ExceptionHandler(AddressesNotFoundException.class)
    public ResponseEntity<Object> handleAddressesNotFoundException(HttpServletRequest request, AddressesNotFoundException exception) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(exception.getStatus().value())
                .type(exception.getStatus().getReasonPhrase())
                .title(exception.getTitle())
                .error(exception.getClass().getSimpleName())
                .details(exception.getDetails())
                .timestamp(Timestamp.valueOf(LocalDateTime.now()))
                .build();
        log.error(errorResponse);
        return new ResponseEntity<>(errorResponse, exception.getStatus());
    }

}
