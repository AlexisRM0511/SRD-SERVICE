package com.example.zy.document.dto;

import com.example.zy.document.document.User;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDTO {
    private String id;
    private String username;
    private String firstname;
    private String lastname;
    private String emailAddress;
    private String phoneNumber;

    public static UserDTO from(User user) {
        return builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }
}
