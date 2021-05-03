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
    public String postsIndex(Model vModel) {

        List<Post> postList = new ArrayList<>(Arrays.asList(
                new Post("Test One", "This is the first test blog post"),
                new Post("Test Two", "This is the second test blog post"),
                new Post("Test Three", "This is the third test blog post")
        ));

        vModel.addAttribute("posts", postList);

        return "posts/index";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String postById(@PathVariable int id, Model vModel) {

        Post post = new Post("Test One", "This is the first test blog post");

        vModel.addAttribute("id", id);
        vModel.addAttribute("post", post);

        return "posts/show";
    }

    @GetMapping(path = "/posts/create")
    public String viewCreateForm() {

        return "posts/create";
    }

    @PostMapping(path = "/posts/create")
    public String createPost() {
        // input add service method

        Post post = new Post();

        postService.addPost(post);

        return "posts/index";
    }

//    @PostMapping(path = "/posts")
//    public Post updatePost() {
//
//
//    }


}
