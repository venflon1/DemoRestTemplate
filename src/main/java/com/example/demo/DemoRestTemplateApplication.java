package com.example.demo;

import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.HelloMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@SpringBootApplication
@RestController
public class DemoRestTemplateApplication {

	private static Logger log = Logger.getLogger(DemoRestTemplateApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DemoRestTemplateApplication.class, args);
	}
	
	@RequestMapping(value="api/hello1", method = RequestMethod.GET)
	public String hello1() {
		log.info("method hello1() - START");
		String retValue = "hello world";
		log.info("method hello1() - RETURN: " + retValue);
		log.info("method hello1() - END");
		return retValue;
	}
	

	@RequestMapping(value="api/hello2", method = RequestMethod.GET)
	public String hello2() throws JsonProcessingException {
		log.info("method hello2() - START");
		HelloMessage helloMessage = new HelloMessage("hello");
		log.info("method hello2()  - DEBUG: \n\n item: \t{\n\t   HelloMessage: " + helloMessage + "\n\t}\n\n");
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String jsonToReturnClient = ow.writeValueAsString(helloMessage);
		log.info("method hello2()  - DEBUG: \n\n  jsonToReturnClient" + jsonToReturnClient + "\n\n");
		log.info("method hello2() - RETURN:\n" + jsonToReturnClient);
		log.info("method hello2() - END");
		return jsonToReturnClient;
	}
	
	
	@RequestMapping(value="api/restTemplate1", method = RequestMethod.GET)
	public String clientRest1() {
		log.info("method clientRest1() - START");
		RestTemplate restTemplate = new RestTemplate();
		String retValue = restTemplate.getForObject("http://localhost:8080/api/hello1", String.class);
		log.info("method clientRest1() - RETURN " + retValue);
		log.info("method clientRest1() - END");		
		return retValue;
	}
	
	@RequestMapping(value="api/restTemplate2", method = RequestMethod.GET)
	public HelloMessage clientRest2() {
		log.info("method clientRest2() - START");
		RestTemplate restTemplate = new RestTemplate();
		HelloMessage retValue = restTemplate.getForObject("http://localhost:8080/api/hello2", HelloMessage.class);
		log.info("method clientRest2() - RETURN " + retValue);
		log.info("method clientRest2() - END");		
		return retValue;
	}

}
