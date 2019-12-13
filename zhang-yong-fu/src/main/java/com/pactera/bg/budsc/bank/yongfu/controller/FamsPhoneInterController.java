package com.pactera.bg.budsc.bank.yongfu.controller;

import org.springframework.stereotype.Controller;

/**
 * @author 作者:lz
 * @createDate 创建时间：2018年10月31日 上午10:46:14
 */

@Controller
public class FamsPhoneInterController {

	/*Logger logger = LoggerFactory.getLogger(FamsPhoneInterController.class);

	@Autowired
	AcquireBranchByUser acquireBranchByUser;

	@Autowired
	private FamsLdapUserServiceI famsLdapUserService;

	@Autowired
	private LogQueryServiceI logServiceI;

	@Autowired
	private FamsPdPlanServiceI famsPdPlanService;

	@Autowired
	private FamsYpsummarConditionServiceI ypsummarConditionService;

	@RequestMapping(value = "/famsApp/acquireReq")
	public void acquireReq(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("接收到手机端请求...");
		response.setContentType("application/text;charset=utf-8");
		String jsonReturn = "";
		PrintWriter write = null;
		BufferedReader reader = null;
		try {
			// 1.获取BufferedReader
			reader = request.getReader();
			String line = "";
			StringBuilder sb = new StringBuilder();
			// 2.读取数据
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			String jsonRequest = sb.toString();
			// 3.格式化读取到的数据
			JSONObject json = JSONObject.parseObject(jsonRequest);
			String tranCode = json.getString("tranCode");// 交易码
			String serialNum = json.getString("serialNum");// 流水号
			String tranTime = json.getString("tranTime");// 交易时间

			logger.info("客户请求:tranCode=" + tranCode + "...tranTime=" + tranTime
					+ "...serialNum=" + serialNum);
			write = response.getWriter();
			// 4.不同的交易码执行对应的方法
			switch (Integer.parseInt(tranCode)) {
			// 登录接口
			case 100001:
				jsonReturn = appLogin(request, response, json);
				break;
			case 100002:
				jsonReturn = appPdPlan(request, response, json); // 盘点计划查询
				break;
			case 100003:
				jsonReturn = pdPlanDetail(request, response, json);// 押品组信息详情查询
				break;
			case 100004:
				jsonReturn = scanQRcode(request, response, json);// 扫描二维码获取押品组信息
				break;
			case 100006:
				jsonReturn = pdCollateralGroup(request, response, json);// 盘点押品组接口(不需要拍照盘点计划)
				break;
			default:
				break;
			}
			write.write(jsonReturn);
		} catch (Exception e) {
			logger.error("手机端访问失败::" + e.getMessage(), e);
		} finally {
			IOUtil.closeQuietly(write);
			IOUtil.closeQuietly(reader);
		}
	}

	*//**
	 * 实现登录
	 * 
	 * @param request
	 * @param response
	 * @param json
	 * @return
	 *//*
	public String appLogin(HttpServletRequest request,
			HttpServletResponse response, JSONObject json) {
		logger.info("===========手机端登录开始===========");
		JSONObject jsonReturn = new JSONObject();
		String userId = "";
		String password = "";
		try {
			userId = json.getString("userId");
			password = json.getString("password");
			SM4Utils sm4 = new SM4Utils();
			sm4.secretKey = "JeF8U9wHFOMfs2Y8";
			sm4.hexString = false;
			password = sm4.decryptData_ECB(password);
			boolean validateLdapUserFlag = LdapHelper.validateLdapUser(userId,
					password);
			if (validateLdapUserFlag) {
				LdapUser user = famsLdapUserService.selectByPrimaryKey(userId);
				acquireBranchByUser.getBranchByUser(user);
				Map<String, Object> mapRe = new HashMap<String, Object>();
				mapRe = new HashMap<String, Object>();
				mapRe.put("userId", user.getUserId());
				mapRe.put("orgId", user.getCmsOcode());
				mapRe.put("userName", user.getUserName());
				jsonReturn.put("statusApp", "S00200");
				jsonReturn.put("msg", "登录成功");
				jsonReturn.put("body", JSONObject.toJSON(mapRe));
			} else {
				jsonReturn.put("statusApp", "S00201");
				jsonReturn.put("msg", "登录失败,用户名或密码错误！");
			}
			logger.info(jsonReturn.toString());
		} catch (Exception e) {
			logger.error("手机端登录异常::" + e.getMessage(), e);
			jsonReturn.put("statusApp", "E99500");
			String msg = "登录异常,请稍后再试!";
			jsonReturn.put("msg", msg);
		}
		return jsonReturn.toString();
	}

	*//**
	 * 手机端查看盘点计划
	 *//*
	public String appPdPlan(HttpServletRequest request,
			HttpServletResponse response, JSONObject json) {
		logger.info("===========手机端查询盘点计划开始===========");
		JSONObject jsonReturn = new JSONObject();
		String userId = json.getString("userId");
		if (StringUtils.isNotEmpty(userId)) {
			try {
				logger.info("请求的用户是:userId=" + userId);
				FamsPdPlan pdPlan = new FamsPdPlan();
				pdPlan.setUserIds(userId);
				List<FamsPdPlan> list = famsPdPlanService
						.selectPdPlanListApp(pdPlan);
				// 如果为空？
				List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
				if (list.size() > 0) {
					Map<String, Object> mapRe = new HashMap<String, Object>();
					for (int i = 0; i < list.size(); i++) {
						mapRe = new HashMap<String, Object>();
						mapRe.put("code", list.get(i).getCode() == null ? ""
								: list.get(i).getCode());
						mapRe.put("planName", list.get(i).getPlanName());
						mapRe.put("planType", list.get(i).getPlanType());
						mapRe.put("beginDate", list.get(i).getBeginDate());
						mapRe.put("endDate", list.get(i).getEndDate());
						mapRe.put("pdState",
								list.get(i).getPdState().equals("2") ? "A" // A代表是盘点中
																			// B代表已完成
										: "B");
						returnList.add(mapRe);
					}
				}
				jsonReturn.put("body", JSONObject.toJSON(returnList));
				jsonReturn.put("statusApp", "S00200");
				jsonReturn.put("msg", "查询成功");
			} catch (Exception e) {
				logger.error("手机端查询盘点计划异常::" + e.getMessage(), e);
				jsonReturn.put("statusApp", "E99500");
				String msg = "查询盘点计划失败!";
				jsonReturn.put("msg", msg);
			}
		} else {
			jsonReturn.put("statusApp", "E99400");
			String msg = "用户为空,请重新登录!";
			jsonReturn.put("msg", msg);
		}
		return jsonReturn.toString();
	}

	*//**
	 * 盘点计划押品组信息详情
	 *//*
	public String pdPlanDetail(HttpServletRequest request,
			HttpServletResponse response, JSONObject json) {
		logger.info("===========手机端查询盘点计划押品信息开始===========");
		JSONObject jsonReturn = new JSONObject();
		String code = "";
		String pdStates = "";
		try {
			code = json.getString("code");
			pdStates = json.getString("pdStates");
			int page = Integer.parseInt(json.getString("page"));
			logger.info("请求的盘点计划的盘点单号是:code=" + code + "...盘点状态:" + pdStates);
			FamsYpsummarCondition ypsummarCondition = new FamsYpsummarCondition();
			ypsummarCondition.setCode(code);
			ypsummarCondition.setPdStates(pdStates);
			PageInfo<FamsYpsummarCondition> pInfo = new PageInfo<FamsYpsummarCondition>();
			pInfo.setPageNum(page);
			pInfo.setPageSize(100);
			PageData<FamsYpsummarCondition> pageData = ypsummarConditionService
					.appSelectAll(pInfo, ypsummarCondition);
			long totalNum = pageData.getTotal();
			List<FamsYpsummarCondition> list = pageData.getRows();
			jsonReturn.put("statusApp", "S00200");
			jsonReturn.put("msg", "查询押品组信息成功");
			jsonReturn.put("totalNum", totalNum);
			jsonReturn.put("body", list);
			logger.info("===========查询盘点计划押品组信息详情成功===========");
		} catch (Exception e) {
			logger.error("盘点计划押品组信息详情::" + e.getMessage(), e);
			jsonReturn.put("statusApp", "E99500");
			jsonReturn.put("msg", "手机端查询盘点押品组出错,请联系 管理员!");
		}
		logger.info("===========盘点计划押品组信息详情===========");
		return jsonReturn.toString();
	}

	*//**
	 * 扫描二维码接口
	 * 
	 * @param request
	 * @param response
	 * @param json
	 * @return
	 *//*
	public String scanQRcode(HttpServletRequest request,
			HttpServletResponse response, JSONObject json) {
		logger.info("调用扫描二维码接口开始!");
		JSONObject jsonReturn = new JSONObject();
		try {
			String labelId = json.getString("labelId");// 标签号
			String code = json.getString("code");// 盘点计划code
			FamsYpsummarCondition ypsummarCondition = new FamsYpsummarCondition();
			ypsummarCondition.setLabelId(labelId);
			ypsummarCondition.setCode(code);
			FamsYpsummarConditionApp yc = ypsummarConditionService
					.selectYpsummarConditionByCodeAndLabelId(ypsummarCondition);
			if (yc == null) {
				jsonReturn.put("statusApp", "S00201");
				jsonReturn.put("msg", "该押品组不属于该盘点计划!");
			} else if (yc != null && !("1".equals(yc.getPdStates()))) {
				jsonReturn.put("statusApp", "S00202");
				jsonReturn.put("msg", "该押品组已经盘点过了,不需要再盘点!");
			} else {
				jsonReturn.put("statusApp", "S00200");
				jsonReturn.put("msg", "扫描二维码获取押品组信息成功");
			}
			jsonReturn.put("body", yc);
			logger.info("扫描二维码获取押品组信息成功,返回信息:" + jsonReturn);
		} catch (Exception e) {
			jsonReturn.put("statusApp", "E99500");
			jsonReturn.put("msg", "扫描二维码获取押品组信息失败");
			logger.error("扫描二维码获取押品组信息出现异常::" + e.getMessage(), e);
		}
		return jsonReturn.toString();
	}

	*//**
	 * 盘点押品组接口(不需要拍照盘点计划)
	 * 
	 * @param request
	 * @param response
	 * @param json
	 * @return
	 *//*
	private String pdCollateralGroup(HttpServletRequest request,
			HttpServletResponse response, JSONObject json) {
		logger.info("盘点押品组开始(不需要拍照盘点计划)!");
		JSONObject jsonReturn = new JSONObject();
		String userId = json.getString("userId");
		String password = json.getString("password");
		try {
			SM4Utils sm4 = new SM4Utils();
			sm4.secretKey = "JeF8U9wHFOMfs2Y8";
			sm4.hexString = false;
			password = sm4.decryptData_ECB(password);
			logger.info("请求用户名密码:userId=" + userId);
			boolean validateLdapUserFlag = LdapHelper.validateLdapUser(userId,
					password);
			if (!validateLdapUserFlag) {
				jsonReturn.put("statusApp", "S00201");
				jsonReturn.put("msg", "用户名或密码错误!");
				return jsonReturn.toString();
			}

			String code = json.getString("code");
			String collateralGroupId = json.getString("collateralGroupId");
			Map<String, Object> map = new HashMap<>();
			map.put("code", code);
			map.put("collateralGroupId", collateralGroupId);
			map.put("userId", userId);
			map.put("pdDate", new Date());
			int count = ypsummarConditionService
					.updateYpsummarConditionByCodeAndCGINotFile(map);
			if (count > 0) {
				jsonReturn.put("statusApp", "S00200");
				jsonReturn.put("msg", "盘点押品组成功!");
				logger.info("盘点押品组成功(不需要拍照盘点计划)!" + jsonReturn);
			} else {
				jsonReturn.put("statusApp", "S00202");
				jsonReturn.put("msg", "系统异常,盘点押品组失败!");
				logger.info("盘点押品组失败(不需要拍照盘点计划)!" + jsonReturn);
			}
		} catch (Exception e) {
			jsonReturn.put("statusApp", "E99500");
			jsonReturn.put("msg", "系统异常,盘点押品组失败!");
			logger.error("盘点操作失败!", e.getMessage());
		}
		return jsonReturn.toString();
	}*/

}
