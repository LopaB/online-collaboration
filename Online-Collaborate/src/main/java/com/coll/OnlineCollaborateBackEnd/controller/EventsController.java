package com.coll.OnlineCollaborateBackEnd.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.OnlineCollaborateBackEnd.dao.IEventJoinedDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IEventsDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IUserDAO;
import com.coll.OnlineCollaborateBackEnd.model.EventJoined;
import com.coll.OnlineCollaborateBackEnd.model.Events;
import com.coll.OnlineCollaborateBackEnd.model.User;

@RestController
public class EventsController {

	@Autowired
	IEventsDAO eventsDAO;
	
	@Autowired
	IUserDAO userDAO;
	
	@Autowired
	IEventJoinedDAO eventJoinedDAO;
	
	
	
	//Method for creating a new event
	
		@PostMapping(value = {"/events/new"})
		public ResponseEntity<Events> addEvents(@RequestBody Events events) {
			System.out.println("Adding events now");
			events.setStatus("APPROVED");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime now = LocalDateTime.now(); 
			events.setPostDate(LocalDate.parse(dtf.format(now)));
			eventsDAO.addEvent(events);
			
			return new ResponseEntity<Events>(events, HttpStatus.OK);		
		}
		
		//Method for fetching event list by status
		@GetMapping(value = {"/events/list/status"})
		public ResponseEntity<List<Events>> fetchApprovedEvents() {
			System.out.println("fetching list of events by status");
			List<Events> events = eventsDAO.getEventsByStatus("APPROVED");
			return new ResponseEntity<List<Events>>(events, HttpStatus.OK);
		}
		
		//Method for fetching user's jobs
		@GetMapping(value = {"/user/events/list/{id}"})
		public ResponseEntity<List<Events>> fetchUserEvents(@PathVariable("id") int id) {
			System.out.println("Fetching users events");
			List<Events> events = eventsDAO.getUserEvents(id);
			return new ResponseEntity<List<Events>>(events, HttpStatus.OK);
			}
		
		//Method to join event
		@PostMapping(value = {"/event/join/{id}"})
		public ResponseEntity<EventJoined> joinEvent(@PathVariable("id") int id,  @RequestBody Integer userId) {
				System.out.println("Applying for event");
				Events events= eventsDAO.getEvent(id);
				User user = userDAO.getUser(userId);
				EventJoined eventJoined= new EventJoined();
				eventJoined.setEvents(events);
				eventJoined.setUserId(userId);
				eventJoined.setUsername(user.getUsername());
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDateTime now = LocalDateTime.now(); 
				eventJoined.setJoinedDate(LocalDate.parse(dtf.format(now)));
				eventJoined.setStatus("APPROVED");
				eventJoinedDAO.addEventJoined(eventJoined);
				return new ResponseEntity<EventJoined>(eventJoined, HttpStatus.OK);	
			}
		
		@PostMapping(value = {"/event/delete/{id}"})
		public ResponseEntity<Events> deleteEvent(@PathVariable("id") int id) {
			Events events= eventsDAO.getEvent(id);
			System.out.println("Deleting event now");
			events.setStatus("REJECTED");
			eventsDAO.updateEvent(events);
			
			return new ResponseEntity<Events>(events, HttpStatus.OK);		
		}
		
		

}
