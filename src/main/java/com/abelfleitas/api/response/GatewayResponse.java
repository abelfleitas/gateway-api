package com.abelfleitas.api.response;

import java.util.Collection;

public class GatewayResponse {

    private int id;
    private String serialNumber;
    private String ip4;
    private String name;
    private Collection<DeviceResponse> devices;

    public GatewayResponse(int id, String serialNumber, String ip4, String name, Collection<DeviceResponse> devices) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.ip4 = ip4;
        this.name = name;
        this.devices = devices;
    }

    public GatewayResponse(int id, String serialNumber, String ip4, String name) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.ip4 = ip4;
        this.name = name;
    }

    public GatewayResponse() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Collection<DeviceResponse> getDevices() {
        return devices;
    }

    public void setDevices(Collection<DeviceResponse> diveces) {
        this.devices = diveces;
    }

}
