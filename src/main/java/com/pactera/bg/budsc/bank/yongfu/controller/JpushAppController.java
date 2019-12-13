package com.pactera.bg.budsc.bank.yongfu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.frw.way.commons.utils.ExceptionHandle;
import com.github.pagehelper.StringUtil;
import com.pactera.bg.budsc.bank.yongfu.config.RabbitConfig;
import com.pactera.bg.budsc.bank.yongfu.jdpush.JpushClientUtil;
import com.pactera.bg.budsc.bank.yongfu.po.JpushClient;
import com.pactera.bg.budsc.bank.yongfu.po.Point;
import com.pactera.bg.budsc.bank.yongfu.po.Register;
import com.pactera.bg.budsc.bank.yongfu.po.Trace;
import com.pactera.bg.budsc.bank.yongfu.po.User;
import com.pactera.bg.budsc.bank.yongfu.po.UserDistrictCodes;
import com.pactera.bg.budsc.bank.yongfu.po.UserRegistrationId;
import com.pactera.bg.budsc.bank.yongfu.rabbit.MsgProducer;
import com.pactera.bg.budsc.bank.yongfu.serviceI.RegisterServiceI;
import com.pactera.bg.budsc.bank.yongfu.serviceI.TraceServiceI;
import com.pactera.bg.budsc.bank.yongfu.serviceI.UserDistrictCodesServiceI;
import com.pactera.bg.budsc.bank.yongfu.serviceI.UserRegistrationIdServiceI;
import com.pactera.bg.budsc.bank.yongfu.serviceI.UserServiceI;
import com.pactera.bg.budsc.bank.yongfu.util.RegisterUtil;

/**
 * @author 作者:zyf
 * @createDate 创建时间：2019年12月5日 上午10:46:14
 * 用来保存极光推送所需的数据信息
 */

@Controller
@RequestMapping(value = "/jpushApp")
public class JpushAppController {
	Logger logger = LoggerFactory.getLogger(JpushAppController.class);

	@Autowired
	private UserServiceI userService;

	@Autowired
	private UserRegistrationIdServiceI userRegistrationIdService;

	/**
	 * 保存jpush的registration_id信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/insertRegistrationId")
	@ResponseBody
	public Map<String, Object> insertRegistrationId(HttpServletRequest request) {
		logger.info("接收到jpush的registration_id信息的请求...");
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = request.getParameter("userName");
		String registrationId = request.getParameter("registrationId");
		logger.info("----->保存jpush的registration_id信息userName：" + userName + ",registrationId:" + registrationId);
		// 入库之前先查询是否有数据，有则update没有则insert
		UserRegistrationId selectByPrimaryKey = userRegistrationIdService.selectByPrimaryKey(userName);
		UserRegistrationId userRegistrationId = new UserRegistrationId();
		userRegistrationId.setUserName(userName);
		userRegistrationId.setRegistrationId(registrationId);
		if (selectByPrimaryKey != null) {
			int update = userRegistrationIdService.update(userRegistrationId);
			if (update >= 1) {
				map.put("resultCode", "AAA000");
				map.put("resultMsg", "registrationId保存成功！");
			} else {
				map.put("resultCode", "AAA001");
				map.put("resultMsg", "registrationId保存失败！");
			}
		} else {
			int insert = userRegistrationIdService.insert(userRegistrationId);
			if (insert >= 1) {
				map.put("resultCode", "AAA000");
				map.put("resultMsg", "registrationId保存成功！");
			} else {
				map.put("resultCode", "AAA001");
				map.put("resultMsg", "registrationId保存失败！");
			}
		}
		return map;
	}
}
