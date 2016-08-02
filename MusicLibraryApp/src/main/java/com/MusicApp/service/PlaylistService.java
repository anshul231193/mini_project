/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.service;

import com.MusicApp.daos.PlaylistDAO;
import com.MusicApp.model.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anshul
 */
@Service
public class PlaylistService {
    
    @Autowired
    private PlaylistDAO playlistDAO;

    public void createPlaylist(Playlist playlist) {
        playlistDAO.saveOrUpdate(playlist);
    }

    public Playlist getByUserId(int userId) {
        return playlistDAO.findPlaylistInfo(userId);
    }

    public Playlist findByMusicUserId(int musicId, int userId) {
        return playlistDAO.findPlaylistByMusicUserId(musicId,userId);
    }

    public void deleteSong(Playlist playlist) {
        playlistDAO.saveOrUpdate(playlist);
    }
    
}
