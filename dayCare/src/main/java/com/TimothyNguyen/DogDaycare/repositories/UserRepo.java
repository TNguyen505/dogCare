package com.TimothyNguyen.DogDaycare.repositories;

import com.TimothyNguyen.DogDaycare.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
