package com.coll.OnlineCollaborateBackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coll.OnlineCollaborateBackEnd.dao.IBlogDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IUserDAO;
import com.coll.OnlineCollaborateBackEnd.model.Blog;
import com.coll.OnlineCollaborateBackEnd.model.User;
import com.coll.OnlineCollaborateBackEnd.services.EmailService;
@RestController
@CrossOrigin(origins="http://localhost:8887")
public class RequestsController {
	
	@Autowired
	IUserDAO userDAO;
	@Autowired
	IBlogDAO blogDAO;
	@Autowired
	EmailService emailService;
	
	//Method for fetching pending user list by status
	@GetMapping(value = {"/user/request/list"})
	public ResponseEntity<List<User>> fetchPendingUsers() {
		System.out.println("fetching list of pending users");
		List<User> user = userDAO.list("PENDING");
		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}
	
	
	//Method to change user registration status
	@PostMapping(value = {"/user/request/approval/{userId}"})
	public ResponseEntity<User> changeStatus(@PathVariable("userId") int id) {
			System.out.println("changing status");
			User user = new User();
			user = userDAO.getUser(id);
			user.setStatus("APPROVED");
			userDAO.updateUser(user);
			System.out.println("status updated");
			emailService.approvedUserMessage(user);
			System.out.println("mail sent");
			return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	//Method for fetching pending blog list by status
	@GetMapping(value = {"/blog/request/list"})
	public ResponseEntity<List<Blog>> fetchPendingBlogs() {
			System.out.println("fetching list of pending blogs");
			List<Blog> blog = blogDAO.getBlogsByStatus("PENDING");
				return new ResponseEntity<List<Blog>>(blog, HttpStatus.OK);
	}
	
	//Method to change blog request status
	@PostMapping(value = {"/blog/request/approval/{id}"})
	public ResponseEntity<Blog> changeBlogStatus(@PathVariable("id") int id) {
			System.out.println("changing blog status");
			Blog blog = null;
			blog = blogDAO.getBlog(id);
			blog.setStatus("APPROVED");
			blogDAO.updateBlog(blog);
			return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}
	
	
	

}