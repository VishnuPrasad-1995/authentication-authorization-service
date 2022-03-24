package com.mavericsystems.authenticationauthorizationservice.feign;

import com.mavericsystems.authenticationauthorizationservice.dto.UserDto;
import com.mavericsystems.authenticationauthorizationservice.dto.UserWithOutPassword;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "user-service")
public interface UserFeign {
    @PostMapping("/users")
    UserWithOutPassword createUser(UserDto userDto);
    @GetMapping("/users/getUserByEmail/{emailId}")
    UserWithOutPassword getUserDetailsByEmail(@PathVariable("emailId") String emailId);
}
