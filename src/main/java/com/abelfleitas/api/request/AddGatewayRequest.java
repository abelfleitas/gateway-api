package com.abelfleitas.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;


public class AddGatewayRequest {

    @JsonProperty("serialNumber")
    private String serialNumber;
    @JsonProperty("ip4")
    private String ip4;
    @JsonProperty("name")
    private String name;

    public AddGatewayRequest(String serialNumber, String ip4, String name){
        this.serialNumber = serialNumber;
        this.ip4 = ip4;
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getIp4() {
        return ip4;
    }

    public void setIp4(String ip4) {
        this.ip4 = ip4;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
