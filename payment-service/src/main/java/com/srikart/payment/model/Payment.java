package com.srikart.payment.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Payment {
    private Long id;
    private Long orderId;
    private Double amount;
    private LocalDateTime paymentDate;
    private String status;
    private String paymentMethod;
}
