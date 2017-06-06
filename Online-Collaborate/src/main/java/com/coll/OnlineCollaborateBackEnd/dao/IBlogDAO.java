package com.coll.OnlineCollaborateBackEnd.dao;

import java.util.List;

import com.coll.OnlineCollaborateBackEnd.model.Blog;
import com.coll.OnlineCollaborateBackEnd.model.User;

public interface IBlogDAO {
	List<Blog> list();
	List<Blog> getBlogsByStatus(String status);
	List<Blog> getUsersBlogs(int id);
	List<Blog> mainList();
	Blog getBlog(int id);
	boolean addBlog(Blog blog);
	boolean updateBlog(Blog blog);
	boolean deleteBlog(Blog blog);	
}
