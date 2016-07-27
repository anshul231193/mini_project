/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.daos;

import com.MusicApp.model.Music;
import com.MusicApp.model.Playlist;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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

    @Override
    public Playlist findPlaylistInfo(int userId) {
        String sql = "SELECT * FROM public.playlist WHERE user_id=" + userId;
       return jdbcTemplate.query(sql, new ResultSetExtractor<Playlist>() {
            @Override
            public Playlist extractData(ResultSet rs) throws 
                                    SQLException, DataAccessException {
                if (rs.next()) {
                    Playlist playlist = new Playlist();
                    playlist.setPlayistId(rs.getInt("playlist_id"));
                    playlist.setMusicId(rs.getInt("music_id"));
                    playlist.setUserId(rs.getInt("user_id"));
                    playlist.setArchived(rs.getBoolean("archived"));
                    return playlist;
                 }

                return null;
            }
           
       });
    }
    
}
