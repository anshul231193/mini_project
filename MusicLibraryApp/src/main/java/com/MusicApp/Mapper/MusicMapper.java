/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.Mapper;

import com.MusicApp.model.Music;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * Mapper to collect music object from database
 */
public class MusicMapper implements RowMapper<Music>{

    //method to collect music object from database
    @Override
    public Music mapRow(ResultSet rs, int i) throws SQLException {
        int musicId = rs.getInt("music_id");
        String title = rs.getString("title");
        
        return new Music(musicId,title);
    }
    
}
