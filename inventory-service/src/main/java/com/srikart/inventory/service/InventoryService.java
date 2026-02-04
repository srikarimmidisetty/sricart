package com.srikart.inventory.service;

import com.srikart.inventory.dto.VehicleDTO;
import com.srikart.inventory.model.Vehicle;
import com.srikart.inventory.repository.VehicleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {
    
    private final VehicleRepository vehicleRepository;
    
    public List<VehicleDTO> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public VehicleDTO getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }
    
    public List<VehicleDTO> getVehiclesByType(String type) {
        return vehicleRepository.findByType(type)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public List<VehicleDTO> getVehiclesByBrand(String brand) {
        return vehicleRepository.findByBrand(brand)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    @Transactional
    public VehicleDTO addVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = convertToEntity(vehicleDTO);
        Vehicle saved = vehicleRepository.save(vehicle);
        return convertToDTO(saved);
    }
    
    private VehicleDTO convertToDTO(Vehicle vehicle) {
        VehicleDTO dto = new VehicleDTO();
        dto.setId(vehicle.getId());
        dto.setBrand(vehicle.getBrand());
        dto.setModel(vehicle.getModel());
        dto.setType(vehicle.getType());
        dto.setYear(vehicle.getYear());
        dto.setPrice(vehicle.getPrice());
        dto.setQuantity(vehicle.getQuantity());
        dto.setDescription(vehicle.getDescription());
        dto.setImageUrl(vehicle.getImageUrl());
        dto.setEngineCapacity(vehicle.getEngineCapacity());
        dto.setHorsePower(vehicle.getHorsePower());
        dto.setTopSpeed(vehicle.getTopSpeed());
        dto.setFuelType(vehicle.getFuelType().name());
        dto.setTransmission(vehicle.getTransmission());
        return dto;
    }
    
    private Vehicle convertToEntity(VehicleDTO dto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(dto.getBrand());
        vehicle.setModel(dto.getModel());
        vehicle.setType(dto.getType());
        vehicle.setYear(dto.getYear());
        vehicle.setPrice(dto.getPrice());
        vehicle.setQuantity(dto.getQuantity());
        vehicle.setDescription(dto.getDescription());
        vehicle.setImageUrl(dto.getImageUrl());
        vehicle.setEngineCapacity(dto.getEngineCapacity());
        vehicle.setHorsePower(dto.getHorsePower());
        vehicle.setTopSpeed(dto.getTopSpeed());
        vehicle.setFuelType(FuelType.valueOf(dto.getFuelType()));
        vehicle.setTransmission(dto.getTransmission());
        return vehicle;
    }
}
