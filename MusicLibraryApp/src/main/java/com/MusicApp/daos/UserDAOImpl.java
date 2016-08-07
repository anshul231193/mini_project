/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MusicApp.daos;

import com.MusicApp.Mapper.UserMapper;
import com.MusicApp.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
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
public class UserDAOImpl implements UserDAO{
    
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public UserDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
//    @Autowired
//    private JavaMailSenderImpl mailSender;
    
    //create or update user
    public void saveOrUpdate(User user) {
        
        if (user.getId() > 0) {
                // update
                String sql = "UPDATE public.user SET username=?, name=?, email=?, address=?, "
                            + "age=?, password=?,\"activationKey\"=? WHERE id=?";
                jdbcTemplate.update(sql, user.getUsername(), user.getName(), 
                        user.getEmail(), user.getAddress(), user.getAge(), 
                        user.getPassword(), user.getActivationKey(), user.getId());
                System.out.println(user.getPassword());
            } else {
                // insert
                String sql = "INSERT INTO public.\"user\"(\n" +
                "             username, password, email, name, age, address, \"activationKey\")\n" +
                "    VALUES ( ?, ?, ?, ?, ?, ?, ?);";
                jdbcTemplate.update(sql,user.getUsername(), user.getPassword(), user.getEmail(),
                        user.getName(), user.getAge(), user.getAddress(), user.getActivationKey());
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
    
    @Override
    public User getByUserName(String username) {
       String sql = "SELECT * FROM public.user WHERE username='" + username+"'";
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
                    user.setActivationKey(rs.getString("activationKey"));
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

    @Override
    public List<String> getUserRoles(String userName) {
        String sql = "Select role "//
                + " from public.user_roles where username = ? ";
         
        Object[] params = new Object[] { userName };
         
        List<String> roles = jdbcTemplate.queryForList(sql,params, String.class);
         
        return roles;
    }

    @Override
    public User findUserInfo(String username) {
        String sql = "Select username,password "//
                + " from public.user where username = ? ";
 
        Object[] params = new Object[] { username };
        UserMapper mapper = new UserMapper();
        try {
            User user = jdbcTemplate.queryForObject(sql, params, mapper);
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public User findByEmail(String email) {
        String sql = "SELECT * FROM public.user WHERE email='" + email+"'";
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

    @Override
    public User findByResetPasswordToken(String token) {
       String sql = "SELECT * FROM public.user WHERE resetPasswordToken='" + token+"'";
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

    @Override
    public User getByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendMail(User user) {
//        try {
//            MimeMessage mimeMessage = mailSender.createMimeMessage();
//            MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage);
//            mailMsg.setFrom("anshulgupta231193@gmail.com");
//            mailMsg.setTo(user.getEmail());
//            mailMsg.setSubject("Test mail");
//            mailMsg.setText("Hello World!");
//            mailSender.send(mimeMessage);
//            System.out.println("---Done---");
//        } catch (MessagingException ex) {
//            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @Override
    public User findByActivationKey(String activationKey) {
       String sql = "SELECT * FROM public.user WHERE \"activationKey\"='" + activationKey+"'";
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
    
    
}
