package com.test.mq;

import com.test.component.rabbitmq.AbsMQlistener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * MQ消费者： 创建用户
 * @author Pxie
 * 
 * @problem 上传Qr，注册IM的失败处理
 */
public class MQUserCreateListener extends AbsMQlistener {
	
	private static Logger logger = LoggerFactory.getLogger(MQUserCreateListener.class);

	
	@Override
	public void handleAsynMessage(Map<String, String> data) {
		logger.info("*****************data************:{}", data);
	}
	

	
}
