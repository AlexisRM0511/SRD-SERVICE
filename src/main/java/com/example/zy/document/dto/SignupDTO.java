package com.example.zy.document.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupDTO {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String emailAddress;
    private String phoneNumber;
}
