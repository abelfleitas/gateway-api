package com.abelfleitas.api.services.impl;

import com.abelfleitas.api.exceptions.base_exceptions.BaseBadRequestException;
import com.abelfleitas.api.request.AddDeviceRequest;
import com.abelfleitas.api.request.UpdateDeviceRequest;
import com.abelfleitas.api.services.IDeviceValidator;
import org.springframework.stereotype.Component;

@Component
public class DeviceValidator implements IDeviceValidator {

    @Override
    public void validator(AddDeviceRequest request) throws BaseBadRequestException {
        if (request.getVendor() == null || request.getVendor().isEmpty()){
            message("the field name is required");
        }
        else if (request.getStatus() == null){
            message("the field name is required");
        }
    }

    @Override
    public void validator(UpdateDeviceRequest request) throws BaseBadRequestException {
        if (request.getVendor() == null || request.getVendor().isEmpty()){
            message("the field name is required");
        }
        else if (request.getStatus() == null){
            message("the field name is required");
        }
    }

    private void message(String message) throws BaseBadRequestException {
        throw new BaseBadRequestException(message);
    }
}
