package com.example.zy.document.document;

import com.example.zy.document.dto.SignupDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;

@Document(collection = "Users")
@Data
@Builder
public class User implements UserDetails {
    @Id
    private String id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String emailAddress;
    private String phoneNumber;

    public User() {
    }

    public User(SignupDTO signupDTO) {
        this.username = signupDTO.getUsername();
        this.password = signupDTO.getPassword();
        this.firstname = signupDTO.getFirstname();
        this.lastname = signupDTO.getLastname();
        this.emailAddress = signupDTO.getEmailAddress();
        this.phoneNumber = signupDTO.getPhoneNumber();
    }

    public static User from(SignupDTO signupDTO) {
        return User.builder()
                .username(signupDTO.getUsername())
                .password(signupDTO.getPassword())
                .firstname(signupDTO.getFirstname())
                .lastname(signupDTO.getLastname())
                .emailAddress(signupDTO.getEmailAddress())
                .phoneNumber(signupDTO.getPhoneNumber())
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
