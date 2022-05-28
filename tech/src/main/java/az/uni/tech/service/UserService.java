package az.uni.tech.service;

import az.uni.tech.dto.LoginRequest;
import az.uni.tech.dto.LoginResponse;
import az.uni.tech.dto.UserDto;

public interface UserService {

    void createUser(UserDto dto);
    LoginResponse login(LoginRequest request);
}
