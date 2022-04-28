package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.models.UserVO;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private UserService userService;

    public AuthorizationService(UserService userService) {
        this.userService = userService;
    }

    //Check if username available or not
    public Boolean signupUser (UserVO userVO) {
        String username = userVO.getUsername();
        if (!this.userService.isUsernameAvailable(username)) {
            return false;
        }
        return true;
    }
}



