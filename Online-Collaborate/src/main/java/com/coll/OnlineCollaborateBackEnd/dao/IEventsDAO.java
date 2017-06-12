package com.coll.OnlineCollaborateBackEnd.dao;

import java.util.List;

import com.coll.OnlineCollaborateBackEnd.model.Events;

public interface IEventsDAO {
	List<Events> list();
	List<Events> mainList();
	List<Events> getEventsByStatus(String status);
	List<Events> getUserEvents(int id);
	Events getEvent(int id);
	boolean addEvent(Events e);
	boolean updateEvent(Events e);
	boolean deleteEvent(Events e);
}
