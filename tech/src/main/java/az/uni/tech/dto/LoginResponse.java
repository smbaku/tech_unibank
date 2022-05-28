package az.uni.tech.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginResponse {

    private String accessToken;
}
