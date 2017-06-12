package com.coll.OnlineCollaborateBackEnd.dao;

import java.util.List;

import com.coll.OnlineCollaborateBackEnd.model.EventJoined;

public interface IEventJoinedDAO {
	List<EventJoined> list();
	List<EventJoined> list(int id);
	EventJoined getEventJoined(int id);
	boolean addEventJoined(EventJoined ej);
	boolean updateEventJoined(EventJoined ej);
	boolean deleteEventJoined(EventJoined ej);
}
