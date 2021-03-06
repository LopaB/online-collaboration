package com.coll.OnlineCollaborateBackEnd.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.OnlineCollaborateBackEnd.dao.IBlogCommentsDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IBlogDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IUserDAO;
import com.coll.OnlineCollaborateBackEnd.model.Blog;
import com.coll.OnlineCollaborateBackEnd.model.BlogComments;
import com.coll.OnlineCollaborateBackEnd.model.User;


public class BlogDAOTestCase {
	private static AnnotationConfigApplicationContext context;
	private static IBlogDAO blogDAO;
	private static IUserDAO userDAO;
	private static Blog blog;
	private static BlogComments blogComments;
	private static IBlogCommentsDAO blogCommentsDAO;
	//User user;
	
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.coll.OnlineCollaborateBackEnd");
		context.refresh();
		
		blogDAO=(IBlogDAO)context.getBean("blogDAO");
		userDAO=(IUserDAO)context.getBean("userDAO");
		blogCommentsDAO=(IBlogCommentsDAO)context.getBean("blogCommentsDAO");
		blog=(Blog)context.getBean("blog");
		blogComments=(BlogComments)context.getBean("blogComments");
	}
	

	/*@Test
	public void testAddBlog(){
		blog.setBlogId(1011);
		blog.setBlogTitle("This is test blog");
		blog.setStatus("PENDING");
		blog.setBlogContent("Test");
		blog.setBlogPosted(LocalDate.parse("2007-06-02"));
		blog.setNoOfLikes(2);
		blog.setNoOfComments(3);
		blog.setUserId(27);
		blog.setUsername("veenam");
		assertEquals("Successfully added a blog inside the table!", true, blogDAO.addBlog(blog));
	}*/
	
	/*@Test
	public void updateBlog() {
		blog = blogDAO.getBlog(3);
		blog.setStatus("APPROVED");
		assertEquals("Successfully updated a blog inside the table!",true, blogDAO.updateBlog(blog));
	}*/
	
	/*@Test
	public void getAllBlogsTestCase() {
		
		int size = blogDAO.list().size();
		assertEquals(1, size);
	}*/
	
	/*@Test
	public void deleteBlog() {
		blog = blogDAO.getBlog(3);
		assertEquals("Successfully deleted a blog inside the table!",true, blogDAO.deleteBlog(blog));
	}*/
	
	/*@Test
	public void fetchBlogList() {
		List<Blog> bloglist = blogDAO.mainList();
		for(Blog b1 : bloglist) {
			System.out.println(b1.getNoOfViews());
		}
		assertEquals(1, blogDAO.mainList().size());
	}
	*/
}
