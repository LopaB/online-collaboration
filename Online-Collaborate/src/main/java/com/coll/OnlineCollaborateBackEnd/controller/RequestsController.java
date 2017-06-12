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
import com.coll.OnlineCollaborateBackEnd.dao.IEventsDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IForumRequestDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IJobDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IUserDAO;
import com.coll.OnlineCollaborateBackEnd.model.Blog;
import com.coll.OnlineCollaborateBackEnd.model.Events;
import com.coll.OnlineCollaborateBackEnd.model.ForumRequest;
import com.coll.OnlineCollaborateBackEnd.model.Job;
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
	
	@Autowired
	IJobDAO jobDAO;
	
	@Autowired
	IEventsDAO eventsDAO;
	
	@Autowired
	IForumRequestDAO forumRequestDAO;
	
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
	
	//Method for fetching list of all forum request with pending status
	@GetMapping(value = {"/forum/request/list"})
	public ResponseEntity<List<ForumRequest>> fetchForumRequests() {
		System.out.println("Method called");
		List<ForumRequest> forumsRequests = forumRequestDAO.list("PENDING");
		return new ResponseEntity<List<ForumRequest>>(forumsRequests, HttpStatus.OK);
	}
	
	//Method to change forum request status
	@PostMapping(value = {"/forum/request/approval/{id}"})
	public ResponseEntity<ForumRequest> changeFRStatus(@PathVariable("id") int id) {
		 	System.out.println("changing status");
			ForumRequest forumRequest = new ForumRequest();
			forumRequest = forumRequestDAO.getForumRequest(id);
			forumRequest.setStatus("APPROVED");
			forumRequestDAO.updateForumRequest(forumRequest);
					return new ResponseEntity<ForumRequest>(forumRequest, HttpStatus.OK);
			}
	
	//Method to approve jobs
	@PostMapping(value = {"/job/request/approval/{id}"})
	public ResponseEntity<Job> approveJobs(@PathVariable("id") int id) {
			System.out.println("approving jobs");
			Job job = null;
			job = jobDAO.getJob(id);
			job.setStatus("APPROVED");
			jobDAO.updateJob(job);
			return new ResponseEntity<Job>(job, HttpStatus.OK);
	}
	
	//Method for fetching pending event list by status
	@GetMapping(value = {"/event/request/list"})
	public ResponseEntity<List<Events>> fetchPendingEvents() {
		System.out.println("fetching list of pending Events");
		List<Events> events = eventsDAO.getEventsByStatus("PENDING");
		return new ResponseEntity<List<Events>>(events, HttpStatus.OK);
	}
	
	//Method to approve events
	@PostMapping(value = {"/event/request/approval/{id}"})
	public ResponseEntity<Events> approveEvents(@PathVariable("id") int id) {
			System.out.println("approving events");
			Events events = null;
			events = eventsDAO.getEvent(id);
			events.setStatus("APPROVED");
			eventsDAO.updateEvent(events);
			return new ResponseEntity<Events>(events, HttpStatus.OK);
	}
	

}
