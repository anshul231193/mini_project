/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.daos;

import com.MusicApp.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author anshul
 */
public class UserDAOImpl implements UserDAO{
    
    private JdbcTemplate jdbcTemplate;
 
    public UserDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public void saveOrUpdate(User user) {
        
        if (user.getId() > 0) {
                // update
                String sql = "UPDATE user SET username=?, name=?, email=?, address=?, "
                            + "age=?, password=? WHERE contact_id=?";
                jdbcTemplate.update(sql, user.getUsername(), user.getName(), 
                        user.getEmail(), user.getAddress(), user.getAge(), 
                        user.getPassword(), user.getId());
            } else {
                // insert
                String sql = "INSERT INTO contact (username, name, email, address, age, password)"
                            + " VALUES (?, ?, ?, ?)";
                jdbcTemplate.update(sql,user.getUsername(), user.getName(), user.getEmail(),
                        user.getAddress(), user.getAge(), user.getPassword());
            }
    }

    public void delete(int userId) {
        
        String sql = "DELETE FROM user WHERE id=?";
        jdbcTemplate.update(sql, userId);
    }

    public User get(int userId) {
        String sql = "SELECT * FROM user WHERE id=" + userId;
       return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {
            @Override
            public User extractData(ResultSet rs) throws 
                                    SQLException, DataAccessException {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    user.setAddress(rs.getString("address"));
                    user.setAge(rs.getInt("age"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    return user;
                 }

                return null;
            }
           
       });
 
    }

    public List<User> list() {
        String sql = "SELECT * FROM user";
        List<User> listUser = jdbcTemplate.query(sql, new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();

                 user.setId(rs.getInt("id"));
                 user.setName(rs.getString("name"));
                 user.setEmail(rs.getString("email"));
                 user.setAddress(rs.getString("address"));
                 user.setAge(rs.getInt("age"));
                 user.setUsername(rs.getString("username"));
                 user.setPassword(rs.getString("password"));
                 return user;
            }

        });

        return listUser;
    }
    
    
}
