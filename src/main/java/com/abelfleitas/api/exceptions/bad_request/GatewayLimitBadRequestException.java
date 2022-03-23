package com.abelfleitas.api.exceptions.bad_request;

import com.abelfleitas.api.exceptions.base_exceptions.BaseBadRequestException;

public class GatewayLimitBadRequestException extends BaseBadRequestException {

    public GatewayLimitBadRequestException() {
        this.customCode = 40001;
        this.customMessage = "Limit of devices connected to a gateway reached";
    }
    
}
