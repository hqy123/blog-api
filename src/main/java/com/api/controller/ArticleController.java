package com.api.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.pojo.Article;
import com.api.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	ArticleService articleService;
	
	
	@RequestMapping("/getArticleList")
	public @ResponseBody List<Article> getArticleList(){
		return articleService.getArticleList();
	}
	@RequestMapping("/getOneArticle")
	public @ResponseBody Article getOneArticle(int id) {
		return articleService.getOneArticle(id);
	}
	@RequestMapping("/getArticles")
	public @ResponseBody List<Article> getArticles(int category) {
		return articleService.getArticles(category);
		
	}
	
	@RequestMapping("/delArticleById")
	public void delArticleById(@RequestBody Map map,HttpServletResponse res) {
		int id = (Integer) map.get("id");
		int result = articleService.delArticleById(id);
		if(result == 1) {
			try {
				res.getWriter().println("É¾³ý³É¹¦");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	@RequestMapping("/uploadArticle")
	public void uploadArticle(@RequestBody Article article,HttpServletResponse res) {
		
		article.setPublished_time(System.currentTimeMillis());
		articleService.uploadArticle(article);
		
		try {
			res.getWriter().write("success"); //ÂÒÂë 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
