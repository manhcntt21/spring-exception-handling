package com.example.springexceptionhandling.service.impl;

import com.example.springexceptionhandling.dto.PostDto;
import com.example.springexceptionhandling.dto.PostResponse;
import com.example.springexceptionhandling.entity.Post;
import com.example.springexceptionhandling.exception.type.ResourceNotFoundException;
import com.example.springexceptionhandling.repository.PostRepository;
import com.example.springexceptionhandling.service.IPostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author manhdt14
 * created in 10/6/2023 3:47 AM
 */
@Service
public class PostService implements IPostService {
    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * //TODO nếu có ngoại lệ ở đây xử lý sao
     * @param postDto
     * @return
     */
    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post newPost = postRepository.save(post);
        PostDto postResponse = mapToDTO(newPost);
        return postResponse;
    }

    /**
     * defualt là asc or ASC,...
     * @param pageNo
     * @param pageSize
     * @param sortBy
     * @param sortDir
     * @return
     */
    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // TODO create page instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        // pass config to Pageable
        Page<Post> posts = postRepository.findAll(pageable);
        // TODO get data from Page
        List<Post> postList = posts.getContent();

        List<PostDto> content = postList.stream().map(post -> mapToDTO(post)).toList();
        return PostResponse.builder()
                .content(content)
                .pageNo(posts.getNumber())
                .pageSize(posts.getSize())
                .totalElements(posts.getTotalElements())
                .totalPages(posts.getTotalPages())
                .build();
    }

    @Override
    public PostDto getPostById(long id) {
        Post post =  postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
        return mapToDTO(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post post =  postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        post.setTitle(postDto.getTitle());

        Post updatedPost = postRepository.save(post);
        return mapToDTO(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }

    // convert Entity into DTO
    private PostDto mapToDTO(Post post){
        return PostDto.builder()
                .id(post.getId())
                .content(post.getContent())
                .description(post.getDescription())
                .title(post.getTitle())
                .build();
    }

    // convert DTO to entity
    private Post mapToEntity(PostDto postDto){
        return Post.builder()
                .id(postDto.getId())
                .content(postDto.getContent())
                .description(postDto.getDescription())
                .title(postDto.getTitle())
                .build();
    }
}
