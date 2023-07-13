package com.TimothyNguyen.DogDaycare.dto;

import com.TimothyNguyen.DogDaycare.models.Image;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDto {
    Long orderId;
    String dogName;
    String dogBreed;
    LocalDateTime dayCareDate;
    String groomingServices;
    String description;
    private List<Image> images;
}
