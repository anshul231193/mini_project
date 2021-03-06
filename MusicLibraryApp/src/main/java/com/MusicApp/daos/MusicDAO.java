/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.daos;

import com.MusicApp.model.Music;
import java.util.List;

/**
 *
 * @author anshul
 */
public interface MusicDAO {
    
    public void saveOrUpdate(Music music);
     
    public void delete(int musicId);
     
    public Music get(int musicId);
        
    public List<Music> list();
    
    public Music findMusicInfo(String title);

    public Music getByMusicTitle(String title);

    public List<Music> getByUserPlaylist(int id, int musicId);

    public List<Music> getAllMusic();

    public List<Music> searchMusicByKeyword(String searchKeyword);

    public List<Music> getMusicListByPage(int pageid, int total);

    public int getCountRows();
        
}
