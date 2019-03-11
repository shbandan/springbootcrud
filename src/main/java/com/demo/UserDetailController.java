package com.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
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
	
	@DeleteMapping("/{id}")
	public List<Userdetail> deleteUser(@PathVariable("id") Long id){
		userdetailRepository.deleteById(id);
		return userdetailRepository.findAll();
		
	}
	
	@GetMapping("/config")
	public Map<String, String> getConfig() {
		return System.getenv();
	}
}
