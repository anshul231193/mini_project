/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.daos;

import com.MusicApp.model.UserRole;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anshul
 */
@Repository
public class UserRolesDAOImpl implements UserRolesDAO {

    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public UserRolesDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public void saveOrUpdate(UserRole userRole) {
        if (userRole.getId() > 0) {
                // update
                String sql = "UPDATE user_roles SET username=?, role=?";
                jdbcTemplate.update(sql, userRole.getUsername(), userRole.getRoles());
            } else {
                // insert
                String sql = "INSERT INTO public.\"user_roles\"(\n" +
                "             username, role)\n" +
                "    VALUES ( ?, ?);";
                jdbcTemplate.update(sql,userRole.getUsername(), userRole.getRoles());
            }
    }

    @Override
    public void delete(int user_role_Id) {
        String sql = "DELETE FROM user_roles WHERE user_roles_id=?";
        jdbcTemplate.update(sql, user_role_Id);
    }

    @Override
    public UserRole get(int userRoleId) {
        String sql = "SELECT * FROM public.user_role WHERE user_roles_id=" + userRoleId;
       return jdbcTemplate.query(sql, new ResultSetExtractor<UserRole>() {
            @Override
            public UserRole extractData(ResultSet rs) throws 
                                    SQLException, DataAccessException {
                if (rs.next()) {
                    UserRole userRole = new UserRole();
                    userRole.setId(rs.getInt("user_roles_id"));
                    userRole.setUsername(rs.getString("username"));
                    userRole.setRoles(rs.getString("role"));
                    return userRole;
                 }

                return null;
            }
           
       });
    }

    @Override
    public List<UserRole> list() {
        String sql = "SELECT * FROM user_role";
        List<UserRole> listUser = jdbcTemplate.query(sql, new RowMapper<UserRole>() {
        @Override
        public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserRole userRole = new UserRole();

                 userRole.setId(rs.getInt("user_roles_id"));
                 userRole.setUsername(rs.getString("username"));
                 userRole.setRoles(rs.getString("role"));
                 return userRole;
            }

        });

        return listUser;
    }
    
}
