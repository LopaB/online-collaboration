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
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Component
@Table(name="JOB_DETAIL")
public class Job implements Serializable{
	
	private static final long serialVersionUID = 2197364482764920824L;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="generator")
	@SequenceGenerator(name="generator", sequenceName="JOB_SEQ", allocationSize = 1)
	@Column(name="JOB_ID")
	int id;
	String companyName;
	String subTitle;
	String about;
	String jobProfile;
	String qualification;
	String contactInfo;
	LocalDate postDate;
	String status;
	@OneToMany(mappedBy="job", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<JobApplied> jobApplied;
	public List<JobApplied> getJobApplied() {
		return jobApplied;
	}
	public void setJobApplied(List<JobApplied> jobApplied) {
		this.jobApplied = jobApplied;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getJobProfile() {
		return jobProfile;
	}
	public void setJobProfile(String jobProfile) {
		this.jobProfile = jobProfile;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public LocalDate getPostDate() {
		return postDate;
	}
	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
