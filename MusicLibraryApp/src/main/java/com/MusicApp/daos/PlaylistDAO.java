/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.daos;

import com.MusicApp.model.Music;
import com.MusicApp.model.Playlist;

/**
 *
 * @author anshul
 */
public interface PlaylistDAO {
    
    public void saveOrUpdate(Playlist playlist);
    
    public Playlist findPlaylistInfo(int userId);
}
