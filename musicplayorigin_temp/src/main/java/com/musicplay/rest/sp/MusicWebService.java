package com.musicplay.rest.sp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.musicplay.rest.domain.Music;
import com.musicplay.rest.service.MusicService;

@RestController
public class MusicWebService {
	
	@Autowired
	private MusicService musicService;
	
	@RequestMapping(value="/musics", method=RequestMethod.GET)
	public List<Music> findAllMusics(){
		return musicService.findAll();
	}
	
	@RequestMapping(value="/musics/id/{id}", method=RequestMethod.GET)
	public Music findMusic(@PathVariable String id){
		return musicService.find(Integer.parseInt(id));
	}
	
	@RequestMapping(value="/musics/name/{name}", method=RequestMethod.GET)
	public List<Music> findAMusicsByName(@PathVariable String name){
		return musicService.findByName(name);
	}
}
