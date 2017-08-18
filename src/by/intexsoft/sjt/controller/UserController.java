package by.intexsoft.sjt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.sjt.entity.UserEntity;
import by.intexsoft.sjt.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;

	@RequestMapping("/add/{first_name}")
	public ResponseEntity<?> addUser(@PathVariable("first_name") String first_name) {
		UserEntity user = new UserEntity();
		user.name = first_name;
		return new ResponseEntity<UserEntity>(service.save(user), HttpStatus.OK);
	}

	@RequestMapping("/all")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<List<UserEntity>>(service.findAll(), HttpStatus.OK);
	}
}
