package com.coll.OnlineCollaborateBackEnd.implDao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.OnlineCollaborateBackEnd.dao.IFriendDAO;
import com.coll.OnlineCollaborateBackEnd.model.Friend;
import com.coll.OnlineCollaborateBackEnd.model.User;

@Repository("friendDAO")
@Transactional
public class FriendDAOImpl implements IFriendDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Friend> list() {
		return sessionFactory.getCurrentSession().createQuery("from Friend", Friend.class).getResultList();
	}

	@Override
	public List<Friend> list(int id) {
		String q = "FROM Friend where friendId = :id ";
		Query query = sessionFactory.getCurrentSession().createQuery(q);
		query.setParameter("id", id);
		return query.getResultList();
	}

	@Override
	public List<Friend> list(String status) {
		String hql = "FROM Friend where status = '" + status +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Friend getFriend(int id) {
		return sessionFactory.getCurrentSession().get(Friend.class, id);
	}

	@Override
	public boolean addFriend(Friend f) {
		try {
			sessionFactory.getCurrentSession().save(f);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateFriend(Friend f) {
		try {
			sessionFactory.getCurrentSession().update(f);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteFriend(Friend f) {
		try {
			sessionFactory.getCurrentSession().delete(f);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<User> noFriends(int id) {
		String selectQuery = "SELECT * FROM USERDETAIL WHERE USER_ID NOT IN (SELECT INITIATORID FROM FRIEND WHERE FRIENDID = :id OR INITIATORID = :id UNION SELECT FRIENDID FROM FRIEND WHERE FRIENDID = :id OR INITIATORID = :id) AND STATUS = 'APPROVED'";
		return sessionFactory.getCurrentSession().createNativeQuery(selectQuery,User.class).setParameter("id", id).getResultList();
	}

	@Override
	public List<User> myFriends(int id) {
		String selectQuery = "SELECT * FROM USERDETAIL WHERE USER_ID IN (SELECT INITIATORID FROM FRIEND WHERE (FRIENDID = :id OR INITIATORID = :id) AND STATUS = 'APPROVED' UNION SELECT FRIENDID FROM FRIEND WHERE (FRIENDID = :id OR INITIATORID = :id) AND STATUS = 'APPROVED')";
		return sessionFactory.getCurrentSession().createNativeQuery(selectQuery,User.class).setParameter("id", id).getResultList();
	}

}
