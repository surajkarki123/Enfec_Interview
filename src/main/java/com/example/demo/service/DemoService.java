package com.example.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.User;

@Service
public class DemoService {

	@Autowired
	private RestTemplate restTemplate;

	private static final String URL = "https://jsonplaceholder.typicode.com/users";

	public List<User> fetchUsers() {
		List<User> users = null;
		try {
			ResponseEntity<List<User>> response = restTemplate.exchange(URL, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<User>>() {
					});

			if (Objects.nonNull(response)) {
				users = response.getBody();
			}
		} catch (RestClientException e) {
			System.out.println("Exception Occured while fetching the data. Msg : " + e.getMessage());
		}
		return users;
	}
}
