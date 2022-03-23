package com.abelfleitas.api.exceptions.base_exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class BaseForbiddenException extends CustomBaseException {
    
    public BaseForbiddenException() {
        httpCode = HttpStatus.FORBIDDEN.value();
    }

    public BaseForbiddenException(String message) {
        super(message);
        httpCode = HttpStatus.FORBIDDEN.value();
    }
}
