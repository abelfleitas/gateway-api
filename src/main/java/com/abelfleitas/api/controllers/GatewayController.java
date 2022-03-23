package com.abelfleitas.api.controllers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.abelfleitas.api.exceptions.bad_request.DateBaseException;
import com.abelfleitas.api.exceptions.not_found.GatewayNotFoundException;
import com.abelfleitas.api.models.Gateway;
import com.abelfleitas.api.repository.IGatewayRepo;
import com.abelfleitas.api.request.AddGatewayRequest;
import com.abelfleitas.api.request.UpdateGatewayRequest;
import com.abelfleitas.api.response.GatewayResponse;

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
@RequestMapping("api/gateway")
public class GatewayController {
    
    private IGatewayRepo gatewayRepo;
    private ModelMapper modelMapper;
    
    @Autowired
    public GatewayController(IGatewayRepo gatewayRepo, ModelMapper modelMapper){
        this.gatewayRepo = gatewayRepo;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<GatewayResponse> add(@RequestBody AddGatewayRequest request)
    throws DateBaseException {
        Gateway gateway = new Gateway(request.getSerialNumber(),request.getIp4(),request.getName());
        Gateway result = this.gatewayRepo.save(gateway);
        try {
            result = this.gatewayRepo.save(gateway);
        } catch(Exception ex){
            throw new DateBaseException(ex.getMessage());
        }
        GatewayResponse response = modelMapper.map(result, GatewayResponse.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Collection<GatewayResponse>> list(){
        List<Gateway> gateways = this.gatewayRepo.findAll();
        Collection<GatewayResponse> response = gateways.stream()
            .map(gateway -> modelMapper.map(gateway, GatewayResponse.class))
            .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<GatewayResponse> getGatway(@PathVariable(value ="id") int id) throws GatewayNotFoundException {
        Gateway gateway = gatewayRepo.findById(id).get();
        if(gateway == null) {
           throw new GatewayNotFoundException();
        }
        GatewayResponse response = modelMapper.map(gateway, GatewayResponse.class);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<GatewayResponse> updateGateway(@PathVariable(value = "id") int id, @RequestBody UpdateGatewayRequest request) throws GatewayNotFoundException {
        Gateway gateway = this.gatewayRepo.findById(id).get();
        if(gateway == null) {
            throw new GatewayNotFoundException();
        }
        gateway.setSerialNumber(request.getSerialNumber());
        gateway.setIp4(request.getIp4());
        gateway.setName(request.getName());
        Gateway result = this.gatewayRepo.save(gateway);
        GatewayResponse response = modelMapper.map(result, GatewayResponse.class);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity <Integer> deleteGateway(@PathVariable(value = "id") int id) throws GatewayNotFoundException {
        Gateway gateway = this.gatewayRepo.findById(id).get();
        if (gateway == null) {
            throw new GatewayNotFoundException();
        }
        this.gatewayRepo.delete(gateway);
        return ResponseEntity.ok(HttpStatus.OK.value());
    }
}
