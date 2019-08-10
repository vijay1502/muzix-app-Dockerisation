package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exceptions.UserNameAlreadyExistsException;

import java.util.List;

public interface UserService {
    public User saveUser(User user) throws UserNameAlreadyExistsException;
    public List<User> getAllUsers();

    }
