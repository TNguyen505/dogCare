package com.TimothyNguyen.DogDaycare.mappers;

import com.TimothyNguyen.DogDaycare.dto.UserDto;
import com.TimothyNguyen.DogDaycare.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);
    User toUser(UserDto userDto);

}
