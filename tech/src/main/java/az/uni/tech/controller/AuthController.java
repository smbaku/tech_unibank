package az.uni.tech.controller;

import az.uni.tech.dto.LoginRequest;
import az.uni.tech.dto.LoginResponse;
import az.uni.tech.dto.UserDto;
import az.uni.tech.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/signup")
    public void registerUser(@RequestBody UserDto dto) {
        userService.createUser(dto);
    }

    @PostMapping("/signin")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }

}
