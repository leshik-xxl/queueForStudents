package com.leshik.queueforstudents.api.controller;


import com.leshik.queueforstudents.api.model.UserName;
import com.leshik.queueforstudents.model.UserEntity;
import com.leshik.queueforstudents.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public UserName login(@RequestBody UserName request) {
        UserEntity user = authenticationService.login(request.getUserName());
        return new UserName(user);
    }

    @PostMapping("/logout")
    public UserName logout(@RequestBody UserName request) {
       return new UserName(authenticationService.logout(request.getUserName()));
    }
}
