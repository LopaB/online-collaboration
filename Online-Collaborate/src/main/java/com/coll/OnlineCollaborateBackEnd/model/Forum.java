package com.coll.OnlineCollaborateBackEnd.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Component
@Table(name="FORUM")
public class Forum implements Serializable{

	
	private static final long serialVersionUID = -66889188584225117L;
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="generator")
	@SequenceGenerator(name="generator", sequenceName="forum_category_seq", allocationSize = 1)
	@Column(name="FORUM_ID")
	int id;
	String name;
	String description;
	LocalDate postDate;
	String status;
	@Column(name="User_Id")
	int userId;	
	String username;
	int noOfPosts;
	public int getNoOfPosts() {
		return noOfPosts;
	}
	public void setNoOfPosts(int noOfPosts) {
		this.noOfPosts = noOfPosts;
	}


	@OneToMany(mappedBy="forum", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	List<ForumPost> forumPost;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getPostDate() {
		return postDate;
	}
	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<ForumPost> getForumPost() {
		return forumPost;
	}
	public void setForumPost(List<ForumPost> forumPost) {
		this.forumPost = forumPost;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
