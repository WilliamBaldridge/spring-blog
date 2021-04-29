package com.codeup.SpringBlog.controllers;

import com.codeup.SpringBlog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;


@Controller
public class PostController {

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    @ResponseBody
    public String postsIndex() {

        return "Posts index page";
    }

    @RequestMapping(path = "/show/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String postById(@PathVariable int id, Model model) {

        id = 1;

        Post post1 = new Post("Test One", "This is the first test blog post");




        return "View an individual post";
    }

    @GetMapping(path = "/show/create")
    @ResponseBody
    public String viewCreateForm() {

        return "View the form for creating a post";
    }

    @PostMapping(path = "/show/create")
    @ResponseBody
    public String createPost() {

        return "Create a new post";
    }


}
