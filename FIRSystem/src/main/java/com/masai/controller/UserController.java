package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.FIRException;
import com.masai.exception.UserException;
import com.masai.model.FIR;
import com.masai.model.User;
import com.masai.service.UserService;

@RequestMapping("/masaifir/user")
@RestController
public class UserController {
	
	@Autowired
	private UserService us;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user) throws UserException{
		return new ResponseEntity<User>(us.addUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/fir/{userid}")
	public ResponseEntity<List<FIR>> getAllFiledFIR(@PathVariable("userid")Integer userid) throws FIRException, UserException{
				
		List<FIR> list = us.getAllFIR(userid);		
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		 
	}
	
	@DeleteMapping("/fir/{firId}/{userid}")
	public ResponseEntity<FIR> deleteFIR(@PathVariable("firId")Integer firId,@PathVariable("userid")Integer userid) throws  UserException, FIRException{
	
		return new ResponseEntity<>(us.deleteFIR(firId, userid),HttpStatus.OK);
		
	}
	
}
