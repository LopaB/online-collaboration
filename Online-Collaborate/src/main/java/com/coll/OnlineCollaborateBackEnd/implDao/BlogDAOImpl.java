package com.coll.OnlineCollaborateBackEnd.implDao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.OnlineCollaborateBackEnd.dao.IBlogDAO;
import com.coll.OnlineCollaborateBackEnd.model.Blog;
import com.coll.OnlineCollaborateBackEnd.model.User;

@Repository("blogDAO")
@Transactional
public class BlogDAOImpl implements IBlogDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Blog> list() {
		return sessionFactory.getCurrentSession().createQuery("from Blog", Blog.class).getResultList();
		
	}

	@Override
	public List<Blog> mainList() {
		String hql = "FROM Blog where status = 'APPROVED' order by noOfViews desc ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(5); 
		return query.getResultList();
	}
	
	@Override
	public List<Blog> getBlogsByStatus(String status) {
		String hql = "FROM Blog where status = '" + status +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.getResultList();
	}
	
	@Override
	public List<Blog> getUsersBlogs(int id) {
		String hql = "FROM Blog where USERID = '" + id +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.getResultList();
	}
	
	@Override
	public Blog getBlog(int id) {
		return sessionFactory.getCurrentSession().get(Blog.class, id);
	}
	
	@Override
	public boolean addBlog(Blog b) {
		try {
			sessionFactory.getCurrentSession().save(b);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateBlog(Blog b) {
		try {
			sessionFactory.getCurrentSession().update(b);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteBlog(Blog b) {
		try {
			sessionFactory.getCurrentSession().delete(b);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}