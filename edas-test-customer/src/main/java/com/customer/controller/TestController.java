package com.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.api.DemoApi;
import com.test.entity.User;

@Controller
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private DemoApi demoApi;
	
    @RequestMapping(value="/test")   
    @ResponseBody  
    private String test(){
        logger.info("test request");
    	return demoApi.getService(); 
    } 
    
    @RequestMapping(value="/single/{userId}")   
    @ResponseBody  
    private User single(@PathVariable("userId") Integer userId){
        logger.info("single request userId:{}", userId);
        User user = demoApi.selectUserById(userId);
        logger.info("selectUserById result:{}", user);
        return user;
    } 
}
