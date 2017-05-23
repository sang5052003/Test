package com.musicplay.rest.store.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.musicplay.rest.domain.Music;
import com.musicplay.rest.domain.User;

public class MusicPlayRepository {
	//
	private static MusicPlayRepository instance;
	private Map<String, User> userRepo;
	private Map<Integer, Music> musicRepo;
	
	private MusicPlayRepository() {
		//
		this.userRepo = new HashMap<>();
		this.musicRepo = new HashMap<>();
		
		init();
	}
	
	private void init() {
		//
		userRepo.put("kim", new User("kim", "1234", "김길동"));
		userRepo.put("hong", new User("hong", "1234", "홍길동"));
		
		musicRepo.put(1, new Music(1, "You Are My Everything", "거미", "태양의 후예 OST", "album_1.JPG", "뮤직앤뉴"));
		musicRepo.put(2, new Music(2, "한숨", "이하이", "SOULITE", "album_5.JPG", "YG"));
		musicRepo.put(3, new Music(3, "벚꽃엔딩", "버스커버스커", "버스커 버스커", "album_10.JPG", "씨제이이엔엠"));
		musicRepo.put(4, new Music(4, "길", "김윤아", "시그널 OST Part 4", "album_13.JPG", "씨제이이엔엠"));
		musicRepo.put(5, new Music(5, "이럴거면 그러지 말지", "백아연", "이럴거면 그러지 말지", "album_20.JPG", "JYP 엔터테인먼트"));
	}
	
	public static MusicPlayRepository createInstance() {
		//
		if(instance == null) {
			instance = new MusicPlayRepository();
		}
		
		return instance;
	}
	
	public void createUser(User user) {
		//
		userRepo.put(user.getLoginId(), user);
	}
	
	public User readUser(String id) {
		//
		return userRepo.get(id);
	}
	
	public List<User> readAllUsers() {
		//
		return new ArrayList<>(userRepo.values());
	}
	
	public Music readMusic(int id) {
		//
		return musicRepo.get(id);
	}
	
	public List<Music> readAllMusics() {
		//
		return new ArrayList<>(musicRepo.values());
	}
	
	public List<Music> readMusicByName(String name) {
		//
		Collection<Music> musics = musicRepo.values();
		List<Music> foundMusics = new ArrayList<>();
		for(Music music : musics) {
			if(music.getName().contains(name)) {
				foundMusics.add(music);
			}
		}
		
		return foundMusics;
	}
	
	public boolean updateUser(User user) {
		//
		User origin = readUser(user.getLoginId());
		origin.setName(user.getName());
		origin.setPassword(user.getPassword());
		
		return true;
	}
}
