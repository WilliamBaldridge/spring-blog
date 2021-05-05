package com.codeup.SpringBlog.repository;


import com.codeup.SpringBlog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {


    User findByUserId();
    User findByEmail();
    User findByUsername();




}
