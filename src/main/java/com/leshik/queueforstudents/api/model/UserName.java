package com.leshik.queueforstudents.api.model;

import com.leshik.queueforstudents.model.UserEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserName {
    private String userName;

    public UserName(UserEntity user) {
        this.userName = user.getUserName();
    }
}
