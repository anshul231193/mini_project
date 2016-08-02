/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.daos;

import com.MusicApp.Mapper.MusicMapper;
import com.MusicApp.Mapper.UserMapper;
import com.MusicApp.model.Music;
import com.MusicApp.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anshul
 */
@Repository
public class MusicDAOImpl implements MusicDAO{

    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public MusicDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public void saveOrUpdate(Music music) {
        if (music.getMusicId()> 0) {
                // update
//                String sql = "UPDATE user SET username=?, name=?, email=?, address=?, "
//                            + "age=?, password=? WHERE contact_id=?";
//                jdbcTemplate.update(sql, user.getUsername(), user.getName(), 
//                        user.getEmail(), user.getAddress(), user.getAge(), 
//                        user.getPassword(), user.getId());
            } else {
                // insert
                String sql = "INSERT INTO public.\"music\"(\n" +
                "             genre, title, description, lyrics, artist_name, album_name,file_path)\n" +
                "    VALUES ( ?, ?, ?, ?, ?, ?, ?);";
                jdbcTemplate.update(sql,music.getMusicGenre(), music.getTitle(), 
                        music.getDescription(), music.getLyrics(), music.getArtistName(), 
                        music.getAlbumName(),music.getFilePath());
            }
    }

    @Override
    public void delete(int musicId) {
        String sql = "DELETE FROM music WHERE music_id=?";
        jdbcTemplate.update(sql, musicId);
    }

    @Override
    public Music get(int musicId) {
       String sql = "SELECT * FROM music WHERE id=" + musicId;
       return jdbcTemplate.query(sql, new ResultSetExtractor<Music>() {
            @Override
            public Music extractData(ResultSet rs) throws 
                                    SQLException, DataAccessException {
                if (rs.next()) {
                    Music music = new Music();
                    music.setMusicId(rs.getInt("music_id"));
                    music.setMusicGenre(rs.getString("genre"));
                    music.setTitle(rs.getString("title"));
                    music.setDescription(rs.getString("description"));
                    music.setLyrics(rs.getString("lyrics"));
                    music.setArtistName(rs.getString("artist_name"));
                    music.setAlbumName(rs.getString("album_name"));
                    music.setFilePath(rs.getString("file_path"));
                    return music;
                 }

                return null;
            }
           
       });

    }

    @Override
    public List<Music> list() {
        String sql = "SELECT * FROM music";
        List<Music> listMusic = jdbcTemplate.query(sql, new RowMapper<Music>() {
        @Override
        public Music mapRow(ResultSet rs, int rowNum) throws SQLException {
                Music music = new Music();
                music.setMusicId(rs.getInt("music_id"));
                music.setMusicGenre(rs.getString("genre"));
                music.setTitle(rs.getString("title"));
                music.setDescription(rs.getString("description"));
                music.setLyrics(rs.getString("lyrics"));
                music.setArtistName(rs.getString("artist_name"));
                music.setAlbumName(rs.getString("album_name"));
                music.setFilePath(rs.getString("file_path"));
                return music;
            }

        });

        return listMusic;
    }

    @Override
    public Music findMusicInfo(String title) {
        String sql = "Select username,password "//
                + " from public.music where title = ? ";
 
        Object[] params = new Object[] { title };
        MusicMapper mapper = new MusicMapper();
        try {
            Music music = jdbcTemplate.queryForObject(sql, params, mapper);
            return music;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Music getByMusicTitle(String title) {
       String sql = "SELECT * FROM public.music WHERE title='" + title+"'";
       return jdbcTemplate.query(sql, new ResultSetExtractor<Music>() {
            @Override
            public Music extractData(ResultSet rs) throws 
                                    SQLException, DataAccessException {
                if (rs.next()) {
                    Music music = new Music();
                    music.setMusicId(rs.getInt("music_id"));
                    music.setMusicGenre(rs.getString("genre"));
                    music.setTitle(rs.getString("title"));
                    music.setDescription(rs.getString("description"));
                    music.setLyrics(rs.getString("lyrics"));
                    music.setArtistName(rs.getString("artist_name"));
                    music.setAlbumName(rs.getString("album_name"));
                    music.setFilePath(rs.getString("file_path"));
                    return music;
                 }

                return null;
            }
           
       });
    }

    @Override
    public List<Music> getByUserPlaylist(int id, int musicId) {
        String sql = "SELECT playlist.archived,music.music_id,music.genre,music.title,music.description,music.lyrics,music.artist_name,music.album_name,music.file_path FROM public.user \n" +
                    "INNER JOIN public.playlist ON public.user.id=playlist.user_id \n" +
                    "INNER JOIN public.music ON music.music_id=playlist.music_id\n" +
                    "WHERE public.user.id="+id;
        List<Music> listMusic = jdbcTemplate.query(sql, new RowMapper<Music>() {
        @Override
        public Music mapRow(ResultSet rs, int rowNum) throws SQLException {
                Music music = new Music();
                music.setArchived(rs.getBoolean("archived"));
                music.setMusicId(rs.getInt("music_id"));
                music.setMusicGenre(rs.getString("genre"));
                music.setTitle(rs.getString("title"));
                music.setDescription(rs.getString("description"));
                music.setLyrics(rs.getString("lyrics"));
                music.setArtistName(rs.getString("artist_name"));
                music.setAlbumName(rs.getString("album_name"));
                music.setFilePath(rs.getString("file_path"));
                return music;
            }

        });

        return listMusic;
    }

    @Override
    public List<Music> getAllMusic() {
        String sql = "SELECT * FROM public.music";
        List<Music> listMusic = jdbcTemplate.query(sql, new RowMapper<Music>() {
        @Override
        public Music mapRow(ResultSet rs, int rowNum) throws SQLException {
                Music music = new Music();
//                music.setArchived(rs.getBoolean("archived"));
                music.setMusicId(rs.getInt("music_id"));
                music.setMusicGenre(rs.getString("genre"));
                music.setTitle(rs.getString("title"));
                music.setDescription(rs.getString("description"));
                music.setLyrics(rs.getString("lyrics"));
                music.setArtistName(rs.getString("artist_name"));
                music.setAlbumName(rs.getString("album_name"));
                music.setFilePath(rs.getString("file_path"));
                return music;
            }

        });

        return listMusic;
    }

    @Override
    public List<Music> searchMusicByKeyword(String searchKeyword) {
        String sql = "SELECT * FROM public.music WHERE LOWER(title) LIKE '%"+searchKeyword+"%' OR LOWER(artist_name) LIKE '%"+searchKeyword+"%'";
        List<Music> listMusic = jdbcTemplate.query(sql, new RowMapper<Music>() {
        @Override
        public Music mapRow(ResultSet rs, int rowNum) throws SQLException {
                Music music = new Music();
                music.setMusicId(rs.getInt("music_id"));
                music.setMusicGenre(rs.getString("genre"));
                music.setTitle(rs.getString("title"));
                music.setDescription(rs.getString("description"));
                music.setLyrics(rs.getString("lyrics"));
                music.setArtistName(rs.getString("artist_name"));
                music.setAlbumName(rs.getString("album_name"));
                music.setFilePath(rs.getString("file_path"));
                return music;
            }

        });

        return listMusic;
    }
    
}
