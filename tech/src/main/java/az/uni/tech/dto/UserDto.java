package az.uni.tech.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private String pinCode;
    private String password;
    private String firstName;
    private String lastName;

}
