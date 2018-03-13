package com.jwt.client.service;

import org.springframework.web.client.RestTemplate;
import com.jwt.client.model.User;

public class LoginService {

	public String login(User user) {

		final String uri = "http://localhost:8084/token";
		RestTemplate restTemplate = new RestTemplate();
		String token = restTemplate.postForObject(uri, user, String.class);

		return token;

	}

	/*private static void getpayLoad(String tokenStr) {
		String payLoad = "";
		HttpStatus statusCode = null;
		final String uri = "http://localhost:8084/rest/hello";

		
		 * User userObj ; if(user==null) { userObj = new User();
		 * userObj.setUsername("name"); userObj.setUserId("123");
		 * userObj.setRole("admin"); } else { userObj = user; }
		 
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Token " + tokenStr);
		HttpEntity<String> requestBody = new HttpEntity<>(tokenStr, headers);

		
		 * if(userObj!=null) tokenResult = restTemplate.postForObject(uri,
		 * requestBody, String.class);
		 

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
			// return payLoad;
		}
		
		 * else { return "ERROR_GEN_TOKEN"; }
		 

	}

	private static String getLoginToken(User user) {
		HttpStatus statusCode = null;
		final String uri = "http://localhost:8084/token";

		
		 * User userObj ; if(user==null) { userObj = new User();
		 * userObj.setUsername("name"); userObj.setUserId("123");
		 * userObj.setRole("admin"); } else { userObj = user; }
		 
		RestTemplate restTemplate = new RestTemplate();

		String tokenResult = "";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<User> requestBody = new HttpEntity<>(user, headers);

		
		 * if(userObj!=null) tokenResult = restTemplate.postForObject(uri,
		 * requestBody, String.class);
		 

		ResponseEntity<String> responseEntity = null;
		try {
			responseEntity = restTemplate.exchange(uri, HttpMethod.POST, requestBody, String.class);
			statusCode = responseEntity.getStatusCode();
		} catch (Exception e) {
			System.out.println("Error in POST Token " + e.getMessage());
		}

		if (statusCode.equals(HttpStatus.OK)) {
			tokenResult = responseEntity.getBody();
			System.out.println(tokenResult);
			getpayLoad(tokenResult);
			return tokenResult;
		} else {
			return "ERROR_GEN_TOKEN";
		}

	}
*/
}
