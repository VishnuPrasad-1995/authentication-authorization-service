package com.mavericsystems.authenticationauthorizationservice.exception;


public class CustomFeignException extends RuntimeException{
    public CustomFeignException(String s) {
        super(s);
    }
}
