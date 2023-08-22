package com.example.demo.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserSignupDto {

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate dateOfBirth;

    private String phoneNumber;

    private String address;

    private String password;

    private String confirmPassword;
}
