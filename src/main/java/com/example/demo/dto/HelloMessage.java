package com.example.demo.dto;

import org.jboss.logging.Logger;

public class HelloMessage {

	private static Logger log = Logger.getLogger(HelloMessage.class);
	
	private String message;
	
	public HelloMessage(String message) {
		super();
		log.info("constructor HelloMessage(String message) - START");
		log.info("constructor HelloMessage(String message)  - PARAM: \n\n\t{\n\t   message: " + message + "\n\t}\n\n");
		
		this.message = message;
		log.info("constructor HelloMessage(String message)  - DEBUG: \n\n item: {\n\t  this.message: " + this.message + "\n\t}\n\n");

		log.info("constructor HelloMessage(String message) - END");
	}
	
	public HelloMessage() {
		this(null);
		log.info("constructor HelloMessage() - START");
		log.info("constructor HelloMessage() - END");
	}


	public void setMessage(String message) {
		log.info("method setMessage(String message)  - START");
		log.info("method setMessage(String message)  - PARAM: \n\n\t{\n\t  message: " + message + "\n\t}\n\n");

		this.message = message;
		log.info("method setMessage(String message)  - DEBUG: \n\nitem: {\n\t  message: " + message + "\n\t}\n\n");

		log.info("method setMessage(String message)  - END");
	}
	
	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "HelloMessage [message=" + message + "]";
	}
}
