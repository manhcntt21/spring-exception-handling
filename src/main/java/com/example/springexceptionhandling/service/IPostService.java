package com.example.springexceptionhandling.service;

import com.example.springexceptionhandling.dto.PostDto;
import com.example.springexceptionhandling.dto.PostResponse;
import com.example.springexceptionhandling.entity.Post;

import java.util.List;

/**
 * @author manhdt14
 * created in 10/6/2023 3:48 AM
 */
public interface IPostService {
    Post createPost(Post post);

    PostResponse getAllPostsPaging(int pageNo, int pageSize, String sortBy, String sortDir);

    List<Post> getAllPosts();

    Post getPostById(long id);

    Post updatePost(Post post, long id);

    void deletePostById(long id);

    void deletePost(long id);
}
