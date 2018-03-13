package com.jwt.client.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.jwt.client.model.RegistrationForm;

public class RegistrationService {

	public boolean register(RegistrationForm registrationForm) {
		HttpStatus statusCode = null;
		final String url = "http://localhost:8084//rest/hello";

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Token " + DbService.tokenMap.get("token"));
		HttpEntity<RegistrationForm> entity = new HttpEntity<>(registrationForm, headers);
		try {
			ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
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

	/*
	 * private static String getHelloWorldPayLoad(String tokenStr,
	 * RegistrationForm registrationData) throws Exception {
	 * if(tokenStr.isEmpty()) throw new Exception(
	 * "Generate Token for the user First ");
	 * 
	 * String payLoad = ""; HttpStatus statusCode = null; final String uri =
	 * "http://localhost:8084/rest/hello";
	 * 
	 * User userObj ; if(user==null) { userObj = new User();
	 * userObj.setUsername("name"); userObj.setUserId("123");
	 * userObj.setRole("admin"); } else { userObj = user; } RestTemplate
	 * restTemplate = new RestTemplate();
	 * 
	 * HttpHeaders headers = new HttpHeaders(); headers.add("Accept",
	 * MediaType.APPLICATION_JSON_VALUE);
	 * headers.setContentType(MediaType.APPLICATION_JSON);
	 * headers.add("Authorization", "Token "+tokenStr);
	 * HttpEntity<RegistrationForm> requestBody = new
	 * HttpEntity<>(registrationData, headers);
	 * 
	 * if(userObj!=null) tokenResult = restTemplate.postForObject(uri,
	 * requestBody, String.class);
	 * 
	 * ResponseEntity<String> responseEntity = null; try { responseEntity =
	 * restTemplate.exchange(uri, HttpMethod.GET, requestBody, String.class);
	 * statusCode = responseEntity.getStatusCode(); }catch (Exception e) {
	 * System.out.println("Error in POST Token "+e.getMessage()); }
	 * if(statusCode.equals(HttpStatus.OK)) { payLoad =
	 * responseEntity.getBody(); System.out.println(payLoad); return payLoad; }
	 * else { return "ERROR_GEN_TOKEN"; }
	 * 
	 * }
	 */

}
