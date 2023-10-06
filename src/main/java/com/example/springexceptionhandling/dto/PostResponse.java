package com.example.springexceptionhandling.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author manhdt14
 * created in 10/6/2023 3:51 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "paging response")
public class PostResponse {
    @Schema(description = "content")
    private List<PostDto> content;
    @Schema(description = "page number")
    private int pageNo;
    @Schema(description = "page size")
    private int pageSize;
    @Schema(description = "total elements")
    private long totalElements;
    @Schema(description = "total pages")
    private int totalPages;
    @Schema(description = "sort by field")
    private String sortBy;
    @Schema(description = "sort: acs or desc")
    private String sortDir;
}
