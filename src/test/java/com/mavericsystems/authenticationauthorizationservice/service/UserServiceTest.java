package com.mavericsystems.authenticationauthorizationservice.service;

import com.mavericsystems.authenticationauthorizationservice.model.JWTRequest;
import com.mavericsystems.authenticationauthorizationservice.repo.AuthorisationRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {UserService.class})
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @MockBean
    private AuthorisationRepo authorisationRepo;

    @Autowired
    private UserService userService;

    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        JWTRequest jwtRequest = new JWTRequest();
        jwtRequest.setEmail("test@mail.com");
        jwtRequest.setPassword("12345");
        when(this.authorisationRepo.findByEmail((String) any())).thenReturn(jwtRequest);
        UserDetails userDetails = this.userService.loadUserByUsername("test@mail.com");
        assertEquals("test@mail.com", userDetails.getUsername());
        verify(this.authorisationRepo).findByEmail((String) any());
    }

    @Test
    void testEmailIsPresent(){
        JWTRequest jwtRequest = new JWTRequest();
        jwtRequest.setEmail("test@mail.com");
        when(this.authorisationRepo.findByEmail((String) any())).thenReturn(jwtRequest);
        Boolean email = this.userService.emailIsPresent((String) any());
        assertEquals(true, email);
    }
}
