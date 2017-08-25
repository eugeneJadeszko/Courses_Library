package by.intexsoft.sjt.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.sjt.entity.UserEntity;
import by.intexsoft.sjt.service.UserService;
import ch.qos.logback.classic.Logger;

/**
 * Controller for {@link UserEntity}
 */
@RestController
@RequestMapping("/user")
public class UserController {
	private static Logger logger = (Logger) LoggerFactory.getLogger(UserController.class.getName());

	@Autowired
	UserService service;

	@RequestMapping("/add/{first_name}")
	public ResponseEntity<?> addUser(@PathVariable("first_name") String first_name) {
		logger.info("Creation of a new user with the first name: " + first_name);
		UserEntity user = new UserEntity();
		user.name = first_name;
		try {
			return new ResponseEntity<UserEntity>(service.save(user), HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Error while saving new user with first name: " + first_name);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This method getting all users
	 * 
	 * @return ResponseEntity<List<UserEntity>>
	 */
	@RequestMapping("/all")
	public ResponseEntity<?> findAll() {
		logger.info("Getting all users");
		return new ResponseEntity<List<UserEntity>>(service.findAll(), HttpStatus.OK);
	}
}
