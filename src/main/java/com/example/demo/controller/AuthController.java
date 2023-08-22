package com.example.demo.controller;

import com.example.demo.dtos.ApiResponse;
import com.example.demo.dtos.UserLoginDto;
import com.example.demo.dtos.UserResponseDto;
import com.example.demo.dtos.UserSignupDto;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userServices;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<UserResponseDto>> createUser(@RequestBody UserSignupDto userSignupDto) {

        return ResponseEntity.ok().body(new ApiResponse<>("User signup successful", true, userServices.signup(userSignupDto)));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<UserResponseDto>> login(@RequestBody UserLoginDto userLoginDto) {
        UserResponseDto userResponseDto = userServices.login(userLoginDto);
        return ResponseEntity.ok().body(new ApiResponse<>("Login successful", true, userResponseDto));
    }
}
