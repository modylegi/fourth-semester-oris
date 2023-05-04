package com.example.demo.controllers;

import com.example.demo.dto.OrderDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.entities.Order;
import com.example.demo.entities.Product;
import com.example.demo.services.OrderService;
import com.example.demo.services.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }

    @PostMapping
    public ResponseEntity<OrderDto> createProduct(@RequestBody Order order){
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @DeleteMapping(path = "{orderId}")
    public void deleteProduct(@PathVariable("orderId") Long orderId){
        orderService.deleteOrder(orderId);
    }

    @Transactional
    @PutMapping(path ="{orderId}")
    public ResponseEntity<ProductDto> updateOrder(
            @PathVariable("orderId") Long productId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) int price) {
        return ResponseEntity.ok(orderService.updateOrder(productId, name, description, price));
    }
}
