package com.stackroute.service;


import com.stackroute.domain.User;
import com.stackroute.exceptions.UserNameAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceIMpl implements UserService {
    private UserRepository userRepository;
    @Autowired
    public UserServiceIMpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public User saveUser(User user) throws UserNameAlreadyExistsException {
        if(userRepository.existsById(user.getId())){
            throw new UserNameAlreadyExistsException("User name already Exists");
        }
        User savedUser=userRepository.save(user);
        if(savedUser==null){
            throw new UserNameAlreadyExistsException("user name required");
        }
        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();

    }


}
