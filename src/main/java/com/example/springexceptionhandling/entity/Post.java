package com.example.springexceptionhandling.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author manhdt14
 * created in 10/6/2023 1:44 AM
 */
@Entity
@Table(name = "t_post")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "content", nullable = false)
    private String content;
}
