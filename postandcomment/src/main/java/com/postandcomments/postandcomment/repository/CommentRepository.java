package com.postandcomments.postandcomment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postandcomments.postandcomment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
