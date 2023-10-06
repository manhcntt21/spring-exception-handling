package com.example.springexceptionhandling.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author manhdt14
 * created in 10/6/2023 3:48 AM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Post model information")
public class PostDto {
    @Schema(description = "Blog post id")
    private Long id;
    @Schema(description = "Blog post title")
    private String title;
    @Schema(description = "Blog post content")
    private String description;
    @Schema(description = "Blog post comments")
    private String content;
}
