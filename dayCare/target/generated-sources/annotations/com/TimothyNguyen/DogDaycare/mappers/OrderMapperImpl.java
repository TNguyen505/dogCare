package com.TimothyNguyen.DogDaycare.mappers;

import com.TimothyNguyen.DogDaycare.dto.OrderDto;
import com.TimothyNguyen.DogDaycare.models.Image;
import com.TimothyNguyen.DogDaycare.models.Order;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-13T01:41:54-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_382 (IBM Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDto toOrderDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setOrderId( order.getOrderId() );
        orderDto.setDogName( order.getDogName() );
        orderDto.setDogBreed( order.getDogBreed() );
        orderDto.setDayCareDate( order.getDayCareDate() );
        orderDto.setGroomingServices( order.getGroomingServices() );
        orderDto.setDescription( order.getDescription() );

        orderDto.setImages( order.getImages() );

        return orderDto;
    }

    @Override
    public Order toOrder(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        Order order = new Order();

        order.setOrderId( orderDto.getOrderId() );
        order.setDogName( orderDto.getDogName() );
        order.setDogBreed( orderDto.getDogBreed() );
        order.setDayCareDate( orderDto.getDayCareDate() );
        order.setGroomingServices( orderDto.getGroomingServices() );
        order.setDescription( orderDto.getDescription() );
        List<Image> list = orderDto.getImages();
        if ( list != null ) {
            order.setImages( new ArrayList<Image>( list ) );
        }

        return order;
    }
}
