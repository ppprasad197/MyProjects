package com.postandcomments.postandcomment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postandcomments.postandcomment.entity.Comment;
import com.postandcomments.postandcomment.service.CommentService;

@RestController
@RequestMapping("/comments/")
public class CommentController {
	@Autowired
	CommentService commentService;

//	@PostMapping
//	ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
//		Comment savedComment = commentService.createComment(comment);
//		return ResponseEntity.status(HttpStatus.CREATED).body(savedComment);
//	}

//	@PostMapping
//	private ResponseEntity<List<Comment>> createComment(@RequestBody List<Comment> comment) {
//		List<Comment> savedComment = commentService.createComment(comment);
//		return ResponseEntity.status(HttpStatus.CREATED).body(savedComment);
//	}

	@PostMapping
	private ResponseEntity<?> createComment(@RequestBody List<Comment> comments) {
		List<Comment> savedComments = commentService.createComment(comments);

		if (savedComments.isEmpty()) {
			// Nothing saved --> BAD REQUEST with proper message
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", "No valid post ids found. No comments were saved.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		} else {
			// All Saved --> CREATED
			return ResponseEntity.status(HttpStatus.CREATED).body(savedComments);
		}
	}

}
