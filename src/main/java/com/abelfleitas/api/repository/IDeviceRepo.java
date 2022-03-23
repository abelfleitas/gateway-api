package com.abelfleitas.api.repository;

import java.util.List;
import java.util.UUID;
import com.abelfleitas.api.models.Device;
import com.abelfleitas.api.models.Gateway;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeviceRepo extends JpaRepository<Device, UUID> {

    public List<Device> findAllByGateway(Gateway gateway);
    
    //public List<Device> findAllByGateway(Gateway gateway, Pageable pageable);
}
