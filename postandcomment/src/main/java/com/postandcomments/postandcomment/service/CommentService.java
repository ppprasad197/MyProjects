package com.postandcomments.postandcomment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.postandcomments.postandcomment.entity.Comment;
import com.postandcomments.postandcomment.repository.CommentRepository;
import com.postandcomments.postandcomment.repository.PostRepository;

@Service
public class CommentService {
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	PostRepository postRepository;

//	public List<Comment> createComment(List<Comment> comment) {
//		List<Comment> savedComment = commentRepository.saveAll(comment);
//		return savedComment;
//	}

	public List<Comment> createComment(List<Comment> comments) {
		List<Comment> savedComments = new ArrayList<>();

		for (Comment comment : comments) {
			if (comment.getPost() != null && comment.getPost().getId() != null) {
				Long id = comment.getPost().getId();

				if (postRepository.existsById(id)) {
					Comment savedComment = commentRepository.save(comment);
					savedComments.add(savedComment);
				} else {
					System.out.println("Post with id " + id + " does not exist. Skipping comment.");
				}
			} else {
				System.out.println("Invalid comment - Post or Post Id is missing. Skipping comment.");
			}
		}

		return savedComments;
	}

}
