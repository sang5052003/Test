package com.musicplay.rest.store;

import java.util.List;

import com.musicplay.rest.domain.User;

public interface UserStore {
	//
	boolean create(User user);
	User read(String id);
	List<User> readAll();
	boolean update(User user);
}
