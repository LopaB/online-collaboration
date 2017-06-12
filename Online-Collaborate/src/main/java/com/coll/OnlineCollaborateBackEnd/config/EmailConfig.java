package com.coll.OnlineCollaborateBackEnd.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan("com.coll.OnlineCollaborateBackEnd")
public class EmailConfig {
	
	@Bean("mailSender")
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();						
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);//Port for TLS/STARTTLS: 587, Port for SSL: 465
		mailSender.setUsername("pinkfriend@gmail.com");
		mailSender.setPassword("idontknowthepassword");
		mailSender.setJavaMailProperties(getMailProperties());				
		return mailSender;
	}

	private Properties getMailProperties() {
		Properties mailProperties = new Properties();		
		mailProperties.put("mail.transport.protocol", "smtp");//simple mail transfer protocol. in Transport layer security not in SSL
		mailProperties.put("mail.smtp.auth", "true");//send mail in javax.mail with authentication
		mailProperties.put("mail.smtp.starttls.enable", "true");//for safe mail sending from java
		mailProperties.put("mail.debug", "true");//to print on the tomcat server
		return mailProperties;
	}		
}
