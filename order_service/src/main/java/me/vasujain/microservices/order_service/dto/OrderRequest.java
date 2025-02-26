package me.vasujain.microservices.order_service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderRequest {
    private String orderNumber;
    private String skuCode;
    private Integer quantity;
    private BigDecimal price;
}
