package com.pactera.bg.budsc.bank.yongfu.rabbit;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.pactera.bg.budsc.bank.yongfu.config.RabbitConfig;
import com.pactera.bg.budsc.bank.yongfu.po.Trace;
import com.pactera.bg.budsc.bank.yongfu.util.RedisUtil;

@Component
public class MsgReceiver {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private RedisUtil redisUtil;

	@RabbitListener(queues = RabbitConfig.QUEUE_A)
	public void process(String object) {
		logger.info("接收处理队列A当中的消息： " + object);
		Trace trace = JSON.parseObject(object, Trace.class);
		redisUtil.insertTrace(trace);
	}

}
