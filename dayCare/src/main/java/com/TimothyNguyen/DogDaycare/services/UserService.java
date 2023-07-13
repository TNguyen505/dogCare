package com.TimothyNguyen.DogDaycare.services;

import com.TimothyNguyen.DogDaycare.repositories.UserRepo;
import com.TimothyNguyen.DogDaycare.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UserService {
    private UserRepo userRepo;
    private UserMapper userMapper;

}
