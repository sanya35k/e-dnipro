package com.ednipro.test.services.impls.interfaces;

import com.ednipro.test.models.UserModel;

public interface AuthenticationService {
    UserModel registration(String email, String password);
}
