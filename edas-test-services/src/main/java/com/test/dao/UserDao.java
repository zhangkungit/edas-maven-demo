package com.test.dao;

import com.test.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

	public User selectUserById(Integer userId);

}
