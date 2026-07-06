package com.arjunkumarpandey.HospitalManagementSystem.security;

import com.arjunkumarpandey.HospitalManagementSystem.dto.LoginRequestDto;
import com.arjunkumarpandey.HospitalManagementSystem.dto.LoginResponseDto;
import com.arjunkumarpandey.HospitalManagementSystem.dto.SignupResponseDto;
import com.arjunkumarpandey.HospitalManagementSystem.entity.User;
import com.arjunkumarpandey.HospitalManagementSystem.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthService {
    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final PasswordEncoder passwordEncoder;
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword())
        );
        User user = (User) authentication.getPrincipal();
        String token = authUtil.generateAccessToken(user);
        return new LoginResponseDto(token,user.getId());
    }

    public SignupResponseDto signup(LoginRequestDto signupRequestDto) {
        User user = userRepo.findByUsername(signupRequestDto.getUsername()).orElse(null);

        if(user != null) throw new IllegalArgumentException("User already exists");

        user = userRepo.save(User.builder()
                .username(signupRequestDto.getUsername())
                .password(passwordEncoder.encode(signupRequestDto.getPassword()))
                .build()
        );

        return new SignupResponseDto(user.getId(), user.getUsername());
    }
}

