/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.service;

import com.MusicApp.daos.MusicDAO;
import com.MusicApp.model.Music;
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
}
