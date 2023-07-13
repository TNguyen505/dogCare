package com.TimothyNguyen.DogDaycare.repositories;

import com.TimothyNguyen.DogDaycare.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<Image, Long> {
}
