package com.coll.OnlineCollaborateBackEnd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coll.OnlineCollaborateBackEnd.model.DomainResponse;

@RestController
public class GreetingController {
	@RequestMapping(value="/greeting")
	public ResponseEntity<DomainResponse> greeting(){
		return new ResponseEntity<DomainResponse>(new DomainResponse(200,"Welcome from spring RestController"),HttpStatus.OK);
	}
}
