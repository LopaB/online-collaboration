package com.coll.OnlineCollaborateBackEnd.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.coll.OnlineCollaborateBackEnd.dao.IFriendDAO;
import com.coll.OnlineCollaborateBackEnd.model.Friend;
import com.coll.OnlineCollaborateBackEnd.model.User;

public class FriendDAOTestCase {
	private static AnnotationConfigApplicationContext context;
	private static IFriendDAO friendDAO;
	private static Friend friend;
	
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.coll.OnlineCollaborateBackEnd");
		context.refresh();
		
		friendDAO=(IFriendDAO)context.getBean("friendDAO");
		friend = (Friend) context.getBean("friend");
		
	}
	
	/*@Test
	public void testAddFriend()
	{
		friend.setId(1);
		friend.setInitiatorId(31);
		friend.setFriendId(27);
		friend.setStatus("PENDING");
		
		assertEquals("Successfully added a friend in the table",true, friendDAO.addFriend(friend));
	}*/
	
	/*@Test
	public void testUpdateFriend(){
		friend = friendDAO.getFriend(1);
		friend.setStatus("APPROVED");
		assertEquals("Successfully updated a friend in the table",true, friendDAO.updateFriend(friend));
	}*/
	
	/*@Test
	public void testDeleteFriend(){
		friend = friendDAO.getFriend(1);
		assertEquals("Successfully deleted a friend in the table",true, friendDAO.deleteFriend(friend));
	}*/
	
	/*@Test
	public void testNoFriends() {
		List<User> users = friendDAO.noFriends(31);
		assertEquals("Test failed!", 7, users.size());
	}*/
	
	/*@Test
	public void testMyFriends() {
		List<User> users = friendDAO.myFriends(31);
		assertEquals("Test failed!", 2, users.size());
	}
	*/
	
}
