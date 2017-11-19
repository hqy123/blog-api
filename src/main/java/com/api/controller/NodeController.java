package com.api.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.pojo.Node;
import com.api.service.NodeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class NodeController {
	
	@Autowired
	NodeService nodeService;

	final static int PAGESIZE = 10;

	@RequestMapping("/addNode")
	public void addNode(String nodeName, HttpServletResponse res) {
		int id = nodeService.addNode(nodeName);
		try {
			if (id == 1) {
				res.getWriter().println("添加成功");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getHomeNode")
	public @ResponseBody List<Node> getHomeNode(){
		return nodeService.getNodeList();
	}
	
	@RequestMapping("/getNodeList")
	public @ResponseBody PageInfo<Node> getNodeList(HttpServletRequest req) {
		int page = Integer.parseInt(req.getParameter("page"));
		PageHelper.startPage(page, PAGESIZE);
		List<Node> list = nodeService.getNodeList();
		PageInfo<Node> pageInfo = new PageInfo<Node>(list);

		return pageInfo;

	}

	@RequestMapping("/delNodeById")
	public void delNodeById(@RequestBody Map map, HttpServletResponse res) {
		int node_id = (Integer) map.get("node_id");
		int result = nodeService.delNodeById(node_id);
		try {
			res.getWriter().write("删除成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
