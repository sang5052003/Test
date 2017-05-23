package com.musicplay.rest.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicplay.rest.domain.User;
import com.musicplay.rest.service.UserService;
import com.musicplay.rest.store.UserStore;

@Service
public class UserServiceLogic implements UserService {

	@Autowired
	private UserStore store;

	@Override
	public User login(User user) {
		//
		User readedUser = null;
		if (validate(user)) {
			readedUser = store.read(user.getLoginId());
		}
		return readedUser;
	}

	@Override
	public boolean register(User user) {
		//
		if (!validate(user)) {
			return false;
		} else if (store.read(user.getLoginId()) != null) {
			return false;
		}
		return store.create(user);
	}

	@Override
	public User find(String loginId) {
		//
		return store.read(loginId);
	}
	
	@Override
	public List<User> findAll() {
		//
		return store.readAll();
	}

	private boolean validate(User user) {
		//
		if (user == null) {
			throw new RuntimeException("사용자 정보가 없습니다.");
		} else if (user.getLoginId() == null || user.getLoginId().isEmpty()) {
			throw new RuntimeException("ID가 없습니다.");
		} else if (user.getPassword() == null || user.getPassword().isEmpty()) {
			throw new RuntimeException("비밀번호가 없습니다.");
		}
		return true;
	}

	@Override
	public boolean modify(User user) {
		//
		return store.update(user);
	}

}
