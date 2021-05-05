package com.codeup.SpringBlog.service;


import com.codeup.SpringBlog.model.User;
import com.codeup.SpringBlog.repository.PostRepo;
import com.codeup.SpringBlog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;


    @Override
    public User addPost(User User) {
        return null;
    }

    @Override
    public void updatePost(User User) {

    }

    @Override
    public User getPostById(long UserId) {
        return null;
    }

    @Override
    public void deletePost(long UserId) {

    }
}
