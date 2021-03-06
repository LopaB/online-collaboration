package com.coll.OnlineCollaborateBackEnd.implDao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import com.coll.OnlineCollaborateBackEnd.dao.IEventsDAO;
import com.coll.OnlineCollaborateBackEnd.model.Events;

@Repository("eventsDAO")
@Transactional
public class EventsDAOImpl implements IEventsDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	
	public List<Events> list() {
		String hql = "FROM Events";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.getResultList();
	}
	
	@Override
	public List<Events> getEventsByStatus(String status) {
		String hql = "FROM Events where status = '" + status +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.getResultList();
	}
	
	@Override
	public List<Events> getUserEvents(int id) {
		String hql = "FROM Events where USERID = '" + id +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.getResultList();
	}

	@Override
	@Transactional
	public Events getEvent(int id) {
		return sessionFactory.getCurrentSession().get(Events.class, id);
	}

	@Override
	public boolean addEvent(Events event) {
		try {
			sessionFactory.getCurrentSession().save(event);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateEvent(Events event) {
		try {
			sessionFactory.getCurrentSession().update(event);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteEvent(Events event) {
		try {
			sessionFactory.getCurrentSession().delete(event);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Events> mainList() {
		String hql = "FROM Events where status = 'APPROVED' order by postDate desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(3);
		return query.getResultList();
	}

}
