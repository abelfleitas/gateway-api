package com.abelfleitas.api.exceptions.base_exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class BaseUnauthorizedException extends CustomBaseException{

    public BaseUnauthorizedException() {
        httpCode = HttpStatus.UNAUTHORIZED.value();
    }

    public BaseUnauthorizedException(String message) {
        super(message);
        httpCode = HttpStatus.UNAUTHORIZED.value();
    }
    
}
