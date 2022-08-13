package com.example.jwt.model;

import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AppUserObj {

    private String username;
    private String password;
    private Authorites authorities;

    public AppUser toAppUser(){
        return AppUser.builder()
                .username(this.username)
                .password(new BCryptPasswordEncoder().encode(this.password))
                .authorites(this.authorities)
                .build();
    }

}
