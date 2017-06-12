package com.coll.OnlineCollaborateBackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.OnlineCollaborateBackEnd.dao.IForumDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IForumRequestDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IUserDAO;
import com.coll.OnlineCollaborateBackEnd.model.Forum;
import com.coll.OnlineCollaborateBackEnd.model.ForumRequest;
import com.coll.OnlineCollaborateBackEnd.model.User;

@RestController
public class ForumRequestController {

	@Autowired
	IForumRequestDAO forumRequestDAO;
	
	@Autowired
	IForumDAO forumDAO;
	
	@Autowired
	IUserDAO userDAO;
	
	//Method to send forum join request
			@PostMapping(value = {"/forum/request/{id}"})
			public ResponseEntity<ForumRequest> addForumRequest(@PathVariable("id") int id, @RequestBody Integer forumId) {
				System.out.println("Success!");
				ForumRequest forumRequest = new ForumRequest();
				Forum forum = null;
				User user = null;
				user = userDAO.getUser(id); //Fetching user by user id
				forumRequest.setUserId(id);
				String username = user.getUsername();
				forumRequest.setUsername(username);
				forum = forumDAO.getForum(forumId); //Fetching forum with forum Id
				forumRequest.setForum(forum);
				if( user.getRole().equals("Super_Admin") || user.getRole().equals("ADMIN") ) {
					forumRequest.setStatus("APPROVED");
				} else {
					forumRequest.setStatus("PENDING");
				}
				
				forumRequestDAO.addForumRequest(forumRequest);
				return new ResponseEntity<ForumRequest>(forumRequest, HttpStatus.OK);
			}
			
			
			//Method for fetching list of participated users
			@GetMapping(value = {"/forum/participatedUsers/list/{id}"})
			public ResponseEntity<List<ForumRequest>> fetchParticipatedUsers(@PathVariable("id") int id) {
				System.out.println("Fetching list of users");
				List<ForumRequest> forumRequests = forumRequestDAO.list(id);
				return new ResponseEntity<List<ForumRequest>>(forumRequests, HttpStatus.OK);
			}
}
