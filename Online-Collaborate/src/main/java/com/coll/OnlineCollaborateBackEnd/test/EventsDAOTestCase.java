package com.coll.OnlineCollaborateBackEnd.test;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.coll.OnlineCollaborateBackEnd.dao.IEventsDAO;
import com.coll.OnlineCollaborateBackEnd.model.Events;



public class EventsDAOTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static IEventsDAO eventsDAO;
	private static Events events;
	
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.coll.OnlineCollaborateBackEnd");
		context.refresh();
		
		eventsDAO=(IEventsDAO)context.getBean("eventsDAO");
		events=(Events)context.getBean("events");
	}
	
	/*@Test
	public void addEvent() {
		events.setId(1);
		events.setName("Event1");
		events.setStartDate(LocalDate.parse("2017-06-08"));
		events.setEndDate(LocalDate.parse("2007-06-09"));
		events.setPostDate(LocalDate.parse("2007-06-07"));
		events.setStatus("PENDING");
		events.setDescription("This is a event");
		events.setVenue("Delhi");
		assertEquals("Successfully added an event to the table",true, eventsDAO.addEvent(events));
		
	}*/
	
	/*@Test
	public void updateEvents() {
		events = eventsDAO.getEvent(1);
		events.setStatus("APPROVED");
		assertEquals(true, eventsDAO.updateEvent(events));
	}*/
	
	/*@Test
	public void getAllEventsTestCase() {
		
		int size = eventsDAO.list().size();
		assertEquals(1, size);
	}*/
	
	/*@Test
	public void deleteEvents() {
		events = eventsDAO.getEvent(3);
		assertEquals(true, eventsDAO.deleteEvent(events));
	}*/
}