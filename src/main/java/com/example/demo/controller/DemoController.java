package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.DemoService;

@RestController
@RequestMapping("/test")
public class DemoController {

	@Autowired
	private DemoService demoService;

	@GetMapping
	public List<User> test() {
		return demoService.fetchUsers();
	}
	
	

}
