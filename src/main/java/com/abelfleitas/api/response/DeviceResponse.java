package com.abelfleitas.api.response;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Enumerated;

import com.abelfleitas.api.models.enums.StatusEnum;

public class DeviceResponse { 

    private UUID id;
    private String vendor;
    private Date created;
    @Enumerated
    private StatusEnum  status;
    private int gatewayId; 
    
    public DeviceResponse(UUID id, String vendor, Date created, StatusEnum status, int gatewayId) {
        this.id = id;
        this.vendor = vendor;
        this.created = created;
        this.status = status;
        this.gatewayId = gatewayId;
    }

    public DeviceResponse() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
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
