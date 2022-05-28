package az.uni.tech.controller;


import az.uni.tech.dto.AccountDto;
import az.uni.tech.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public List<AccountDto> getAccounts(HttpServletRequest request) {
        return accountService.getAccounts(request.getUserPrincipal().getName());
    }

    @PostMapping
    public void createAccount(@RequestBody AccountDto dto, HttpServletRequest request) {
        accountService.createAccount(dto, request.getUserPrincipal().getName());
    }
}
