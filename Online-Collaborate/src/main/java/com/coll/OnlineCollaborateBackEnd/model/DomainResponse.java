package com.coll.OnlineCollaborateBackEnd.model;

public class DomainResponse {
	int responseCode;
	String responseMessage;
	public DomainResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DomainResponse(int responseCode, String responseMessage) {
		
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
}
