package com.example.demo;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class DemoRestTemplateApplication {

	private static Logger log = Logger.getLogger(DemoRestTemplateApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DemoRestTemplateApplication.class, args);
	}
	
	@RequestMapping(value="api/hello", method = RequestMethod.GET)
	public String hello() {
		log.info("method hello() - START");
		String retValue = "hello world";
		log.info("method hello() - RETURN: " + retValue);
		log.info("method hello() - END");
		return retValue;
	}
	
	
	@RequestMapping(value="api/restTemplate", method = RequestMethod.GET)
	public String clientRest() {
		log.info("method clientRest() - START");
		RestTemplate restTemplate = new RestTemplate();
		String retValue = restTemplate.getForObject("http://localhost:8080/api/hello", String.class);
		log.info("method clientRest() - RETURN " + retValue);
		log.info("method clientRest() - END");		
		return retValue;
	}

}
