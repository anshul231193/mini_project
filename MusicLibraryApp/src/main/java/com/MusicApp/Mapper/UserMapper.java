/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.Mapper;

import com.MusicApp.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * User Mapper to collect row from user table
 */
public class UserMapper implements RowMapper<User>{

    //method to collect user from user table
    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        String userName = rs.getString("username");
        String password = rs.getString("password");
 
        return new User(userName, password);
    }
    
}
