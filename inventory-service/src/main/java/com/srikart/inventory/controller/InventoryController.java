package com.srikart.inventory.controller;

import com.srikart.inventory.model.Vehicle;
import com.srikart.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
    
    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return ResponseEntity.ok(inventoryService.getAllVehicles());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Vehicle vehicle = inventoryService.getVehicleById(id);
        return vehicle != null ? ResponseEntity.ok(vehicle) : ResponseEntity.notFound().build();
    }
    
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Vehicle>> getVehiclesByType(@PathVariable String type) {
        return ResponseEntity.ok(inventoryService.getVehiclesByType(type));
    }
    
    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Vehicle>> getVehiclesByBrand(@PathVariable String brand) {
        return ResponseEntity.ok(inventoryService.getVehiclesByBrand(brand));
    }
}
