package com.coll.OnlineCollaborateBackEnd.dao;

import java.util.List;

import com.coll.OnlineCollaborateBackEnd.model.BlogComments;

public interface IBlogCommentsDAO {

	List<BlogComments> list(int id);
	BlogComments getBlogComments(int id);
	boolean addBlogComments(BlogComments blogComments);
	boolean updateBlogComments(BlogComments blogComments);
	boolean deleteBlogComments(BlogComments blogComments);
}
