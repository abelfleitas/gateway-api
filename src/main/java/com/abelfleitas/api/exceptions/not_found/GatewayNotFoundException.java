package com.abelfleitas.api.exceptions.not_found;

import com.abelfleitas.api.exceptions.base_exceptions.BaseNotFoundException;

public class GatewayNotFoundException extends BaseNotFoundException{

    public GatewayNotFoundException() {
        this.customCode = 40401;
        this.customMessage = "Gateway not found";
    }
    
}
