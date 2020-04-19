package com.codenation.demo.user.service;

import com.codenation.demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

}
