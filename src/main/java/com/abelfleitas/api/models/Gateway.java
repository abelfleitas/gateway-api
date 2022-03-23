package com.abelfleitas.api.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.NonNull;

@Entity
public class Gateway {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique=true)
    @NonNull
    private String serialNumber;
    @NonNull
    @Column(unique=true)
    private String ip4;
    @NonNull
    private String name;
    @OneToMany(mappedBy = "gateway",targetEntity = Device.class, cascade = CascadeType.ALL)
    private List<Device> devices;
    
    public Gateway() {
        
    }

    public Gateway(int id, String serialNumber, String name, String ip4, List<Device> devices) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.name = name;
        this.ip4 = ip4;
        this.devices = devices;
    }

    public Gateway(String serialNumber, String ip4, String name) {
        this.serialNumber = serialNumber;
        this.ip4 = ip4;
        this.name = name;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp4() {
        return ip4;
    }

    public void setIp4(String ip4) {
        this.ip4 = ip4;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    

}
