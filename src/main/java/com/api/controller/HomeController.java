package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.pojo.Article;
import com.api.service.ArticleService;


@Controller
public class HomeController {
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/getArticles")
	public @ResponseBody List<Article> getArticles(int category) {
		return articleService.getArticles(category);
		
	}
	
	@RequestMapping("/getOneArticle")
	public @ResponseBody Article getOneArticle(int id) {
		return articleService.getOneArticle(id);
	}
}
