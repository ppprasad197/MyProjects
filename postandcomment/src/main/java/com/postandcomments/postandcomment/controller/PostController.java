package com.postandcomments.postandcomment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postandcomments.postandcomment.entity.Comment;
import com.postandcomments.postandcomment.entity.DeletedPost;
import com.postandcomments.postandcomment.entity.Post;
import com.postandcomments.postandcomment.service.PostService;

@RestController
@RequestMapping("/post/")
public class PostController {

	@Autowired
	private PostService postService;

	@PostMapping
	private ResponseEntity<Post> createPost(@RequestBody Post post) {
		if (post.getComments() != null) {
			for (Comment comment : post.getComments()) {
				comment.setPost(post);
			}
		}
		Post savedPost = postService.createPost(post);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
	}

	@GetMapping("{id}")
	private ResponseEntity<Post> getPostById(@PathVariable Long id) {
		Post post = postService.getPostById(id);
		return ResponseEntity.ok(post);
	}

	@GetMapping
	private ResponseEntity<List<Post>> getAllPosts() {
		List<Post> posts = postService.getAllPosts();
		return ResponseEntity.ok(posts);
	}

	@DeleteMapping("{id}")
	private ResponseEntity<DeletedPost> deleteById(@PathVariable Long id) {
		Post post = postService.deleteById(id);
		DeletedPost deletedPost = new DeletedPost("Post deleted successfully", post);
		return ResponseEntity.ok(deletedPost);
	}

	@PutMapping("{id}")
	private ResponseEntity<Post> updateById(@PathVariable Long id, @RequestBody Post updatedPost) {
		Post savedPost = postService.updateById(id, updatedPost);
		return ResponseEntity.ok(savedPost);
	}
}
