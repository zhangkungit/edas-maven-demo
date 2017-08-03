package com.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.api.DemoApi;
import com.test.dao.UserDao;
import com.test.entity.User;


@Service
public  class DemoProvider implements DemoApi {
	private static final Logger logger = LoggerFactory.getLogger(DemoProvider.class);

	@Autowired
	private UserDao userDao;

	public User selectUserById(Integer userId) {
		logger.info("selectUserById, userId:{}", userId);
		try {
//			return userDao.selectUserById(userId);
		} catch (Exception e) {
			logger.error("selectUserById error", e);
		}
		return userDao.selectUserById(userId);
	}
	
    public String getService() {
		logger.info("getService, getService");
        return "hello,tiger.wang";
    }
}
