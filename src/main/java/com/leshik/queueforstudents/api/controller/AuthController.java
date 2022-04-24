package com.leshik.queueforstudents.api.controller;


import com.leshik.queueforstudents.api.request.LoginRequest;
import com.leshik.queueforstudents.api.response.LoginResponse;
import com.leshik.queueforstudents.model.UserEntity;
import com.leshik.queueforstudents.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        UserEntity user = authenticationService.login(loginRequest.getLogin());
        return new LoginResponse(user);
    }

    @PostMapping("/logout")
    public void logout(@RequestBody LoginRequest loginRequest) {
        authenticationService.logout(loginRequest.getLogin());
    }
}
