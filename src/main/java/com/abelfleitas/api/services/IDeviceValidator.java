package com.abelfleitas.api.services;

import com.abelfleitas.api.exceptions.base_exceptions.BaseBadRequestException;
import com.abelfleitas.api.request.AddDeviceRequest;
import com.abelfleitas.api.request.UpdateDeviceRequest;

import org.springframework.stereotype.Service;

@Service
public interface IDeviceValidator {

    void validator(AddDeviceRequest request) throws BaseBadRequestException; 

    void validator(UpdateDeviceRequest request) throws BaseBadRequestException; 
}
