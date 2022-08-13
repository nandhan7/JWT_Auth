package com.example.jwt.service;

import com.example.jwt.model.AppUser;
import com.example.jwt.model.AppUserObj;
import com.example.jwt.repositories.AppUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserService implements UserDetailsService {

    private final AppUserRepo appUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepo.getUserByName(username).orElseThrow(() -> new UsernameNotFoundException("Wrong User!"));
    }

    public String createAppUser(AppUserObj appUserObj){
        AppUser appUser = appUserObj.toAppUser();
        try{
            appUserRepo.save(appUser);
            return "User Saved Sucessfully";
        }catch (Exception e){
            return "Unable to Create AppUser";
        }
    }
}
