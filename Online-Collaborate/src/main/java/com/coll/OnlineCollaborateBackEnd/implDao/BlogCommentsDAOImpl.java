package com.coll.OnlineCollaborateBackEnd.implDao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.OnlineCollaborateBackEnd.dao.IBlogCommentsDAO;
import com.coll.OnlineCollaborateBackEnd.model.BlogComments;

@Repository("blogCommentsDAO")
@Transactional
public class BlogCommentsDAOImpl implements IBlogCommentsDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<BlogComments> list(int id) {
		String hql = "FROM BlogComments where blog = " + id +"";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.getResultList();
	}

	@Override
	public BlogComments getBlogComments(int id) {
		return sessionFactory.getCurrentSession().get(BlogComments.class, id);
	}

	@Override
	public boolean addBlogComments(BlogComments blogComments) {
		try {
			sessionFactory.getCurrentSession().save(blogComments);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateBlogComments(BlogComments blogComments) {
		try {
			sessionFactory.getCurrentSession().update(blogComments);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteBlogComments(BlogComments blogComments) {
		try {
			sessionFactory.getCurrentSession().delete(blogComments);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
