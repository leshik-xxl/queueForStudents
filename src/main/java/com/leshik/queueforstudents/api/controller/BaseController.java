package com.leshik.queueforstudents.api.controller;

import com.leshik.queueforstudents.security.AuthenticatedUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queue-for-students/api")
public abstract class BaseController {

    protected static final String SUCCESS = "success";
    protected static final String EXIST_LOGIN = "exist password";

    protected AuthenticatedUser getAuthenticatedUser() {
        return (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
