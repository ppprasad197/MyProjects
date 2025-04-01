package com.postandcomments.postandcomment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postandcomments.postandcomment.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
