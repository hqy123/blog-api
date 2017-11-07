package com.api.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.pojo.Article;
import com.api.pojo.Node;
import com.api.service.ArticleService;
import com.api.service.NodeService;

@Controller
public class AdminController {
	
	@Autowired
	NodeService nodeService;
	@Autowired
	ArticleService articleService;
	
	@RequestMapping("/addNode")
	public void addNode(String nodeName,HttpServletResponse res) {
		int id = nodeService.addNode(nodeName); 
		try {
			if(id==1) {
				res.getWriter().println("Ìí¼Ó³É¹¦");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getNodeList")
	public @ResponseBody List<Node> getNodeList(){
		return nodeService.getNodeList();
		
	}
	
	@RequestMapping("/uploadArticle")
	public void uploadArticle(Article article,HttpServletResponse res) {
		
		article.setPublished_time(System.currentTimeMillis());
		articleService.uploadArticle(article);
		
		try {
			res.getWriter().write("success"); //ÂÒÂë 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/getArticleList")
	public @ResponseBody List<Article> getArticleList(){
		return articleService.getArticleList();
	}
	
}
