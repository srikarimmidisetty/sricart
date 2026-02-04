package com.srikart.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    private Long vehicleId;
    private String vehicleName;
    private Integer quantity;
    private Double price;
}
