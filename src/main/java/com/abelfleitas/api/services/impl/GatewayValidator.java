package com.abelfleitas.api.services.impl;

import com.abelfleitas.api.exceptions.base_exceptions.BaseBadRequestException;
import com.abelfleitas.api.request.AddGatewayRequest;
import com.abelfleitas.api.request.UpdateGatewayRequest;
import com.abelfleitas.api.services.IGatewayValidator;
import org.springframework.stereotype.Component;

@Component
public class GatewayValidator implements IGatewayValidator{

    @Override
    public void validator(AddGatewayRequest request) throws BaseBadRequestException {
        if (request.getSerialNumber() == null || request.getSerialNumber().isEmpty()){
            message("the serial number is required");
        }
        else if (request.getIp4() == null || request.getIp4().isEmpty()){
            message("the IPv4 is required");
        }
        else if(IsValidIp4(request.getIp4())){
            message("the IPv4 is not valid");
        }
        else if (request.getName() == null || request.getName().isEmpty()){
            message("the name is required");
        }
    }

    @Override
    public void validator(UpdateGatewayRequest request) throws BaseBadRequestException {
        if (request.getSerialNumber() == null || request.getSerialNumber().isEmpty()){
            message("the serial number is required");
        }
        else if (request.getIp4() == null || request.getIp4().isEmpty()){
            message("the IPv4 is required");
        }
        else if(IsValidIp4(request.getIp4())){
            message("the IPv4 is not valid");
        }
        else if (request.getName() == null || request.getName().isEmpty()){
            message("the name is required");
        }
    }

    private void message(String message) throws BaseBadRequestException {
        throw new BaseBadRequestException(message);
    }

    private boolean IsValidIp4(String ip4) {
        String PATTERN = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
        return ip4.matches(PATTERN);
    }
}
