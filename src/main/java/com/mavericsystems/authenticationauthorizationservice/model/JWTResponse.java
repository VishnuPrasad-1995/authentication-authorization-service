package com.mavericsystems.authenticationauthorizationservice.model;

import com.mavericsystems.authenticationauthorizationservice.dto.UserWithOutPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JWTResponse {

    private String jwtToken;
    private UserWithOutPassword userWithOutPassword;

}
