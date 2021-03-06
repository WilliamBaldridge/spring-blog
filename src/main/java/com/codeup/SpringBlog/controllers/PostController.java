package com.codeup.SpringBlog.controllers;

import com.codeup.SpringBlog.model.Post;
import com.codeup.SpringBlog.model.User;
import com.codeup.SpringBlog.repository.PostRepo;
import com.codeup.SpringBlog.repository.UserRepo;
import com.codeup.SpringBlog.service.EmailService;
import com.codeup.SpringBlog.service.PostService;
import com.codeup.SpringBlog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

    private final PostRepo postDao;
    private final PostService postService;
    private final UserRepo userDao;
    private final UserService userService;
    private final EmailService emailService;

    public PostController(PostRepo postDao, PostService postService, UserRepo userDao, UserService userService, EmailService emailService) {
        this.postDao = postDao;
        this.postService = postService;
        this.userDao = userDao;
        this.userService = userService;
        this.emailService = emailService;
    }

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String postsIndex(Model vModel) {

        vModel.addAttribute("posts", postDao.findAll());

        return "posts/index";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String postById(@PathVariable long id, Model vModel) {

        vModel.addAttribute("post", postService.getPostById(id));

        return "posts/show";
    }

//    @GetMapping(path = "/posts/create")
//    public String viewCreateForm() {
//
//        return "posts/create";
//    }

    @GetMapping(path = "/posts/create")
    public String viewCreateForm(Model model) {

        model.addAttribute("post", new Post());
        return "posts/create";
    }

//    @PostMapping(path = "/posts/create")
//    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body, Model vModel) {
//        // input add service method
//
//        Post post = new Post(
//                title,
//                body,
//                userService.getUserById(1)
//                );
//
//        postService.addPost(post);
//
//        return "posts/index";
//    }

    @PostMapping(path = "/posts/create")
    public String createPost(@ModelAttribute Post post) {

        postService.addPost(post);
        emailService.prepareAndSend(post, "test", "post.getBody()");

        return "redirect:/posts";
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
    public String editPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body, @PathVariable long id, Model vModel) {

        Post updatedPost = new Post(
                id,
                title,
                body
        );

        postService.updatePost(updatedPost);

        return "redirect:/posts/{id}}";
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
