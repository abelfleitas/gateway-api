package com.abelfleitas.api.exceptions.bad_request;

import com.abelfleitas.api.exceptions.base_exceptions.BaseBadRequestException;

public class DateBadRequestException extends BaseBadRequestException{

    public DateBadRequestException(String message) {
        super(message);
    }
    
}
