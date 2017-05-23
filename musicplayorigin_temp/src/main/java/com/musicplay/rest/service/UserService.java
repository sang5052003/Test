package com.musicplay.rest.service;

import java.util.List;

import com.musicplay.rest.domain.User;

public interface UserService {
	//
	User login(User user);
	boolean register(User user);
	User find(String loginId);
	List<User> findAll();
	boolean modify(User user);
}
