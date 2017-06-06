package com.coll.OnlineCollaborateBackEnd.controller;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.coll.OnlineCollaborateBackEnd.model.Message;
import com.coll.OnlineCollaborateBackEnd.model.OutputMessage;


@Controller
public class ChatController {

	  @MessageMapping("/chat")
	  @SendTo("/topic/message")
	  public OutputMessage sendMessage(Message message) {
	    return new OutputMessage(message, new Date());
	  }
}
