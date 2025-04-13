package com.postandcomments.postandcomment.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(nullable = false)
	String title;

	@Column(nullable = false)
	String content;

	@Column(nullable = false, updatable = false)
	LocalDateTime createdAt;

	@Column(nullable = false)
	LocalDateTime updatedAt;

//	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
//	@JsonIgnore
//	List<Comment> comments;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JsonManagedReference
	List<Comment> comments;

//	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//	List<Comment> comments;

	@PrePersist
	public void onCreate() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}

	@PreUpdate
	public void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
}
