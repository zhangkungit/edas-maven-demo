package com.test.api;

import com.test.entity.User;

/**
 * Created by Administrator on 2017/7/24 0024.
 */
public interface DemoApi {
	
    String getService();
    
    User selectUserById(Integer userId);
}
