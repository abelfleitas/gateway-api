package com.abelfleitas.api.repository;

import com.abelfleitas.api.models.Gateway;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGatewayRepo extends JpaRepository<Gateway, Integer> {
    
}
