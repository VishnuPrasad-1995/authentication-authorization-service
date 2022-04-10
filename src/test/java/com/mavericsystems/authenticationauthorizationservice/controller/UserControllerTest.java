package com.mavericsystems.authenticationauthorizationservice.controller;

import com.mavericsystems.authenticationauthorizationservice.dto.LoginRequest;
import com.mavericsystems.authenticationauthorizationservice.exception.CustomFeignException;
import com.mavericsystems.authenticationauthorizationservice.exception.EmailAlreadyExistException;
import com.mavericsystems.authenticationauthorizationservice.exception.EmailNotFoundException;
import com.mavericsystems.authenticationauthorizationservice.feign.UserFeign;
import com.mavericsystems.authenticationauthorizationservice.service.UserService;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Test
    void testExceptionThrownWhenEmailNotFoundForLogin() {
        UserController userController = new UserController(new UserService(), null);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("test@mail.com");
        loginRequest.setPassword("12345");
        assertThrows(EmailNotFoundException.class, () -> userController.login(loginRequest));
    }

    @Test
    void testExceptionThrownWhenFeignConnectionIssueForLogin() throws UsernameNotFoundException {
        UserService userService = mock(UserService.class);
        when(userService.loadUserByUsername((String) any())).thenThrow(mock(FeignException.class));
        UserController userController = new UserController(userService, null);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("test@mail.com");
        loginRequest.setPassword("12345");
        assertThrows(CustomFeignException.class, () -> userController.login(loginRequest));
        verify(userService).loadUserByUsername((String) any());
    }

    @Test
    void testExceptionThrownWhenFeignConnectionIssueForSignup() {
        UserService userService = mock(UserService.class);
        when(userService.emailIsPresent((String) any())).thenReturn(false);
        UserFeign userFeign = mock(UserFeign.class);
        when(userFeign.createUser((com.mavericsystems.authenticationauthorizationservice.dto.User) any())).thenThrow(mock(FeignException.class));
        UserController userController = new UserController(userService, userFeign);
        assertThrows(CustomFeignException.class, () -> userController.signup(new com.mavericsystems.authenticationauthorizationservice.dto.User()));
    }

    @Test
    void testExceptionThrownWhenEmailAlreadyExistForSignup() {
        UserService userService = mock(UserService.class);
        when(userService.emailIsPresent((String) any())).thenReturn(true);
        UserController userController = new UserController(userService, null);
        assertThrows(EmailAlreadyExistException.class, () -> userController.signup(new com.mavericsystems.authenticationauthorizationservice.dto.User()));
    }
}