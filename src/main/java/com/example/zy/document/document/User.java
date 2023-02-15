package com.example.zy.document.document;

import com.example.zy.document.dto.SignupDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Document
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    private String id;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String firstname;

    @NonNull
    private String lastname;

    @NonNull
    private String emailAddress;

    @NonNull
    private String phoneNumber;

    public User(SignupDTO signupDTO) {
        this.username = signupDTO.getUsername();
        this.password = signupDTO.getPassword();
        this.firstname = signupDTO.getFirstname();
        this.lastname = signupDTO.getLastname();
        this.emailAddress = signupDTO.getEmailAddress();
        this.phoneNumber = signupDTO.getPhoneNumber();
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
