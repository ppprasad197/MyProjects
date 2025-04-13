package com.postandcomments.postandcomment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.postandcomments.postandcomment.entity.Post;
import com.postandcomments.postandcomment.repository.PostRepository;

@Service
@Transactional
public class PostService {

	@Autowired
	PostRepository postRepository;

	public Post createPost(Post post) {
		return postRepository.save(post);
	}

	public Post getPostById(Long id) {
		return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
	}

	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	public Post deleteById(Long id) {
		Post post = getPostById(id);
		postRepository.deleteById(id);
		return post;
	}

	public Post updateById(Long id, Post updatedPost) {
		Post existingPost = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not fond"));

		if (updatedPost.getTitle() != null) {
			existingPost.setTitle(updatedPost.getTitle());
		}
		if (updatedPost.getContent() != null) {
			existingPost.setContent(updatedPost.getContent());
		}
		return postRepository.save(existingPost);
	}
}
