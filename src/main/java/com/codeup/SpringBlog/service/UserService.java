package com.codeup.SpringBlog.service;



import com.codeup.SpringBlog.model.User;

import java.util.List;

public interface UserService {

    User addPost(User User);
    void updatePost(User User);
    User getPostById(long UserId);
    void deletePost(long UserId);


}
