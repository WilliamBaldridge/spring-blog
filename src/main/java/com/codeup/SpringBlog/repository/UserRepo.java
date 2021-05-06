package com.codeup.SpringBlog.repository;


import com.codeup.SpringBlog.model.Post;
import com.codeup.SpringBlog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {


    User findByUserId(long userId);
    User findByEmail(String email);
    User findByUsername(String username);


    @Query("FROM User u WHERE u.username LIKE %:term%")
    List<User> getUserByUsername(@Param("term") String term);

    @Query("FROM User u WHERE u.email LIKE %:term%")
    List<User> getUserByEmail(@Param("term") String term);


}
