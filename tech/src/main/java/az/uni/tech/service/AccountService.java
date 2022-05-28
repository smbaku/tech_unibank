package az.uni.tech.service;

import az.uni.tech.dto.AccountDto;

import java.util.List;

public interface AccountService {

    List<AccountDto> getAccounts(String pinCode);

    void createAccount(AccountDto dto, String pinCode);
}
