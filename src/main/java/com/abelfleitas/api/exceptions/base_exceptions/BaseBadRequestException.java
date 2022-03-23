package com.abelfleitas.api.exceptions.base_exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BaseBadRequestException extends CustomBaseException {

    public BaseBadRequestException() {
        httpCode = HttpStatus.BAD_REQUEST.value();
    }

    public BaseBadRequestException(String message) {
        super(message);
        httpCode = HttpStatus.BAD_REQUEST.value();
    }
    
}
