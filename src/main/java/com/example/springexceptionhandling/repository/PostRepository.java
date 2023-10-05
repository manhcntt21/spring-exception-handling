package com.example.springexceptionhandling.repository;

import com.example.springexceptionhandling.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author manhdt14
 * created in 10/6/2023 2:12 AM
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
