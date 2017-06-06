package com.coll.OnlineCollaborateBackEnd.controller;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.OnlineCollaborateBackEnd.dao.IBlogCommentsDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IBlogDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IUserDAO;
import com.coll.OnlineCollaborateBackEnd.model.Blog;
import com.coll.OnlineCollaborateBackEnd.model.BlogComments;
import com.coll.OnlineCollaborateBackEnd.model.User;

@RestController
@CrossOrigin(origins="http://localhost:8887")
public class BlogCommentsController {
	@Autowired
	Blog blog;
	
	@Autowired
	IBlogDAO blogDAO;
	
	@Autowired
	IBlogCommentsDAO blogCommentsDAO;
	
	@Autowired
	User user;
	
	@Autowired
	IUserDAO userDAO;
	
	//Method for creating a new blog comment
	
			@PostMapping(value = {"/blog/comment/new/{id}"})
			public ResponseEntity<BlogComments> addBlogComment(@PathVariable("id") int id, @RequestBody BlogComments blogComments) {
				System.out.println("Adding blog comment now");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDateTime now = LocalDateTime.now(); 
				blogComments.setCommentDate(LocalDate.parse(dtf.format(now)));
				blog = blogDAO.getBlog(id);
				blog.setNoOfComments(blog.getNoOfComments() + 1);
				blogDAO.updateBlog(blog);
				blogComments.setBlog(blog);
				blogComments.setUserProfileId(userDAO.getUser(blogComments.getUserId()).getProfile());
				blogCommentsDAO.addBlogComments(blogComments);
				
				return new ResponseEntity<BlogComments>(blogComments, HttpStatus.OK);	
			}
			
			//Method for fetching blog comment list
			@GetMapping(value = {"/blog/comment/list/{id}"})
			public ResponseEntity<List<BlogComments>> fetchBlogComments(@PathVariable("id") int id) {
				System.out.println("fetching list of blog comments");
				List<BlogComments> blogComments = blogCommentsDAO.list(id);
				return new ResponseEntity<List<BlogComments>>(blogComments, HttpStatus.OK);
			}
}
