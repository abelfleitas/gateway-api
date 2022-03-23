package com.abelfleitas.api.request;

import com.abelfleitas.api.models.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateDeviceRequest {

    @JsonProperty("vendor")
    private String vendor;

    @JsonProperty("status")
    private StatusEnum status;

    @JsonProperty("gatewayId")
    private int gatewayId;

    public UpdateDeviceRequest(String vendor, StatusEnum status, int gatewayId) {
        this.vendor = vendor;
        this.status = status;
        this.gatewayId = gatewayId;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public int getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(int gatewayId) {
        this.gatewayId = gatewayId;
    }
}
