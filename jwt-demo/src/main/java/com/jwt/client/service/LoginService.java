package com.jwt.client.service;



import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.jwt.client.model.User;
import com.jwt.client.model.RegistrationForm;
import com.jwt.client.model.TokenHolder;
public class LoginService {
	
	 public boolean login(User user){
		 
	//TO actual api call to the jwt server	 
		/*final String uri = "http://localhost:8090/authenticate";
		 RestTemplate restTemplate = new RestTemplate();
		 User userfromServer = restTemplate.postForObject( uri, user, User.class);
		 */
		 String userJwtToken = getLoginToken(user);
		 
		if (!userJwtToken.equals("ERROR_GEN_TOKEN")){
			TokenHolder tokenHolder = new TokenHolder(userJwtToken);
		return true;
		}
		return false;
		 
		/* return true;*/
	 
	 }

	 private static void getpayLoad(String tokenStr)
	 {
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
	      HttpEntity<String> requestBody = new HttpEntity<>(tokenStr, headers);
	      
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
	    	//return payLoad;
	    }	    
	   /* else
	    {
	    	return "ERROR_GEN_TOKEN";
	    }*/
	     
	 }

	 
	 
	 private static String getLoginToken(User user)
	 {
		 HttpStatus statusCode = null;
	     final String uri = "http://localhost:8084/token";
	   
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
	     
	     String tokenResult = "";
	    
	     HttpHeaders headers = new HttpHeaders();
	      headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
	      headers.setContentType(MediaType.APPLICATION_JSON); 
	      HttpEntity<User> requestBody = new HttpEntity<>(user, headers);
	      
	    /*if(userObj!=null)
	    	tokenResult = restTemplate.postForObject(uri, requestBody, String.class);*/
	      
	      ResponseEntity<String> responseEntity = null;
	   try {
		   responseEntity =  restTemplate.exchange(uri, HttpMethod.POST, requestBody, String.class);
		   statusCode = responseEntity.getStatusCode();
	   }catch (Exception e)
	   {
		   System.out.println("Error in POST Token "+e.getMessage());
	   }
	  
	    if(statusCode.equals(HttpStatus.OK)) {
	    	tokenResult = responseEntity.getBody();
	    	System.out.println(tokenResult);
	    	getpayLoad(tokenResult);
	    	return tokenResult;
	    }	    
	    else
	    {
	    	return "ERROR_GEN_TOKEN";
	    }
	     
	 }
	 
	 
}
