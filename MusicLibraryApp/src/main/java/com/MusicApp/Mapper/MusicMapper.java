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
 * @author anshul
 */
public class MusicMapper implements RowMapper<Music>{

    @Override
    public Music mapRow(ResultSet rs, int i) throws SQLException {
        int musicId = rs.getInt("music_id");
        String title = rs.getString("title");
        
        return new Music(musicId,title);
    }
    
}
