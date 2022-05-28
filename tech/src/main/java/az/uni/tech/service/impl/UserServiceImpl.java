package az.uni.tech.service.impl;

import az.uni.tech.domain.User;
import az.uni.tech.dto.LoginRequest;
import az.uni.tech.dto.LoginResponse;
import az.uni.tech.dto.UserDto;
import az.uni.tech.exception.UserAllredyExisted;
import az.uni.tech.repository.UserRepository;
import az.uni.tech.security.JwtUtils;
import az.uni.tech.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;


    @Override
    public void createUser(UserDto dto) {
        val pinCode = userRepository.findByPinCode(dto.getPinCode());
        if(pinCode.isPresent()) {
            throw new UserAllredyExisted(dto.getPinCode());
        }
        final User user = modelMapper.map(dto, User.class);
        user.setPassword(encoder.encode(dto.getPassword()));
        userRepository.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        return LoginResponse.builder()
                .accessToken(jwt)
                .build();
    }
}
