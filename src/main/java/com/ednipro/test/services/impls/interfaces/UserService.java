package com.ednipro.test.services.impls.interfaces;

import com.ednipro.test.models.UserModel;

import java.util.Optional;

public interface UserService {
    UserModel add(UserModel userModel);

    UserModel get(Long id);

    Optional<UserModel> findByEmail(String email);
}
