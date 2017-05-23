package com.musicplay.rest.sp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.musicplay.rest.domain.User;
import com.musicplay.rest.service.UserService;

//리턴할 때 알아서 제이스으로 만들어서 보내줌
@RestController
public class UserWebService {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<User> findALlUsers(){
		return userService.findAll();
	}
	
	
	
	@RequestMapping(value="/users/login", method=RequestMethod.POST)
	public User loginUser(@RequestBody User user){
		User resultUser = userService.login(user);
		return resultUser;
	}

}
