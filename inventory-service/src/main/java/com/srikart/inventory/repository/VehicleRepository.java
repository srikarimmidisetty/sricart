package com.srikart.inventory.repository;

import com.srikart.inventory.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByType(String type);
    List<Vehicle> findByBrand(String brand);
    List<Vehicle> findByTypeAndBrand(String type, String brand);
}
