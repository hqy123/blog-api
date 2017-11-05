package com.api.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.service.NodeService;

@Controller
public class AdminController {
	
	@Autowired
	NodeService nodeService;
	
	@RequestMapping("/addNode")
	public void addNode(String nodeName,HttpServletResponse res) {
		System.out.println(nodeName);
		int id = nodeService.addNode(nodeName);
		try {
			res.getWriter().println("11");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
