package com.coll.OnlineCollaborateBackEnd.test;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.OnlineCollaborateBackEnd.dao.IEventJoinedDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IEventsDAO;
import com.coll.OnlineCollaborateBackEnd.model.EventJoined;
import com.coll.OnlineCollaborateBackEnd.model.Events;

public class EventJoinedDAOTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static IEventsDAO eventsDAO;
	private static Events events;
	private static IEventJoinedDAO eventJoinedDAO;
	private static EventJoined eventJoined;
	
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.coll.OnlineCollaborateBackEnd");
		context.refresh();
		
		eventsDAO=(IEventsDAO)context.getBean("eventsDAO");
		events=(Events)context.getBean("events");
		eventJoinedDAO=(IEventJoinedDAO)context.getBean("eventJoinedDAO");
		eventJoined=(EventJoined)context.getBean("eventJoined");
	}
	
	/*@Test
	public void addEventJoined() {
		
		eventJoined.setId(1);
		eventJoined.setJoinedDate(LocalDate.parse("2017-06-08"));
		events = eventsDAO.getEvent(1);
		eventJoined.setEvents(events);
		eventJoined.setStatus("PENDING");
		eventJoined.setUserId(27);
		eventJoined.setUsername("Veenam");
		assertEquals(true, eventJoinedDAO.addEventJoined(eventJoined));
		
	}*/
	
	/*@Test
	public void updateEventsJoined() {
		eventJoined = eventJoinedDAO.getEventJoined(2);
		eventJoined.setStatus("Approved");
		assertEquals(true, eventJoinedDAO.updateEventJoined(eventJoined));
	}*/
	
	/*@Test
	public void getAllEventsJoinedTestCase() {
		
		int size = eventJoinedDAO.list().size();
		assertEquals(3, size);
	}*/
	
	/*@Test
	public void deleteEventJoined() {
		eventJoined = eventJoinedDAO.getEventJoined(1);
		assertEquals(true, eventJoinedDAO.deleteEventJoined(eventJoined));
	}*/
}