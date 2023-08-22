package com.example.demo.service;


import com.example.demo.dtos.UserLoginDto;
import com.example.demo.dtos.UserResponseDto;
import com.example.demo.dtos.UserSignupDto;
import com.example.demo.exception.InvalidPasswordException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AppUtil app;


        @Override
        public UserResponseDto signup(UserSignupDto userSignupDto) {
            // Validate userSignupDto and perform necessary checks

            // Check if the username or email is already taken
            if (userRepository.existsByEmail(userSignupDto.getEmail())) {
                throw new ValidationException("Email already exist. ");
            }

            if (userRepository.existsByEmail(userSignupDto.getEmail())) {
                throw new ValidationException("Email is already registered.");
            }

            // Create a new User entity
            User user = new User();
            user.setFirstName(userSignupDto.getFirstName());
            user.setLastName(userSignupDto.getLastName());
            user.setEmail(userSignupDto.getEmail());
            user.setAddress(userSignupDto.getAddress());
            user.setPhoneNumber(userSignupDto.getPhoneNumber());
            user.setDateOfBirth(userSignupDto.getDateOfBirth());

            // You should hash the password before saving it to the database
            user.setPassword(passwordEncoder.encode(userSignupDto.getPassword()));
            // Set other user properties

            // Save the user to the database
            User savedUser = userRepository.save(user);

            // Map the saved user entity to a UserResponseDto
            UserResponseDto userResponseDto = mapUserToResponseDto(savedUser);

            return userResponseDto;
        }

    @Override
    public UserResponseDto login(UserLoginDto userLoginDto) {
        User user = userRepository.findByEmail(userLoginDto.getEmail())
                .orElseThrow(() -> new NotFoundException("User not found"));

        // Validate the password
        if (!passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword())) {
            throw new InvalidPasswordException("Invalid password");
        }
        // Map the user entity to a UserResponseDto
        UserResponseDto userResponseDto = mapUserToResponseDto(user);

        return userResponseDto;
    }

    // Helper method to map User entity to UserResponseDto
        private UserResponseDto mapUserToResponseDto(User user) {
            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto.setId(user.getId());
            userResponseDto.setFirstName(user.getFirstName());
            userResponseDto.setLastName(user.getLastName());
            userResponseDto.setEmail(user.getEmail());
            // Map other properties as needed
            return userResponseDto;
        }
    }



