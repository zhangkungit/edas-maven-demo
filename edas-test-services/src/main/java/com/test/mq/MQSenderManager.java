package com.test.mq;

import com.test.component.rabbitmq.MQSender;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * MQ Direct
 *
 * @author dell
 **/


@Service
public class MQSenderManager extends MQSender {

	// 队列名称
	private static final String QUEUE_FRIEND_ADD = "friend.add"; // 添加好友
	private static final String QUEUE_FRIEND_MODIFY = "friend.modify"; // 修改好友备注

	private static final String QUEUE_REGISTRY = "user.registry"; // 注册
	private static final String QUEUE_MODIFY = "user.modify"; // 修改用户信息
	private static final String QUEUE_LOGINLOG = "user.loginlog"; // 登录
	private static final String QUEUE_SMS = "common.sms"; // 短信
	private static final String QUEUE_PUSH = "common.push"; // 消息推送
	// session名称
	private static final int APP_DIRECT_COMMON = 1; // 基础直连交换机
	private static final int APP_FANOUT_ = 2; // 扇形交换机

	@Autowired
	private RabbitTemplate directTemplate;

//	@Autowired
//	private RabbitTemplate commonTemplate;

//	 * 根据编号id， 获取连接实例


	@Override
	public RabbitTemplate checkTemplate(int app) {
		switch (app) {
		case APP_DIRECT_COMMON:
			return directTemplate;
//			return null;
		case APP_FANOUT_:
//			return commonTemplate;
			return null;
		default:
			return null;
		}
	}

	public void testEDAS(String data) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("message", data);

		this.send(APP_DIRECT_COMMON, "edas.test.queue", params);
	}

}
