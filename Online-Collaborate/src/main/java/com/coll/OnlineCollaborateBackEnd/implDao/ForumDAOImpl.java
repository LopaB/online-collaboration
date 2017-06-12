package com.coll.OnlineCollaborateBackEnd.implDao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.OnlineCollaborateBackEnd.dao.IForumDAO;
import com.coll.OnlineCollaborateBackEnd.model.Events;
import com.coll.OnlineCollaborateBackEnd.model.Forum;

@Repository("forumDAO")
@Transactional
public class ForumDAOImpl implements IForumDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Forum> list() {
		String hql = "FROM Forum";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Forum getForum(int id) {
		return sessionFactory.getCurrentSession().get(Forum.class, id);
	}
	
	@Override
	public List<Forum> getForumByStatus(String status) {
		String hql = "FROM Forum where status = '" + status +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.getResultList();
	}

	@Override
	public boolean addForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().save(forum);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Forum> mainList() {
		String hql = "FROM Forum order by postDate";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(3); 
		return query.getResultList();
	}


}