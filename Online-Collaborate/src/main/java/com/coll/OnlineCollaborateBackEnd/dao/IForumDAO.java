package com.coll.OnlineCollaborateBackEnd.dao;

import java.util.List;

import com.coll.OnlineCollaborateBackEnd.model.Events;
import com.coll.OnlineCollaborateBackEnd.model.Forum;

public interface IForumDAO {
	List<Forum> list();
	List<Forum> mainList();
	Forum getForum(int id);
	boolean addForum(Forum f);
	boolean updateForum(Forum f);
	boolean deleteForum(Forum f);
	List<Forum> getForumByStatus(String status);
}
