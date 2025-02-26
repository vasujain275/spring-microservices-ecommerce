package me.vasujain.microservices.order_service.service;

import lombok.AllArgsConstructor;
import me.vasujain.microservices.order_service.dto.OrderRequest;
import me.vasujain.microservices.order_service.model.Order;
import me.vasujain.microservices.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order placeOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .orderNumber(orderRequest.getOrderNumber())
                .skuCode(orderRequest.getSkuCode())
                .quantity(orderRequest.getQuantity())
                .price(orderRequest.getPrice())
                .build();

        return orderRepository.save(order);
    }

}
