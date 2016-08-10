/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.service;

import com.MusicApp.daos.MusicDAO;
import com.MusicApp.model.Music;
import com.MusicApp.model.Playlist;
import com.MusicApp.model.User;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anshul
 */
@Service
public class MusicService {
    
    @Autowired
    private MusicDAO musicDAO;

    public int createMusic(Music addMusic) {
        if(musicDAO.getByMusicTitle(addMusic.getTitle()) != null) {
            return -1;
        }
        musicDAO.saveOrUpdate(addMusic);
        return 0;
    }

    public void update(Music music) {
        musicDAO.saveOrUpdate(music);
    }
    
    public Music getByMusicTitle(String title) {
        return musicDAO.getByMusicTitle(title);
    }

    public List<Music> getMusicListByUserPlaylist(User user, Playlist playlist) {
        if(musicDAO.getByUserPlaylist(user.getId(),playlist.getMusicId()) != null){
            return musicDAO.getByUserPlaylist(user.getId(),playlist.getMusicId());
        }
        return new LinkedList<Music>();
    }

    public List<Music> getAllMusicList() {
        return musicDAO.getAllMusic();
    }

    public List<Music> searchByKeyword(String searchKeyword) {
        return musicDAO.searchMusicByKeyword(searchKeyword);
    }

    public Music getByMusicId(int musicId) {
        return musicDAO.get(musicId);
    }

    public List<Music> getAllMusicListByPage(int pageid, int total) {
        return musicDAO.getMusicListByPage(pageid,total);
    }

    public int countRows() {
        return musicDAO.getCountRows();
    }
}
