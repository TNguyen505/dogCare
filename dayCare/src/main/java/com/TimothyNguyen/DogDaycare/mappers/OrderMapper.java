package com.TimothyNguyen.DogDaycare.mappers;

import com.TimothyNguyen.DogDaycare.models.Order;
import com.TimothyNguyen.DogDaycare.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "images", expression = "java(order.getImages())")
    OrderDto toOrderDto(Order order);
    Order toOrder(OrderDto orderDto);
}
