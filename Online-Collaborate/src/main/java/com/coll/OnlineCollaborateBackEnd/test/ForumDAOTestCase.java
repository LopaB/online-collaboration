package com.coll.OnlineCollaborateBackEnd.test;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.OnlineCollaborateBackEnd.dao.IForumDAO;
import com.coll.OnlineCollaborateBackEnd.model.Forum;

public class ForumDAOTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static IForumDAO forumDAO;
	private static Forum forum;
	
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.coll.OnlineCollaborateBackEnd");
		context.refresh();
		
		forumDAO=(IForumDAO)context.getBean("forumDAO");
		forum=(Forum)context.getBean("forum");
	}
	
	/*@Test
	public void addForumTestCase() {
		forum.setId(1);
		forum.setName("Java");
		forum.setDescription("Group_1");
		forum.setPostDate(LocalDate.parse("2017-06-07"));
		forum.setStatus("PENDING");
				
		assertEquals(true, forumDAO.addForum(forum));
	}*/
	
	/*@Test
	public void updateForumTestCase() {
		forum = forumDAO.getForum(2);
		forum.setName("My_Forum");
		assertEquals(true, forumDAO.updateForum(forum));
	}*/
	
	/*@Test
	public void getAllForumTestCase() {
		
		int size = forumDAO.list().size();
		assertEquals(1, size);
	}*/
	
	/*@Test
	public void deleteForumTestCase() {
		forum = forumDAO.getForum(1);
		assertEquals(true, forumDAO.deleteForum(forum));
	}*/
	
	/*@Test
	public void fetchForumListTestCase() {
		List<Forum> forumlist = forumDAO.mainList();
		for(Forum f1 : forumlist ) {
			System.out.println(f1.getPostDate());
		}
		Assert.assertEquals(3, forumDAO.mainList().size());
	}*/
}
