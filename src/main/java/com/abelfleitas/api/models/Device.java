package com.abelfleitas.api.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.abelfleitas.api.models.enums.StatusEnum;


@Entity
public class Device {

    @Id
    @Column(unique = true, nullable = false)
    private UUID id;
    private String vendor;
    private Date created;
    @Enumerated
    private StatusEnum  status;
    @ManyToOne
    @JoinColumn(name = "gatewayId")
    private Gateway gateway;
    
    public Device(UUID id, String vendor, Date created, StatusEnum status, Gateway gateway) {
        this.id = id;
        this.vendor = vendor;
        this.created = created;
        this.status = status;
        this.gateway = gateway;
    }

    public Device(String vendor, Date created, StatusEnum status, Gateway gateway) {
        this.vendor = vendor;
        this.created = created;
        this.status = status;
        this.gateway = gateway;
    }

    public Device() {}

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

    public Gateway getGateway() {
        return gateway;
    }

    public void setGateway(Gateway gateway) {
        this.gateway = gateway;
    }
}
