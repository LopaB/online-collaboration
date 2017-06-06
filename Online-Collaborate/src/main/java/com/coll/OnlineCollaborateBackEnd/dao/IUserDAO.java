package com.coll.OnlineCollaborateBackEnd.dao;

import java.util.List;

import com.coll.OnlineCollaborateBackEnd.model.User;

public interface IUserDAO {
	
	
	List<User> list(String status);
	List<User> fetchOnlineFriends(int id);
	List<User> fetchMyFriends(int id);
	public List<User> getAllUsers();
	public User getUser(int userId);
	public User getUserByUserName(String username);
	User validateUser(User user);
	public boolean addUser(User u);
	public boolean updateUser(User u);
	public boolean deleteUser(int userId);	
	boolean updateUserProfile(String fileName, Integer id);
}
