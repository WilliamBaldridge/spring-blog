package com.codeup.SpringBlog.service;


import com.codeup.SpringBlog.model.Post;
import com.codeup.SpringBlog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;


    @Override
    public Post addPost(Post post) {

        return postRepository.save(post);
    }

    @Override
    public void updatePost(Post post) {

        postRepository.save(post);
    }

    @Override
    public Post getPostById(long postId) {

        return postRepository.findByPostId(postId);
    }

    @Override
    public void deletePost(long postId) {

        postRepository.deleteById(postId);
    }

    @Override
    public List<Post> getPostsByTitle(String title) {

        List<Post> postList = postRepository.getPostsByTitle(title);

        return postList;
    }

}
