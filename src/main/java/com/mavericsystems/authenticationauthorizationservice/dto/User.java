package com.mavericsystems.authenticationauthorizationservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mavericsystems.authenticationauthorizationservice.enums.BloodGroup;
import com.mavericsystems.authenticationauthorizationservice.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    @NotBlank(message = "First name must not be blank")
    @NotNull(message = "First name should not null")
    private String firstName;
    @NotBlank(message = "Last name must not be blank")
    @NotNull(message = "Last name should not null")
    private String lastName;
    private String middleName;
    @NotBlank(message = "Phone number must not be blank")
    @NotNull(message = "Phone number should not null")
    @Pattern(regexp = "^[0-9]{10}", message = "phone number should only contain numbers and it should be a ten digit number")
    private String phoneNumber;
    @NotBlank(message = "email should not be blank")
    @NotNull(message = "email should not be null")
    @Pattern(regexp = "^[\\wA-Za-z0-9]+(?:\\.[\\wA-Za-z0-9+_-]+[A-Za-z0-9]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "please enter proper email")
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private Gender gender;
    @NotBlank(message = "Employee num should not be blank")
    @NotNull(message = "Employee num should not be null")
    private String employeeNumber;
    private BloodGroup bloodGroup;
    @NotEmpty(message = "password should not be empty")
    @Size(min = 4, message = "password should have at least 4 characters")
    private String password;

}
