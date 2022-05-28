package az.uni.tech.service.impl;

import az.uni.tech.domain.User;
import az.uni.tech.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String pinCode) throws UsernameNotFoundException {
        User user = userRepository.findByPinCode(pinCode)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with pinCode: " + pinCode));

        return UserDetailsImpl.build(user);
    }

}