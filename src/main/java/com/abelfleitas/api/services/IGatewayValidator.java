package com.abelfleitas.api.services;

import com.abelfleitas.api.exceptions.base_exceptions.BaseBadRequestException;
import com.abelfleitas.api.request.AddGatewayRequest;
import com.abelfleitas.api.request.UpdateGatewayRequest;

import org.springframework.stereotype.Service;

@Service
public interface IGatewayValidator {
    
    void validator(AddGatewayRequest request) throws BaseBadRequestException; 

    void validator(UpdateGatewayRequest request) throws BaseBadRequestException; 
}
