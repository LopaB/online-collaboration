package com.coll.OnlineCollaborateBackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.RestController;

import com.coll.OnlineCollaborateBackEnd.dao.IBlogDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IEventsDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IForumDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IJobDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IUserDAO;
import com.coll.OnlineCollaborateBackEnd.model.Blog;
import com.coll.OnlineCollaborateBackEnd.model.DomainResponse;
import com.coll.OnlineCollaborateBackEnd.model.Events;
import com.coll.OnlineCollaborateBackEnd.model.Forum;
import com.coll.OnlineCollaborateBackEnd.model.Job;
import com.coll.OnlineCollaborateBackEnd.model.User;
import com.coll.OnlineCollaborateBackEnd.services.EmailService;


@RestController
@CrossOrigin(origins="http://localhost:8887")
public class AdminController {

	@Autowired
	IUserDAO userDAO;
	
	@Autowired
	IBlogDAO blogDAO;
	
	@Autowired
	IJobDAO jobDAO;
	
	@Autowired
	IEventsDAO eventsDAO;
	
	@Autowired
	IForumDAO forumDAO;
	
	//fetching approved user list by status
			@GetMapping(value = {"/user/manage/list"})
			public ResponseEntity<List<User>> fetchApprovedUsers() {
					System.out.println("fetching list of approved users");
					List<User> user = userDAO.list("APPROVED");
					return new ResponseEntity<List<User>>(user, HttpStatus.OK);
			}
			
			//fetching approved blog list by status
			@GetMapping(value = {"/blog/manage/list"})
			public ResponseEntity<List<Blog>> fetchApprovedBlogs() {
					System.out.println("fetching list of approved blogs");
					List<Blog> blog = blogDAO.getBlogsByStatus("APPROVED");
					return new ResponseEntity<List<Blog>>(blog, HttpStatus.OK);
			}
			//changing user role
			@PostMapping(value = {"/user/role/manage"})
			public ResponseEntity<User> changeUserRole(@RequestBody User user) {
					System.out.println("changing user role");
					userDAO.updateUser(user);
					return new ResponseEntity<User>(user, HttpStatus.OK);
			}
			
			//fetching approved jobs list by status
			@GetMapping(value = {"/job/manage/list"})
			public ResponseEntity<List<Job>> fetchApprovedJobs() {
					System.out.println("fetching list of approved jobs");
					List<Job> job = jobDAO.list("APPROVED");
					return new ResponseEntity<List<Job>>(job, HttpStatus.OK);
			}
			
			//fetching approved event list by status
			@GetMapping(value = {"/event/manage/list"})
			public ResponseEntity<List<Events>> fetchApprovedEvents() {
					System.out.println("fetching list of approved events");
					List<Events> events = eventsDAO.getEventsByStatus("APPROVED");
							return new ResponseEntity<List<Events>>(events, HttpStatus.OK);
					}
			
			//fetching approved forum list by status
			@GetMapping(value = {"/forum/manage/list"})
			public ResponseEntity<List<Forum>> fetchApprovedForums() {
					System.out.println("fetching list of approved forums");
					List<Forum> forum = forumDAO.getForumByStatus("APPROVED");
							return new ResponseEntity<List<Forum>>(forum, HttpStatus.OK);
					}
			
}
