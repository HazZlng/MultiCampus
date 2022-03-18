package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.entity.User;

@Repository
public class UserDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean insertUser(User user) {
		int result = jdbcTemplate.update("insert into user1 values(?, ?, ?)",
				new Object[] { user.getName(), user.getAge(), user.getHobby()});
		
		return (result > 0) ? true : false;
	}
	
	public List<User> listUser(){
		List<User> result = jdbcTemplate.query("select * from user1", 
				new RowMapper<User>() {

					@Override
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						User u = new User();
						u.setName(rs.getString("NAME"));
						u.setAge(rs.getInt("AGE"));
						u.setHobby(rs.getString("HOBBY"));
						
						return u;
					}	//maprow
		});	//query
		return result;
	}	//method
}	//class
