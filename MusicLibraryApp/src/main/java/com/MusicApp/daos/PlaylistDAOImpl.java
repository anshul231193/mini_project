/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.daos;

import com.MusicApp.model.Playlist;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anshul
 */
@Repository
public class PlaylistDAOImpl implements PlaylistDAO{

    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public PlaylistDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public void saveOrUpdate(Playlist playlist) {
        if (playlist.getPlayistId()> 0) {
                // update
//                String sql = "UPDATE user SET username=?, name=?, email=?, address=?, "
//                            + "age=?, password=? WHERE contact_id=?";
//                jdbcTemplate.update(sql, user.getUsername(), user.getName(), 
//                        user.getEmail(), user.getAddress(), user.getAge(), 
//                        user.getPassword(), user.getId());
            } else {
                // insert
                String sql = "INSERT INTO public.\"playlist\"(\n" +
                "             music_id, user_id, archived)\n" +
                "    VALUES ( ?, ?, ?);";
                jdbcTemplate.update(sql,playlist.getMusicId(),playlist.getUserId(),
                        playlist.isArchived());
            }
    }
    
}
