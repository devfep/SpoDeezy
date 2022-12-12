package com.devfep.SpoDeezy.service.Impl;

import com.devfep.SpoDeezy.entity.Role;
import com.devfep.SpoDeezy.entity.User;
import com.devfep.SpoDeezy.repository.RoleRepository;
import com.devfep.SpoDeezy.repository.UserRepository;
import com.devfep.SpoDeezy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public boolean createNewUser(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            return false;
        }

        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRole(roleRepository.findById(2).get());
        userRepository.save(newUser) ;

        return true;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
