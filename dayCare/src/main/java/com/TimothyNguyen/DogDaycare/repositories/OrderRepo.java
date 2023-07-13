package com.TimothyNguyen.DogDaycare.repositories;

import com.TimothyNguyen.DogDaycare.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
