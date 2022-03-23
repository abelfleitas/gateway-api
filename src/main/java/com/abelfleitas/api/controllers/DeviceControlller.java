package com.abelfleitas.api.controllers;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import com.abelfleitas.api.exceptions.bad_request.DateBadRequestException;
import com.abelfleitas.api.exceptions.bad_request.GatewayLimitBadRequestException;
import com.abelfleitas.api.exceptions.not_found.DeviceNotFoundException;
import com.abelfleitas.api.exceptions.not_found.GatewayNotFoundException;
import com.abelfleitas.api.models.Device;
import com.abelfleitas.api.models.Gateway;
import com.abelfleitas.api.repository.IDeviceRepo;
import com.abelfleitas.api.repository.IGatewayRepo;
import com.abelfleitas.api.request.AddDeviceRequest;
import com.abelfleitas.api.request.UpdateDeviceRequest;
import com.abelfleitas.api.response.DeviceResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/device")
public class DeviceControlller {
    
    private IDeviceRepo deviceRepo; 
    private IGatewayRepo gatewayRepo;
    private ModelMapper modelMapper;

    @Autowired
    public DeviceControlller(IDeviceRepo deviceRepo, IGatewayRepo gatewayRepo, ModelMapper modelMapper) {
        this.deviceRepo = deviceRepo;
        this.gatewayRepo = gatewayRepo;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<DeviceResponse> add(@RequestBody AddDeviceRequest request) throws  
    GatewayNotFoundException, GatewayLimitBadRequestException {        
        Gateway gateway = this.gatewayRepo.getById(request.getGatewayId());
        if (gateway == null) {
            throw new GatewayNotFoundException();
        }
        if (gateway.getDevices().size() < 10) {
            Device device = new Device(UUID.randomUUID(), request.getVendor(), new Date(), request.getStatus(), gateway);
            Device result = this.deviceRepo.save(device);
            DeviceResponse response = modelMapper.map(result, DeviceResponse.class);
            return ResponseEntity.ok(response);
        } else {
            throw new GatewayLimitBadRequestException();
        } 
    } 

    @GetMapping("/list")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Collection<DeviceResponse>> getDevices() {
        List<Device> devices = this.deviceRepo.findAll();
        Collection<DeviceResponse> response = devices.stream()
            .map(device -> modelMapper.map(device, DeviceResponse.class))
            .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    } 

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<DeviceResponse> getDevice(@PathVariable(value = "id") UUID id) throws DeviceNotFoundException {
        Device device = this.deviceRepo.getById(id);
        if (device == null) {
            throw new DeviceNotFoundException();
        }
        DeviceResponse response = modelMapper.map(device, DeviceResponse.class);
        return ResponseEntity.ok(response);
    } 

    @PutMapping("update/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<DeviceResponse> updateDevice(@PathVariable(value = "id") UUID id,  @RequestBody UpdateDeviceRequest request) throws DeviceNotFoundException,
     GatewayNotFoundException, DateBadRequestException {
        Device device = this.deviceRepo.findById(id).get();
        if (device == null) {
            throw new DeviceNotFoundException();
        }
       
        Gateway gateway = this.gatewayRepo.getById(request.getGatewayId());
        if (gateway == null) {
            throw new GatewayNotFoundException();
        }
        device.setVendor(request.getVendor());
        device.setCreated(new Date());
        device.setStatus(request.getStatus());
        device.setGateway(gateway);
        device = this.deviceRepo.save(device);
        DeviceResponse response = modelMapper.map(device, DeviceResponse.class);
        return ResponseEntity.ok(response);
    } 

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Integer> deleteDevices(@PathVariable(value = "id") UUID id) throws DeviceNotFoundException {
        Device device = this.deviceRepo.findById(id).get();
        if(device == null) {
            throw new DeviceNotFoundException();
        }
        this.deviceRepo.delete(device);
        return ResponseEntity.ok(HttpStatus.OK.value());
    } 

    @GetMapping("/by-gateway/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Collection<DeviceResponse>> getDeviceFromGateway(@PathVariable(name = "id") int gatewayId) throws GatewayNotFoundException {
        Gateway gateway = this.gatewayRepo.getById(gatewayId);
        if (gateway == null) {
            throw new GatewayNotFoundException();
        }
        List<Device> devices = this.deviceRepo.findAllByGateway(gateway);
        Collection<DeviceResponse> response = devices.stream()
            .map(device -> modelMapper.map(device, DeviceResponse.class))
            .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    } 
}
