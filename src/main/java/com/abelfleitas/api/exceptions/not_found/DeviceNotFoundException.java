package com.abelfleitas.api.exceptions.not_found;

import com.abelfleitas.api.exceptions.base_exceptions.BaseNotFoundException;

public class DeviceNotFoundException extends BaseNotFoundException{

    public DeviceNotFoundException() {
        this.customCode = 40401;
        this.customMessage = "Device not found";
    }
    
}
