package az.uni.tech.service.impl;

import az.uni.tech.domain.Account;
import az.uni.tech.domain.User;
import az.uni.tech.dto.AccountDto;
import az.uni.tech.exception.UserNotFoundException;
import az.uni.tech.repository.AccountRepository;
import az.uni.tech.repository.UserRepository;
import az.uni.tech.service.AccountService;
import az.uni.tech.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final AccountRepository accountRepository;

    @Override
    public List<AccountDto> getAccounts(String pinCode) {
        return userRepository.findByPinCode(pinCode).orElseThrow(() ->  new UserNotFoundException(pinCode))
                .getAccounts()
                .stream()
                .filter(account -> account.isActive())
                .map(account -> modelMapper.map(account,AccountDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void createAccount(AccountDto dto, String pinCode) {
        User user = userRepository.findByPinCode(pinCode).orElseThrow(() ->  new UserNotFoundException(pinCode));
        final Account account = modelMapper.map(dto, Account.class);
        accountRepository.save(account);
    }
}
