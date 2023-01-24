package com.ednipro.test.services.impls;

import com.ednipro.test.models.UserModel;
import com.ednipro.test.services.impls.interfaces.AuthenticationService;
import com.ednipro.test.services.impls.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;

    public AuthenticationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserModel registration(String email, String password) {
        UserModel userModel = new UserModel();
        userModel.setEmail(email);
        userModel.setPassword(password);
        userService.add(userModel);
        return userModel;
    }
}
