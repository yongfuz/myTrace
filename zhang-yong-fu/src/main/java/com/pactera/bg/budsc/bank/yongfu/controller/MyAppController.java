package com.pactera.bg.budsc.bank.yongfu.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.frw.way.commons.utils.ExceptionHandle;
import com.pactera.bg.budsc.bank.yongfu.po.Trace;
import com.pactera.bg.budsc.bank.yongfu.po.User;
import com.pactera.bg.budsc.bank.yongfu.serviceI.TraceServiceI;
import com.pactera.bg.budsc.bank.yongfu.serviceI.UserServiceI;

/**
 * @author 作者:lz
 * @createDate 创建时间：2018年10月31日 上午10:46:14
 */

@Controller
@RequestMapping(value = "/myApp")
public class MyAppController {

	Logger logger = LoggerFactory.getLogger(MyAppController.class);

	@Autowired
	private UserServiceI userService;

	@Autowired
	private TraceServiceI traceService;

	@RequestMapping(value = "/acquireReq")
	public void acquireReq(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("接收到手机端请求...");
		response.setContentType("application/text;charset=utf-8");
		PrintWriter write = null;
		write = response.getWriter();
		JSONObject jsonReturn1 = new JSONObject();
		jsonReturn1.put("statusApp", "222");
		write.write(jsonReturn1.toString());
	}

	// 保存每个人的路径信息
	@RequestMapping(value = "/insertTraceData")
	public void insertTraceData(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("接收到手机端保存路径的请求...");
		response.setContentType("application/text;charset=utf-8");
		BufferedReader reader = null;
		try {
			// 点信息数据入库
			String list = request.getParameter("list");
			List<Trace> parseArray = JSONObject.parseArray(list, Trace.class);
			System.out.println(parseArray.get(0).toString());
			int insert = traceService.insert(parseArray);

			reader = request.getReader();
			String line = "";
			StringBuilder sb = new StringBuilder();
			// 2.读取数据
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			String jsonRequest = sb.toString();
		} catch (Exception e) {
			logger.error(ExceptionHandle.extractMsg(e));
		}

		PrintWriter write = null;
		write = response.getWriter();
		JSONObject jsonReturn1 = new JSONObject();
		jsonReturn1.put("statusApp", "222");
		write.write(jsonReturn1.toString());
	}

	// 群id
	public List<User> getUsers(String id) {
		return null;
	}
}
