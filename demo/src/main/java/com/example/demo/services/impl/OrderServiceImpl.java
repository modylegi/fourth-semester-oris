package com.example.demo.services.impl;

import com.example.demo.dto.OrderDto;
import com.example.demo.entities.Order;
import com.example.demo.entities.Product;
import com.example.demo.mappers.OrderMapper;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public List<OrderDto> getOrders() {
        return orderMapper.toDto(orderRepository.findAll());
    }

    @Override
    public OrderDto createOrder(Order order) {

//        Optional<Product> productOptional = orderRepository.findProductBy(product.getName());
//        if(productOptional.isPresent()){
//            throw new IllegalStateException("Product with this name already exists");
//        }
        order.setTime(LocalDateTime.now());
        return orderMapper.toDto(orderRepository.save(order));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public void deleteOrder(Long orderId) {
        boolean exists = orderRepository.existsById(orderId);
        if(!exists){
            throw new IllegalStateException("product with id " + orderId + " not exists");
        }
        orderRepository.deleteById(orderId);

    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public OrderDto updateOrder(Long orderId, String name, String description, int price) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new IllegalStateException(
                "order with id " + orderId + " does not exist"
        ));
//        if(name != null && name.length() > 0 && !Objects.equals(product.getName(), name)){
//            product.setName(name);
//        }
//        if(description != null && description.length() > 0 && !Objects.equals(product.getDescription(), description)){
//            product.setDescription(description);
//        }
//        if(price != 0  && !Objects.equals(product.getPrice(), price)){
//            product.setPrice(price);
//        }
        return orderMapper.toDto(order);
    }
}
