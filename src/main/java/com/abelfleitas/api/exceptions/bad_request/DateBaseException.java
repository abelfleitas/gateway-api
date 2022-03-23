package com.abelfleitas.api.exceptions.bad_request;

import com.abelfleitas.api.exceptions.base_exceptions.BaseBadRequestException;

public class DateBaseException extends BaseBadRequestException {
    
    public DateBaseException(String message) {
        super(message);
    }
}
