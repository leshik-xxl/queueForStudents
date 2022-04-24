package com.leshik.queueforstudents.api.controller;


import com.leshik.queueforstudents.api.request.LoginRequest;
import com.leshik.queueforstudents.model.User;
import com.leshik.queueforstudents.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController extends BaseController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public String registerUser(@RequestBody LoginRequest loginRequest) {
        authenticationService.login(new User(loginRequest.getLogin()));
        return "OK";
    }
}
