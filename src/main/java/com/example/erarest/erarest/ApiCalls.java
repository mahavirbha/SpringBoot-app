package com.example.erarest.erarest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ApiCalls {
    static RestTemplate restTemplate = new RestTemplate();
	static String baseUrl = "http://api.exchangeratesapi.io/v1/";

    static String apiCallByCountry(String cur) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl + "latest?access_key=45635c8a14cdfb8fc5418a2dbe0242da", HttpMethod.GET, requestEntity,String.class);

		HttpStatus statuscode = responseEntity.getStatusCode(); //status
		System.out.println("status code - " + statuscode);
		String user = String.format("%s", responseEntity.getBody()); //body
		String[] splitt = user.split(",");
		String s = '"' + cur + '"';
		String result = "";
		for (String string : splitt) {
			String[] str = string.split(":");
			boolean flag = false;
			if (str[0].equals(s)) {
				result = "Currency Rate : "+ string;
				flag = true;
			}
			if (flag) {
				break;
			}
		}
		return result;
	}
	/*
    public static void apiCallLatestFull() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);

		ResponseEntity<Object> responseEntity = restTemplate.exchange(
				baseUrl + "latest?access_key=45635c8a14cdfb8fc5418a2dbe0242da", HttpMethod.GET, requestEntity,
				Object.class);
		HttpStatus statuscode = responseEntity.getStatusCode();
		System.out.println("status code - " + statuscode);

		Object user = responseEntity.getBody();
		System.out.println("resonse body - " + user);

		HttpHeaders responseHeaders = responseEntity.getHeaders();
		System.out.println("response Headers - " + responseHeaders);

	}*/
    
}
