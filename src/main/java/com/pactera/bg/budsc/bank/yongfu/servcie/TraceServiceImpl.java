package com.pactera.bg.budsc.bank.yongfu.servcie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frw.way.commons.utils.CollectionUtil;
import com.pactera.bg.budsc.bank.yongfu.mapper.TraceMapper;
import com.pactera.bg.budsc.bank.yongfu.po.Point;
import com.pactera.bg.budsc.bank.yongfu.po.Trace;
import com.pactera.bg.budsc.bank.yongfu.po.User;
import com.pactera.bg.budsc.bank.yongfu.serviceI.TraceServiceI;

@Service("traceService")
public class TraceServiceImpl implements TraceServiceI {

	Logger logger = LoggerFactory.getLogger(TraceServiceImpl.class);

	@Autowired
	private TraceMapper traceMapper;

	@Override
	public int insert(List<Trace> list) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> values = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			StringBuffer s = new StringBuffer("");
			//s.append("'" + list.get(i).getId() + "' id,");
			s.append("'" + list.get(i).getLongitude() + "' longitude,");
			s.append("'" + list.get(i).getLatitude() + "' latitude,");
			//s.append("'" + list.get(i).getUserId() + "' user_id,");
			s.append("'" + list.get(i).getStartTime() + "' start_time");
			s.append("'" + list.get(i).getEndTime() + "' end_time");
			//s.append("'" + list.get(i).getLastPointSign() + "' last_point_sign");
			s.append("'" + list.get(i).getCreateTime() + "' create_Time");
			values.add(s.toString());
		}
		map.put("values", values);
		int insert = traceMapper.insert(map);
		return insert;
	}

	/*
	 * @Override public List<User> select(User user) { List<User> select =
	 * traceMapper.select(user); return select; }
	 */

	@Override
	public List<Point> getAllTraces(User user) {
		double num = getNum(user);
		List<Point> listPoint = new ArrayList<Point>();
		if (num != 0) {
			user.setNum(num);
			List<Trace> list = traceMapper.getAllTraces(user);
			if (CollectionUtil.isNotEmpty(list)) {
				for (int i = 0; i < list.size(); i++) {
					Point point = new Point(list.get(i).getLongitude(), list.get(i).getLatitude());
					listPoint.add(point);
				}
			}
		}
		return listPoint;
	}

	@Override
	public int insertOne(Trace trace) {
		int insert = traceMapper.insertOne(trace);
		return insert;
	}

	/*
	 * @Override public List<User> selectFirends(Map<String, String> map) {
	 * List<User> list = traceMapper.selectFirends(map); return list; }
	 */
	public double getNum(User user) {
		// 先查询数据一共有多少个点
		int count = traceMapper.getCount(user);
		logger.info("足迹数据---》        " + count);
		double num = 1.1;
		if (count == 0) {
			return 0;
		}
		if (count > 1000) {
			num = count / 1000;
		}
		return num;
	}

	@Override
	public int updateLastSignById(Trace trace) {
		traceMapper.updateLastSignById(trace);
		return 0;
	}
}
