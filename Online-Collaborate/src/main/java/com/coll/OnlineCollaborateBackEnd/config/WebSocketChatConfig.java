package com.coll.OnlineCollaborateBackEnd.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
@ComponentScan(basePackages={"com.coll.OnlineCollaborateBackEnd"})
public class WebSocketChatConfig extends AbstractWebSocketMessageBrokerConfigurer{
	//Communication enters and leaves
	 @Override
	  public void configureMessageBroker(MessageBrokerRegistry config) {
	    config.enableSimpleBroker("/topic");
	    config.setApplicationDestinationPrefixes("/app");
	  }
	 //Configuring the endpoint
	  @Override
	  public void registerStompEndpoints(StompEndpointRegistry registry) {
		  
	    registry.addEndpoint("/chat").setAllowedOrigins("http://127.0.0.1:8887").withSockJS();
	  }
}
	