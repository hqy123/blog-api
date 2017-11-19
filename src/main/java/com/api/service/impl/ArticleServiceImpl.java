package com.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.ArticleMapper;
import com.api.pojo.Article;
import com.api.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private  ArticleMapper articleMapper;

	public List<Article> getArticles(int category) {
		return articleMapper.getArticlesByCategory(category);
		
	}
	public Article getOneArticle(int id) {
		return articleMapper.getOneArticle(id);
	}
	public List<Article> getArticleList() {
		return articleMapper.getArticleList();
	}
	public void uploadArticle(Article article) {
		
		articleMapper.uploadArticle(article);
		
	}
	public int delArticleById(int id) {
		// TODO Auto-generated method stub
		return articleMapper.delArticleById(id);
	}

}
