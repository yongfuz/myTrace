package com.pactera.bg.budsc.bank.yongfu.servcie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactera.bg.budsc.bank.yongfu.mapper.TraceMapper;
import com.pactera.bg.budsc.bank.yongfu.po.Trace;
import com.pactera.bg.budsc.bank.yongfu.po.User;
import com.pactera.bg.budsc.bank.yongfu.serviceI.TraceServiceI;

@Service("traceService")
public class TraceServiceImpl implements TraceServiceI {

	@Autowired
	private TraceMapper traceMapper;

	@Override
	public int insert(List<Trace> list) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> values = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			StringBuffer s = new StringBuffer("");
			s.append("'" + list.get(i).getId() + "' id,");
			s.append("GeomFromText('POINT(" + list.get(i).getPoint().getLongitude() + " " + list.get(i).getPoint().getLatitude() + ")') point,");
			s.append("'" + list.get(i).getId() + "' user_id,");
			s.append("'" + list.get(i).getCreateTime() + "' create_time");
			values.add(s.toString());
		}
		map.put("values", values);
		int insert = traceMapper.insert(map);
		return insert;
	}

	@Override
	public List<User> select(User user) {
		List<User> select = traceMapper.select(user);
		return select;
	}

}
