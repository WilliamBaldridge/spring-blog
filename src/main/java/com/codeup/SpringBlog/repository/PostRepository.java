package com.codeup.SpringBlog.repository;

import com.codeup.SpringBlog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // Direct queries need to start with findBy/getBy/ReadBy
    // when properties are of primitive data types, just append property name to direct query
    // when properties are their own class (Address here), append class name first then appropriate property of that class property

//    @Query("FROM Post p WHERE p.postId LIKE ?1")
//    Post getPostById(long id);

    Post findByPostId(long postId);

    @Query("FROM Post p WHERE p.title LIKE %:term%")
    List<Post> getPostsByTitle(@Param("term") String term);

}
