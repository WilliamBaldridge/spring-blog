package com.codeup.SpringBlog.service;


import com.codeup.SpringBlog.model.Post;
import com.codeup.SpringBlog.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;


    @Override
    public Post addPost(Post post) {

        return postRepo.save(post);
    }

    @Override
    public void updatePost(Post post) {

        postRepo.save(post);
    }

    @Override
    public Post getPostById(long postId) {

        return postRepo.findByPostId(postId);
    }

    @Override
    public void deletePost(long postId) {

        postRepo.deleteById(postId);
    }

    @Override
    public List<Post> getPostsByTitle(String title) {

        List<Post> postList = postRepo.getPostsByTitle(title);

        return postList;
    }

    @Override
    public Post findByTitle(String title) {
        return postRepo.findByTitle(title);
    }

}
