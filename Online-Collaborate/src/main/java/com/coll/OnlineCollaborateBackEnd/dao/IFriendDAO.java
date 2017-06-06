package com.coll.OnlineCollaborateBackEnd.dao;

import java.util.List;

import com.coll.OnlineCollaborateBackEnd.model.Friend;
import com.coll.OnlineCollaborateBackEnd.model.User;

public interface IFriendDAO {
	
	List<Friend> list();
	List<Friend> list(int id);
	List<Friend> list(String status);
	Friend getFriend(int id);
	boolean addFriend(Friend f);
	boolean updateFriend(Friend f);
	boolean deleteFriend(Friend f);
	List<User> noFriends(int id);
	List<User> myFriends(int id);
}
