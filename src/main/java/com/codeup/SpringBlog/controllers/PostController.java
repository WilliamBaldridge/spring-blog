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

        vModel.addAttribute("posts", postDao.findAll());

        return "posts/index";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String  postById(@PathVariable int id, Model vModel) {

        vModel.addAttribute("post", postService.getPostById(id));

        return "posts/show";
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

    @GetMapping(path = "/posts/{id}/edit")
    public String viewEditForm(@PathVariable long id, Model vModel) {

        vModel.addAttribute("post", postService.getPostById(id));

        return "posts/edit";
    }

//    @PostMapping(path = "/posts/edit")
//    public String editPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body, Model vModel) {
//
//        Post updatedPost = new Post(
//                1001,
//                title,
//                body
//        );
//
//        postService.updatePost(updatedPost);
//
//        return "posts/index";
//    }

    @PostMapping(path = "/posts/edit/{id}")
    public String  editPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body, @PathVariable long id, Model vModel) {

        Post updatedPost = new Post(
                id,
                title,
                body
        );

        postService.updatePost(updatedPost);

        return "posts/index";
    }

//    @GetMapping(path = "/posts/delete")
//    public String viewDeleteForm() {
//
//        return "posts/delete";
//    }

    @PostMapping(path = "/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {

        postDao.deleteById(id);

        return "posts/index";
    }


}
