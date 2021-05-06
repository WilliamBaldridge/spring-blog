package com.codeup.SpringBlog.service;


import com.codeup.SpringBlog.model.User;
import com.codeup.SpringBlog.repository.UserRepo;
import com.codeup.SpringBlog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;


    @Override
    public User addUser(User user) {

        return userRepo.save(user);
    }

    @Override
    public void updateUser(User user) {

        userRepo.save(user);
    }

    @Override
    public User getUserById(long userId) {

        return userRepo.findByUserId(userId);
    }

    @Override
    public void deleteUser(long userId) {

        userRepo.deleteById(userId);
    }

    @Override
    public List<User> getUserByUsername(String username) {

        return userRepo.getUserByUsername(username);
    }

    @Override
    public List<User> getUserByEmail(String email) {

        return userRepo.getUserByEmail(email);
    }
}
