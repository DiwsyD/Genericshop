package com.stepit.lecture.genericshop.address.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class AddressesNotFoundException extends RuntimeException {

    private final HttpStatus status = HttpStatus.BAD_REQUEST;
    private final String title = "Data not found";
    private final String MESSAGE = "Reason: %s";
    private String details;

    public AddressesNotFoundException(String message) {
        super(message);
        details = message;
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE, details);
    }

}
