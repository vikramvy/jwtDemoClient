package com.jwt.client.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jwt.client.model.RegistrationForm;

@Service("registrationService")
public class RegistrationService {

	public boolean register(RegistrationForm registrationForm) {
		HttpStatus statusCode = null;
		final String url = "http://localhost:8084/rest/registration";
		String tokenStr = null;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		if(DbService.tokenMap!=null)
		{
			tokenStr = DbService.tokenMap.get("token");
		}
		System.out.println("Token String for POST is : "+tokenStr);
		
		headers.add("Accept",
				  MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Token "+tokenStr);
		//headers.set("Authorization", "Token " + DbService.tokenMap.get("token"));
		HttpEntity<RegistrationForm> entity = new HttpEntity<>(registrationForm, headers);
		try {
			ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
			statusCode = responseEntity.getStatusCode();
			
		} catch (Exception e) {

			System.out.println("Error in POST Token " + e.getMessage());

			return false;

		}
		if (statusCode.equals(HttpStatus.OK)) {
			return true;
		}

		return false;
	}
	
	
	public List<RegistrationForm> getAllRegisteredUsers()
	{
		List<RegistrationForm> registeredUsers = new ArrayList<RegistrationForm>();
		final String uri = "http://localhost:8084/form/allRegistered";
	
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Token " + DbService.tokenMap.get("token"));
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<RegistrationForm>> rateResponse =
		        restTemplate.exchange(uri,
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<RegistrationForm>>() {
		            });
			registeredUsers = rateResponse.getBody();		
		return registeredUsers;
		
	}
	

	/*private static String getHelloWorldPayLoad(String tokenStr, RegistrationForm registrationData) throws Exception {
		if (tokenStr.isEmpty())
			throw new Exception("Generate Token for the user First ");

		String payLoad = "";
		HttpStatus statusCode = null;
		final String uri = "http://localhost:8084/rest/hello";
		String tokenResult ;
		
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Token " + tokenStr);
		HttpEntity<RegistrationForm> requestBody = new HttpEntity<>(registrationData, headers);

		
		tokenResult = restTemplate.postForObject(uri, requestBody, String.class);

		ResponseEntity<String> responseEntity = null;
		try {
			responseEntity = restTemplate.exchange(uri, HttpMethod.GET, requestBody, String.class);
			statusCode = responseEntity.getStatusCode();
		} catch (Exception e) {
			System.out.println("Error in POST Token " + e.getMessage());
		}
		if (statusCode.equals(HttpStatus.OK)) {
			payLoad = responseEntity.getBody();
			System.out.println(payLoad);
			return payLoad;
		} else {
			return "ERROR_GEN_TOKEN";
		}

	}*/
}
