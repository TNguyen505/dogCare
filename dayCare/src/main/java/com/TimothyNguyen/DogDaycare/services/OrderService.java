package com.TimothyNguyen.DogDaycare.services;

import com.TimothyNguyen.DogDaycare.repositories.ImageRepo;
import com.TimothyNguyen.DogDaycare.repositories.OrderRepo;
import com.TimothyNguyen.DogDaycare.dto.OrderDto;
import com.TimothyNguyen.DogDaycare.mappers.OrderMapper;
import com.TimothyNguyen.DogDaycare.models.Image;
import com.TimothyNguyen.DogDaycare.models.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class OrderService {
    private OrderRepo orderRepo;
    private OrderMapper orderMapper;
    private ImageRepo imageRepo;
    public OrderDto saveOrder(OrderDto orderDto, List<MultipartFile> images) throws IOException {
        List<Image> imagesList =new ArrayList<>();
        Order order=orderMapper.toOrder(orderDto);
        for (MultipartFile file:images
        ) {
            Image image=new Image();
            image.setName(file.getOriginalFilename());
            image.setType(file.getContentType());
            image.setPicture(file.getBytes());
            image.setOrder(order);
            imagesList.add(image);
            imageRepo.save(image);
        }
        order.setImages(imagesList);
        return orderMapper.toOrderDto(orderRepo.save(order));
    }

    public List<OrderDto> getOrders() {
        List <OrderDto> orderDtoList=orderRepo.findAll().stream().map(orderMapper ::toOrderDto).collect(Collectors.toList());
        return orderDtoList;
    }

    public OrderDto getOrderById(Long orderId) {
        return orderMapper.toOrderDto(orderRepo.findById(orderId).get());
    }
}
