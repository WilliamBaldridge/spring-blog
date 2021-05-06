package com.codeup.SpringBlog.service;



import com.codeup.SpringBlog.model.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserService {

    User addUser(User user);
    void updateUser(User user);
    User getUserById(long userId);
    void deleteUser(long userId);

    List<User> getUserByUsername(String username);
    List<User> getUserByEmail(String email);


}
