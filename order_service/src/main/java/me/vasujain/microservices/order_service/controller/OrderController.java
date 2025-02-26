package me.vasujain.microservices.order_service.controller;

import lombok.AllArgsConstructor;
import me.vasujain.microservices.order_service.dto.OrderRequest;
import me.vasujain.microservices.order_service.model.Order;
import me.vasujain.microservices.order_service.response.ApiResponse;
import me.vasujain.microservices.order_service.response.ResponseUtil;
import me.vasujain.microservices.order_service.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResponse<?>> placeOrder(OrderRequest orderRequest) {
        Order order = orderService.placeOrder(orderRequest);
        return ResponseUtil.ok(order, "Order placed successfully");
    }
}
