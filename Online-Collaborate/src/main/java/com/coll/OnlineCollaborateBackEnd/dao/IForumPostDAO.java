package com.coll.OnlineCollaborateBackEnd.dao;

import java.util.List;

import com.coll.OnlineCollaborateBackEnd.model.ForumPost;

public interface IForumPostDAO {
	List<ForumPost> list();
	List<ForumPost> list(int id);
	ForumPost getForumPost(int id);
	boolean addForumPost(ForumPost fp);
	boolean updateForumPost(ForumPost fp);
	boolean deleteForumPost(ForumPost fp);
}
