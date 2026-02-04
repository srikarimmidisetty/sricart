package com.srikart.inventory.service;

import com.srikart.inventory.model.Vehicle;
import com.srikart.inventory.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final VehicleRepository vehicleRepository;
    
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
    
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }
    
    public List<Vehicle> getVehiclesByType(String type) {
        return vehicleRepository.findByType(type);
    }
}
