package com.coll.OnlineCollaborateBackEnd.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Component
public class Events implements Serializable{
	
	private static final long serialVersionUID = -4596438338429006743L;

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="generator")
	@SequenceGenerator(name="generator", sequenceName="EVENTS_SEQ", allocationSize = 1)
	@Column(name="EVENT_ID")
	int id;
	String name;
	String venue;
	String description;
	String status;
	LocalDate startDate;
	LocalDate endDate;
	LocalDate postDate;
	@OneToMany(mappedBy="events", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<EventJoined> eventJoined;
	public List<EventJoined> getEventJoined() {
		return eventJoined;
	}
	public void setEventJoined(List<EventJoined> eventJoined) {
		this.eventJoined = eventJoined;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public LocalDate getPostDate() {
		return postDate;
	}
	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}
	/*public List<EventJoined> getEventJoined() {
		return eventJoined;
	}
	public void setEventJoined(List<EventJoined> eventJoined) {
		this.eventJoined = eventJoined;
	}*/
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}