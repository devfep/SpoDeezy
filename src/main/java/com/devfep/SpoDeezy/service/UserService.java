package com.devfep.SpoDeezy.service;

import com.devfep.SpoDeezy.entity.User;

public interface UserService {
    boolean createNewUser(User user);
    User findUserByEmail(String email);
}
