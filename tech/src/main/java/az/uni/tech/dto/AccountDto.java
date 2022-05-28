package az.uni.tech.dto;

import az.uni.tech.domain.AccountType;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Builder
@Data
public class AccountDto {

    private Long id;
    private AccountType accountType;
    private Double balance;
    private LocalDateTime createDate;

}
