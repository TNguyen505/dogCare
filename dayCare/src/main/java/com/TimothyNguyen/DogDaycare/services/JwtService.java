package com.TimothyNguyen.DogDaycare.services;

import com.TimothyNguyen.DogDaycare.repositories.UserRepo;
import com.TimothyNguyen.DogDaycare.config.JwtUtil;
import com.TimothyNguyen.DogDaycare.dto.LoginRequest;
import com.TimothyNguyen.DogDaycare.dto.LoginResponse;
import com.TimothyNguyen.DogDaycare.mappers.UserMapper;
import com.TimothyNguyen.DogDaycare.models.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class JwtService implements UserDetailsService {
    private JwtUtil jwtUtil;
    private UserRepo userRepository;
    private UserMapper userMapper;
    public LoginResponse createJwtToken(LoginRequest loginRequest) throws Exception {
        String email = loginRequest.getEmail();
        String userPassword = loginRequest.getPassword();
        UserDetails userDetails = loadUserByUsername(email);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        User user = userRepository.findByEmail(email).get();
        return new LoginResponse(userMapper.toUserDto(user), newGeneratedToken);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).get();

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    true,
                    true,
                    true,
                    true,
                    getAuthority(user)

            );
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    private Set getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;

    }
}