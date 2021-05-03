package com.codeup.SpringBlog.service;

import com.codeup.SpringBlog.model.Post;

import java.util.List;

public interface PostService {

    Post addPost(Post post);
    void updatePost(Post post);
    Post getPostById(long postId);
    void deletePost(long postId);

    List<Post> getPostsByTitle(String title);

}
