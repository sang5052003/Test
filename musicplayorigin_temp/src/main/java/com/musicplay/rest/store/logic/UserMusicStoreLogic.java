package com.musicplay.rest.store.logic;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.musicplay.rest.domain.Music;
import com.musicplay.rest.store.UserMusicStore;

@Repository
public class UserMusicStoreLogic implements UserMusicStore {

	@Override
	public boolean create(String userId, int musicId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String userId, int musicId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existUserMusic(String userId, int musicId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Music> readMusicsByUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
