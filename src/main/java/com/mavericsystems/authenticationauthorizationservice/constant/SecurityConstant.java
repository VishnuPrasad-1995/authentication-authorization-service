package com.mavericsystems.authenticationauthorizationservice.constant;

public final class SecurityConstant {

    private SecurityConstant() {
        // restrict instantiation
    }


    public static final String FEIGN_EXCEPTION = "User service is not available";
    public static final String EMAIL_NOT_FOUND = "Email not found";
    public static final String CREDENTIAL_INCORRECT = "Please check your credentials";
    public static final String EMAIL_ALREADY_EXIST = "Email Already exist";
}