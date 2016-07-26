/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.model;

/**
 *
 * @author anshul
 */
public class Playlist {
    
    private int playistId;
    
    private int musicId;
    
    private int userId;
    
    private boolean archived;
    
    public int getPlayistId() {
        return playistId;
    }

    public void setPlayistId(int playistId) {
        this.playistId = playistId;
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}
