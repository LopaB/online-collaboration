package com.coll.OnlineCollaborateBackEnd.test;
import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Test;
import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.OnlineCollaborateBackEnd.dao.IBlogCommentsDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IBlogDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IUserDAO;
import com.coll.OnlineCollaborateBackEnd.model.Blog;
import com.coll.OnlineCollaborateBackEnd.model.BlogComments;

public class BlogCommentsDAOTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static IBlogDAO blogDAO;
	private static IUserDAO userDAO;
	private static Blog blog;
	private static BlogComments blogComments;
	private static IBlogCommentsDAO blogCommentsDAO;
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.coll.OnlineCollaborateBackEnd");
		context.refresh();
		blogDAO=(IBlogDAO)context.getBean("blogDAO");
		blogCommentsDAO=(IBlogCommentsDAO)context.getBean("blogCommentsDAO");
		blog=(Blog)context.getBean("blog");
		blogComments=(BlogComments)context.getBean("blogComments");
	}
	
	/*@Test
	public void addBlogCommentTest() {
		blogComments.setBlogCommentId(1);
		blogComments.setBlogComment("This is a comment");
		blogComments.setNoOfLikes(5);
		blogComments.setUserId(27);
		blogComments.setUsername("veenam");
		blogComments.setCommentDate(LocalDate.parse("2017-06-03"));
		blog = blogDAO.getBlog(3);
		blogComments.setBlog(blog);
		assertEquals(true, blogCommentsDAO.addBlogComments(blogComments));
	}*/
	
	/*@Test
	public void updateBlogCommentTestCase() {
		blogComments = blogCommentsDAO.getBlogComments(1);
		blogComments.setNoOfLikes(7);
		assertEquals(true, blogCommentsDAO.updateBlogComments(blogComments));
	}*/
	
	/*@Test
	public void getAllBlogCommentTestCase() {
		
		int size = blogCommentsDAO.list(3).size();
		assertEquals(1, size);
	}*/
	
	/*@Test
	public void deleteBlogComment() {
		blogComments = blogCommentsDAO.getBlogComments(1);
		assertEquals(true, blogCommentsDAO.deleteBlogComments(blogComments));
	}*/
}
