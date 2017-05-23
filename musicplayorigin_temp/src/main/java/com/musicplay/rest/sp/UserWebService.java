package com.musicplay.rest.sp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.musicplay.rest.domain.User;
import com.musicplay.rest.service.UserService;

//@Controller가 아님
//<bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter" />
//등록된 bean파일을 체크해서..알아서 json으로 만들어서 리턴
@RestController
public class UserWebService {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<User> findAllUsers(){
		return userService.findAll();
	}
	
	//@RequestBody User user -> request바디(form태그 바디..)에  User user가 있다
	@RequestMapping(value="/users/login", method=RequestMethod.POST)
	public User loginUser(@RequestBody User user){
		System.out.println("loginCheck");
		System.out.println(user.getLoginId());
		System.out.println(user.getPassword());
		System.out.println(user.getName());
		User resultUser = userService.login(user);
		return resultUser;
	}
}
