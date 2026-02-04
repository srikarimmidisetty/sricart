package com.srikart.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    private Long id;
    private String brand;
    private String model;
    private String type;
    private Integer year;
    private BigDecimal price;
    private Integer quantity;
    private String description;
    private String imageUrl;
    private String engineCapacity;
    private Integer horsePower;
    private Integer topSpeed;
    private String fuelType;
    private String transmission;
}
