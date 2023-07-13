package com.TimothyNguyen.DogDaycare.controllers;

import com.TimothyNguyen.DogDaycare.repositories.OrderRepo;
import com.TimothyNguyen.DogDaycare.dto.OrderDto;
import com.TimothyNguyen.DogDaycare.mappers.OrderMapper;
import com.TimothyNguyen.DogDaycare.models.Order;
import com.TimothyNguyen.DogDaycare.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;
    private OrderRepo orderRepo;
    private OrderMapper orderMapper;
    @PostMapping(value={"/save/order"},consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public OrderDto createBooking(@RequestPart("orderDto") OrderDto orderDto, @RequestPart(value = "images") List<MultipartFile> images) throws IOException {
        return orderService.saveOrder(orderDto,images);
    }
    @GetMapping("/orders")
    public Page<OrderDto>  getOrders(@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "10") Integer size)  {
            Pageable pageable = PageRequest.of(page-1, size, Sort.by("orderId").descending());

        Page <Order> orders=orderRepo.findAll(pageable);
        List<OrderDto> orderDtos = orders.getContent().stream()
                .map(orderMapper::toOrderDto)
                .collect(Collectors.toList());
        return  new PageImpl<>(orderDtos, pageable, orders.getTotalElements());
    }
    @GetMapping("/order")
    public ResponseEntity<OrderDto> getOrder(@RequestParam Long orderId)  {
        OrderDto orderDto=orderService.getOrderById(orderId);
        return ResponseEntity.status(HttpStatus.OK).body(orderDto);
    }
}
