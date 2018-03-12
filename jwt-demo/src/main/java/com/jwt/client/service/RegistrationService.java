package com.jwt.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.client.RestTemplate;

import com.jwt.client.model.RegistrationForm;
import com.jwt.client.model.User;


public class RegistrationService {
	@Autowired
    private ApplicationContext appContext;
	
	 public boolean register(RegistrationForm registrationForm){
		 String result = new String();
		 
		  
		/*  
		 try {
			 result = getHelloWorldPayLoad(registrationData);
		 }*/
			//TO actual api call to the jwt server	 
				return true;
			 
 }
	 
	 private static String getHelloWorldPayLoad(String tokenStr, RegistrationForm registrationData) throws Exception 
	 {
		 if(tokenStr.isEmpty())
			 throw new Exception("Generate Token for the user First ");
		  
		 String payLoad = "";
		 HttpStatus statusCode = null;
	     final String uri = "http://localhost:8084/rest/hello";
	     
	    /* User userObj ;
	     if(user==null) {  
	     userObj = new User();
	     userObj.setUsername("name");
	     userObj.setUserId("123");
	     userObj.setRole("admin");
	     }
	     else {
	    	 userObj = user;
	     }*/
	     RestTemplate restTemplate = new RestTemplate();
	    
	     HttpHeaders headers = new HttpHeaders();
	      headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
	      headers.setContentType(MediaType.APPLICATION_JSON); 
	      headers.add("Authorization", "Token "+tokenStr);
	      HttpEntity<RegistrationForm> requestBody = new HttpEntity<>(registrationData, headers);
	      
	    /*if(userObj!=null)
	    	tokenResult = restTemplate.postForObject(uri, requestBody, String.class);*/
	      
	      ResponseEntity<String> responseEntity = null;
	   try {
		   responseEntity =  restTemplate.exchange(uri, HttpMethod.GET, requestBody, String.class);
		   statusCode = responseEntity.getStatusCode();
	   }catch (Exception e)
	   {
		   System.out.println("Error in POST Token "+e.getMessage());
	   }
	    if(statusCode.equals(HttpStatus.OK)) {
	    	payLoad = responseEntity.getBody();
	    	System.out.println(payLoad);
	    	return payLoad;
	    }	    
	    else
	    {
	    	return "ERROR_GEN_TOKEN";
	    }
	     
	 }

}
