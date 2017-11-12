package com.api.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.pojo.Article;
import com.api.pojo.Node;
import com.api.service.ArticleService;
import com.api.service.NodeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class AdminController {
	
	@Autowired
	NodeService nodeService;
	@Autowired
	ArticleService articleService;
	
	final static  int PAGESIZE = 10;
	
	
	@RequestMapping("/adminLogin")
	public void adminLogin(@RequestBody Map map,HttpServletResponse res,HttpServletRequest req) {
		String username = (String) map.get("username");
		String password = (String) map.get("password");
		Subject subject = SecurityUtils.getSubject();
		
		try {
			subject.login(new UsernamePasswordToken(username, password));
			String id = req.getSession().getId();
			res.getWriter().write(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	@RequestMapping("/addNode")
	public void addNode(String nodeName,HttpServletResponse res) {
		int id = nodeService.addNode(nodeName); 
		try {
			if(id==1) {
				res.getWriter().println("添加成功");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getNodeList")
	public @ResponseBody PageInfo<Node> getNodeList(HttpServletRequest req){
		int page = Integer.parseInt(req.getParameter("page"));
		PageHelper.startPage(page, PAGESIZE);
		List<Node> list = nodeService.getNodeList();
		PageInfo<Node> pageInfo = new PageInfo<>(list);
		
		return pageInfo;
		
	}
	
	@RequestMapping("/delNodeById")
	public void delNodeById(@RequestBody  Map map,HttpServletResponse res) {
		int node_id = (int) map.get("node_id");
		int result = nodeService.delNodeById(node_id);
		try {
			res.getWriter().write("删除成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/uploadArticle")
	public void uploadArticle(@RequestBody Article article,HttpServletResponse res) {
		
		article.setPublished_time(System.currentTimeMillis());
		articleService.uploadArticle(article);
		
		try {
			res.getWriter().write("success"); //乱码 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	@RequestMapping("/getArticleList")
	public @ResponseBody List<Article> getArticleList(){
		return articleService.getArticleList();
	}
	@RequestMapping("/delArticleById")
	public void delArticleById(@RequestBody Map map,HttpServletResponse res) {
		int id = (int) map.get("id");
		int result = articleService.delArticleById(id);
		if(result == 1) {
			try {
				res.getWriter().println("删除成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
