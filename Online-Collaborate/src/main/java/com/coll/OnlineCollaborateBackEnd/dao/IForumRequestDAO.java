package com.coll.OnlineCollaborateBackEnd.dao;

import java.util.List;

import com.coll.OnlineCollaborateBackEnd.model.ForumRequest;

public interface IForumRequestDAO {
	List<ForumRequest> list();
	List<ForumRequest> list(String status);
	List<ForumRequest> list(int id);
	ForumRequest getForumRequest(int id);
	boolean addForumRequest(ForumRequest fr);
	boolean updateForumRequest(ForumRequest fr);
	boolean deleteForumRequest(ForumRequest fr);
}
