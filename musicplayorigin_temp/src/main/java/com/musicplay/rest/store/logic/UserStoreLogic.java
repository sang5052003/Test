package com.musicplay.rest.store.logic;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.musicplay.rest.domain.User;
import com.musicplay.rest.store.UserStore;
import com.musicplay.rest.store.repository.MusicPlayRepository;

@Repository
public class UserStoreLogic implements UserStore {
	//
	private MusicPlayRepository repository;
	
	public UserStoreLogic() {
		//
		repository = MusicPlayRepository.createInstance();
	}
	
	@Override
	public boolean create(User user) {
		//
		repository.createUser(user);
		return true;
	}

	@Override
	public User read(String id) {
		//
		return repository.readUser(id);
	}

	@Override
	public List<User> readAll() {
		//
		return repository.readAllUsers();
	}

	@Override
	public boolean update(User user) {
		//
		return repository.updateUser(user);
	}

}
