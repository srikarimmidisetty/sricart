package com.srikart.inventory.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "vehicles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String brand;
    
    @Column(nullable = false)
    private String model;
    
    @Column(nullable = false)
    private String type;
    
    @Column(nullable = false)
    private Integer year;
    
    @Column(nullable = false)
    private BigDecimal price;
    
    @Column(nullable = false)
    private Integer quantity;
    
    @Column(length = 1000)
    private String description;
    
    @Column(name = "image_url")
    private String imageUrl;
    
    @Column(name = "engine_capacity")
    private String engineCapacity;
    
    @Column(name = "horse_power")
    private Integer horsePower;
    
    @Column(name = "top_speed")
    private Integer topSpeed;
    
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;
    
    @Column(name = "transmission")
    private String transmission;
}

enum FuelType {
    PETROL, DIESEL, ELECTRIC, HYBRID
}
