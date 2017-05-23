package com.musicplay.rest.store;

import java.util.List;

import com.musicplay.rest.domain.Music;

public interface MusicStore {
	//
	Music read(int id);
	List<Music> readByName(String name);
	List<Music> readAll();
}
