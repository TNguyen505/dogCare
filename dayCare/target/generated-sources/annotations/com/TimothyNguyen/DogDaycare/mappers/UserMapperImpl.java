package com.TimothyNguyen.DogDaycare.mappers;

import com.TimothyNguyen.DogDaycare.dto.UserDto;
import com.TimothyNguyen.DogDaycare.models.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-13T01:41:54-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_382 (IBM Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setEmail( user.getEmail() );
        userDto.setPassword( user.getPassword() );
        userDto.setName( user.getName() );
        userDto.setPhoneNumber( user.getPhoneNumber() );
        userDto.setAddress( user.getAddress() );

        return userDto;
    }

    @Override
    public User toUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setName( userDto.getName() );
        user.setEmail( userDto.getEmail() );
        user.setPassword( userDto.getPassword() );
        user.setPhoneNumber( userDto.getPhoneNumber() );
        user.setAddress( userDto.getAddress() );

        return user;
    }
}
