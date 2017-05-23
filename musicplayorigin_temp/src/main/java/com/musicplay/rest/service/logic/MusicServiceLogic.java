package com.musicplay.rest.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicplay.rest.domain.Music;
import com.musicplay.rest.service.MusicService;
import com.musicplay.rest.store.MusicStore;

@Service
public class MusicServiceLogic implements MusicService {

	@Autowired
	private MusicStore store;
	
	@Override
	public Music find(int id) {
		return store.read(id);
	}

	@Override
	public List<Music> findByName(String name) {
		return store.readByName(name);
	}

	@Override
	public List<Music> findAll() {
		return store.readAll();
	}

}
