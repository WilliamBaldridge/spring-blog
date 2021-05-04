package com.codeup.SpringBlog.controllers;

import com.codeup.SpringBlog.model.Post;
import com.codeup.SpringBlog.repository.PostRepository;
import com.codeup.SpringBlog.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class PostController {

    private final PostRepository postDao;
    private final PostService postService;

    public PostController(PostRepository postDao, PostService postService) {
        this.postDao = postDao;
        this.postService = postService;
    }

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public List<Post> postsIndex() {

        return postDao.findAll();
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Post postById(@PathVariable int id) {

        return postService.getPostById(id);
    }

    @GetMapping(path = "/posts/create")
    public String viewCreateForm() {

        return "posts/create";
    }

    @PostMapping(path = "/posts/create")
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body, Model vModel) {
        // input add service method


        Post post = new Post(
                title,
                body
        );

        postService.addPost(post);

        return "posts/index";
    }

    @GetMapping(path = "/posts/edit")
    public String viewEditForm() {

        return "posts/edit";
    }

//    @PostMapping(path = "/posts")
//    public Post updatePost() {
//
//
//    }


}
