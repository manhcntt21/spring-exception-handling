package com.example.springexceptionhandling.controller;

import com.example.springexceptionhandling.constant.AppConstants;
import com.example.springexceptionhandling.dto.ApiResponse;
import com.example.springexceptionhandling.dto.PostDto;
import com.example.springexceptionhandling.dto.PostResponse;
import com.example.springexceptionhandling.entity.Post;
import com.example.springexceptionhandling.service.impl.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author manhdt14
 * created in 10/6/2023 3:58 AM
 */
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private PostService postService;
    private ModelMapper modelMapper;

    public PostController(PostService postService, ModelMapper modelMapper) {
        this.postService = postService;
        this.modelMapper = modelMapper;
    }

    // create blog post rest api
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        Post postRequest = modelMapper.map(postDto, Post.class);
        Post post = postService.createPost(postRequest);
        return new ResponseEntity<>(modelMapper.map(post, PostDto.class), HttpStatus.CREATED);
    }

    // get all posts rest api
    @GetMapping("paging")
    public PostResponse getAllPostsPaging(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return postService.getAllPostsPaging(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts().stream().map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable long id, @RequestBody PostDto postDto) {

        // convert DTO to Entity
        Post postRequest = modelMapper.map(postDto, Post.class);
        Post post = postService.updatePost(postRequest, id);
        // entity to DTO
        PostDto postResponse = modelMapper.map(post, PostDto.class);
        return ResponseEntity.ok().body(postResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long id) {
        Post post = postService.getPostById(id);
        // convert entity to DTO
        PostDto postResponse = modelMapper.map(post, PostDto.class);
        return ResponseEntity.ok().body(postResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable(name = "id") Long id) {
        postService.deletePost(id);
        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Post deleted successfully", HttpStatus.OK);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
