package com.example.demo.service;

import com.example.demo.dtos.UserLoginDto;
import com.example.demo.dtos.UserResponseDto;
import com.example.demo.dtos.UserSignupDto;

public interface UserService {
    UserResponseDto signup(UserSignupDto request);

    UserResponseDto login(UserLoginDto userLoginDto);
}
