package com.coll.OnlineCollaborateBackEnd.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coll.OnlineCollaborateBackEnd.dao.IBlogDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IUserDAO;
import com.coll.OnlineCollaborateBackEnd.model.Blog;
import com.coll.OnlineCollaborateBackEnd.model.User;


@RestController
@CrossOrigin(origins="http://localhost:8887")
public class BlogController {
	@Autowired
	IBlogDAO blogDAO;
	@Autowired 
	IUserDAO userDAO;
	
	//Method for creating a new blog
	
		@PostMapping(value = {"/blog/new"})
		public ResponseEntity<Blog> addBlog(@RequestBody Blog blog) {
			System.out.println("Adding blog now");
			int id = blog.getUserId();
			User user = userDAO.getUser(id);
			if( user.getRole().equals("Super_Admin") || user.getRole().equals("ADMIN") ) {
				blog.setStatus("APPROVED");
			} else {
				blog.setStatus("PENDING");
			}
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime now = LocalDateTime.now(); 
			blog.setBlogPosted(LocalDate.parse(dtf.format(now)));
			blog.setNoOfLikes(0);
			blog.setNoOfViews(0);
			blog.setNoOfComments(0);
			
			blogDAO.addBlog(blog);
			
			return new ResponseEntity<Blog>(blog, HttpStatus.OK);	
		}
		
		@PostMapping(value = {"/blog/delete/{blogId}"})
		public ResponseEntity<Blog> deleteBlog(@PathVariable("blogId") int id) {
			Blog blog = null;
			blog = blogDAO.getBlog(id);
			blog.setStatus("REJECTED");
			blogDAO.updateBlog(blog);
			return new ResponseEntity<Blog>(blog, HttpStatus.OK);	
		}
		
		@PostMapping(value = {"/blog/update"})
		public ResponseEntity<Blog> deleteBlog(@RequestBody Blog blog) {
			blogDAO.updateBlog(blog);
			return new ResponseEntity<Blog>(blog, HttpStatus.OK);	
		}
		//Method for viewing single blog using blog id as a parameter
		
		@GetMapping(value = {"/blog/{id}"})
		public ResponseEntity<Blog> viewBlog(@PathVariable("id") int id) {
			System.out.println("Calling method");
			Blog blog = null;
			blog = blogDAO.getBlog(id);
			if(blog.getStatus().equals("APPROVED")) {
				blog.setNoOfViews(blog.getNoOfViews() + 1);
			} else {
				blog.setNoOfViews(0);
			}
			
			blogDAO.updateBlog(blog);
			if(blog == null) {
				blog = new Blog();
				blog.setResponseCode(404);
				blog.setResponseMessage("Blog not found!");
			}
			return new ResponseEntity<Blog>(blog, HttpStatus.OK);
			
		}
		
		//Method for fetching user's blogs
		@GetMapping(value = {"/user/blogs/list/{id}"})
		public ResponseEntity<List<Blog>> fetchUsersBlogs(@PathVariable("id") int id) {
			System.out.println("Fetching users blogs");
			List<Blog> blog = blogDAO.getUsersBlogs(id);
			return new ResponseEntity<List<Blog>>(blog, HttpStatus.OK);
		}
		
		//Method for fetching bloglist
		@GetMapping(value = {"/blog/list"})
		public ResponseEntity<List<Blog>> fetchBlogs() {
			System.out.println("fetching list of blogs");
			List<Blog> blog = blogDAO.list();
			return new ResponseEntity<List<Blog>>(blog, HttpStatus.OK);
		}
		
		//Method for fetching blog list by status
		@GetMapping(value = {"/blog/list/status"})
		public ResponseEntity<List<Blog>> fetchApprovedBlogs() {
			System.out.println("fetching list of blogs by status");
			List<Blog> blog = blogDAO.getBlogsByStatus("APPROVED");
			return new ResponseEntity<List<Blog>>(blog, HttpStatus.OK);
		}
		
		//Method to like blog
		@PostMapping(value = {"/blog/like/{id}"})
			public ResponseEntity<Blog> likes(@PathVariable("id") int id) {
				System.out.println("liking blog");
				Blog blog = new Blog();
				blog = blogDAO.getBlog(id);
				int like = blog.getNoOfLikes();
				blog.setNoOfLikes(like + 1);
				blogDAO.updateBlog(blog);
				return new ResponseEntity<Blog>(blog, HttpStatus.OK);
			}

}
