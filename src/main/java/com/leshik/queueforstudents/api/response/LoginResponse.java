package com.leshik.queueforstudents.api.response;

import com.leshik.queueforstudents.model.UserEntity;
import lombok.Data;

@Data
public class LoginResponse {
    private String username;

    public LoginResponse(UserEntity user) {
        this.username = user.getLogin();
    }
}
