package com.TimothyNguyen.DogDaycare.services;

import com.TimothyNguyen.DogDaycare.mappers.UserMapper;
import com.TimothyNguyen.DogDaycare.repositories.UserRepo;
import com.TimothyNguyen.DogDaycare.dto.UserDto;
import com.TimothyNguyen.DogDaycare.models.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class AuthService {
    private UserRepo userRepo;
    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;


    public UserDto createUser(UserDto userDto){
        if(userRepo.findByEmail(userDto.getEmail()).isPresent()){
            throw new RuntimeException("user with this email already exist");
        }else{
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
            User user =userMapper.toUser(userDto);
            return userMapper.toUserDto(userRepo.save(user));
        }

    }

}
