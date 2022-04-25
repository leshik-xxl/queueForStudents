package com.leshik.queueforstudents.api.model;

import com.leshik.queueforstudents.model.UserEntity;
import lombok.Data;

@Data
public class UserName {
    private String userName;

    public UserName(UserEntity user) {
        this.userName = user.getUserName();
    }

}
