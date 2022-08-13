package com.example.jwt.controller;

import com.example.jwt.model.AppUser;
import com.example.jwt.model.AppUserObj;
import com.example.jwt.model.Response;
import com.example.jwt.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    AppUserService appUserService;

    @GetMapping("/hello")
    public Response sayHello(){
        return new Response(AppUser.Resp.SUCCESS);
    }

    @PostMapping("/create/user")
    public String createUser(@RequestBody AppUserObj appUserObj){
        return appUserService.createAppUser(appUserObj);
    }

}
