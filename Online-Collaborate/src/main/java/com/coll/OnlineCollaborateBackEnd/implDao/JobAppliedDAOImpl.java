package com.coll.OnlineCollaborateBackEnd.implDao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.OnlineCollaborateBackEnd.dao.IJobAppliedDAO;
import com.coll.OnlineCollaborateBackEnd.model.JobApplied;

@Repository("jobAppliedDAO")
@Transactional
public class JobAppliedDAOImpl implements IJobAppliedDAO {

	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<JobApplied> list() {
		String hql = "FROM JobApplied";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.getResultList();
	}
	
	@Override
	public List<JobApplied> list(int id) {
		String hql = "FROM JobApplied where userId = '" + id +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.getResultList();
	}

	@Override
	@Transactional
	public JobApplied getJobApplied(int id) {
		return sessionFactory.getCurrentSession().get(JobApplied.class, id);
	}

	@Override
	public boolean addJobApplied(JobApplied jobApplied) {
		try {
			sessionFactory.getCurrentSession().save(jobApplied);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateJobApplied(JobApplied jobApplied) {
		try {
			sessionFactory.getCurrentSession().update(jobApplied);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteJobApplied(JobApplied jobApplied) {
		try {
			sessionFactory.getCurrentSession().delete(jobApplied);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
