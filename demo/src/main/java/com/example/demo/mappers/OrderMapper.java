package com.example.demo.mappers;

import com.example.demo.dto.OrderDto;
import com.example.demo.entities.Order;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);
    List<OrderDto> toDto(List<Order> product);
}
