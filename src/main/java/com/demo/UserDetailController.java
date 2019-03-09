package com.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userdetail")
public class UserDetailController {

	@Autowired
	UserdetailRepository userdetailRepository;
	
	@PostMapping()
	public Userdetail createUser(@RequestBody Userdetail userdetail) {
		return userdetailRepository.save(userdetail);
	}
	
	@GetMapping()
	public List<Userdetail> getAllUser(){
		return userdetailRepository.findAll();
	}
	
	@GetMapping("/test")
	public String test(){
		return "Hello World";
	}	
	
}
