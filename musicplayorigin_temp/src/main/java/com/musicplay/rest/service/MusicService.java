package com.musicplay.rest.service;

import java.util.List;

import com.musicplay.rest.domain.Music;

public interface MusicService {
	//
	Music find(int id);
	List<Music> findByName(String name);
	List<Music> findAll();
}
