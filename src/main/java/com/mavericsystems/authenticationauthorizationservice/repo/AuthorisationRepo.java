package com.mavericsystems.authenticationauthorizationservice.repo;

import com.mavericsystems.authenticationauthorizationservice.model.JWTRequest;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AuthorisationRepo extends JpaRepository<JWTRequest,Integer> {

    JWTRequest findByEmail(String email);
}
