package com.api.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.support.json.JSONUtils;

@Controller
public class AdminController {
	
	@RequestMapping("/adminLogin")
	public void adminLogin(@RequestBody Map map,HttpServletResponse res,HttpServletRequest req) {
		String username = (String) map.get("username");
		String password = (String) map.get("password");
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(new UsernamePasswordToken(username, password));
			String id = req.getSession().getId();
			Map<String ,String> resMap = new HashMap<String, String>();
			resMap.put("seesionid", id);
			resMap.put("username", username);
			
			String resmsg = JSONUtils.toJSONString(resMap);
			res.getWriter().write(resmsg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
}
