package com.coll.OnlineCollaborateBackEnd.model;


import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
@Component
@Entity(name="UserDetail")
@Table(name="UserDetail")
public class User extends DomainResponse  implements Serializable{
	
	private static final long serialVersionUID = -2800377271876935833L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@SequenceGenerator(name = "generator", sequenceName="users_seq", allocationSize = 1)
	@Column(name="USER_ID")
	int userId;
	String fullname;
	String username;
	String password; 
	@Transient
	String confirmpassword;
	String email;
	String role;
	String status;
	@Column(name="is_online")
	boolean isOnline;
	boolean enabled;
	
	char gender;
	String profile;
	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}




	public String getFullname() {
		return fullname;
	}




	public void setFullname(String fullname) {
		this.fullname = fullname;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getConfirmpassword() {
		return confirmpassword;
	}




	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public boolean isOnline() {
		return isOnline;
	}




	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}




	public boolean isEnabled() {
		return enabled;
	}




	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}




	


	public char getGender() {
		return gender;
	}




	public void setGender(char gender) {
		this.gender = gender;
	}




	
	
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
