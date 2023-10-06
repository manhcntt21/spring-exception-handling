package com.example.springexceptionhandling.controller;

import com.example.springexceptionhandling.constant.AppConstants;
import com.example.springexceptionhandling.dto.ApiResponse;
import com.example.springexceptionhandling.dto.PostDto;
import com.example.springexceptionhandling.dto.PostResponse;
import com.example.springexceptionhandling.entity.Post;
import com.example.springexceptionhandling.service.impl.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "CRUD Rest APIs for Post resources")
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
    @Operation(summary = "Create Post REST API")
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        Post postRequest = modelMapper.map(postDto, Post.class);
        Post post = postService.createPost(postRequest);
        return new ResponseEntity<>(modelMapper.map(post, PostDto.class), HttpStatus.CREATED);
    }

    // get all posts rest api
    @Operation(summary = "Get All Posts with Paging REST API")
    @GetMapping("paging")
    public PostResponse getAllPostsPaging(
            @Parameter(description = "page number") @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @Parameter(description = "page size") @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @Parameter(description = "page sort by field") @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @Parameter(description = "page sort by direction") @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return postService.getAllPostsPaging(pageNo, pageSize, sortBy, sortDir);
    }

    @Operation(summary = "Get All Posts REST API")
    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts().stream().map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Operation(summary = "Update Post by Id REST API")
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@Parameter(description = "id post need to update") @PathVariable long id, @RequestBody PostDto postDto) {

        // convert DTO to Entity
        Post postRequest = modelMapper.map(postDto, Post.class);
        Post post = postService.updatePost(postRequest, id);
        // entity to DTO
        PostDto postResponse = modelMapper.map(post, PostDto.class);
        return ResponseEntity.ok().body(postResponse);
    }

    @Operation(summary = "Get Post by Id REST API")
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@Parameter(description = "id post need to get") @PathVariable(name = "id") Long id) {
        Post post = postService.getPostById(id);
        // convert entity to DTO
        PostDto postResponse = modelMapper.map(post, PostDto.class);
        return ResponseEntity.ok().body(postResponse);
    }

    @Operation(summary = "Delete Post by Id REST API")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletePost(@Parameter(description = "id post need to delete") @PathVariable(name = "id") Long id) {
        postService.deletePost(id);
        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Post deleted successfully", HttpStatus.OK);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
