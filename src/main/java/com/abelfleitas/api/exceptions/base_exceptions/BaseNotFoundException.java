package com.abelfleitas.api.exceptions.base_exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BaseNotFoundException extends CustomBaseException{
    
    public BaseNotFoundException() {
        httpCode = HttpStatus.BAD_REQUEST.value();
    }

    public BaseNotFoundException(String message) {
        super(message);
        httpCode = HttpStatus.BAD_REQUEST.value();
    }
}
