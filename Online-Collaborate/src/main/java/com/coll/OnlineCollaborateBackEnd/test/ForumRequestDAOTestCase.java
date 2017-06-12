package com.coll.OnlineCollaborateBackEnd.test;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.OnlineCollaborateBackEnd.dao.IForumDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IForumRequestDAO;
import com.coll.OnlineCollaborateBackEnd.model.Forum;
import com.coll.OnlineCollaborateBackEnd.model.ForumRequest;

public class ForumRequestDAOTestCase {
	private static AnnotationConfigApplicationContext context;
	private static IForumDAO forumDAO;
	private static Forum forum;
	private static IForumRequestDAO forumRequestDAO;
	private static ForumRequest forumRequest;
	
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.coll.OnlineCollaborateBackEnd");
		context.refresh();
		
		forumDAO=(IForumDAO)context.getBean("forumDAO");
		forum=(Forum)context.getBean("forum");
		forumRequestDAO=(IForumRequestDAO)context.getBean("forumRequestDAO");
		forumRequest=(ForumRequest)context.getBean("forumRequest");
	}
	
	/*@Test
	public void addForumRequestTestCase() {
		forumRequest.setId(1);
		forumRequest.setUserId(27);
		forumRequest.setUsername("Veenam");
		forumRequest.setStatus("Pending");
		forum = forumDAO.getForum(1);
		forumRequest.setForum(forum);
		
		
		assertEquals(true, forumRequestDAO.addForumRequest(forumRequest));
	}*/
	
	/*@Test
	public void updateForumRequestTestCase() {
		forumRequest = forumRequestDAO.getForumRequest(1);
		forumRequest.setStatus("Approved");
		assertEquals(true, forumRequestDAO.updateForumRequest(forumRequest));
	}*/
	
	/*@Test
	public void getAllForumRequestTestCase() {
		
		int size = forumRequestDAO.list().size();
		assertEquals(1, size);
	}*/
	
	/*@Test
	public void deleteForumRequestTestCase() {
		forumRequest = forumRequestDAO.getForumRequest(1);
		assertEquals(true, forumRequestDAO.deleteForumRequest(forumRequest));
	}*/
}
