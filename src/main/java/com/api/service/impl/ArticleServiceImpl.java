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

	@Override
	public List<Article> getArticles(int category) {
		return articleMapper.getArticlesByCategory(category);
		
	}
	@Override
	public Article getOneArticle(int id) {
		return articleMapper.getOneArticle(id);
	}
	@Override
	public List<Article> getArticleList() {
		return articleMapper.getArticleList();
	}
	@Override
	public void uploadArticle(Article article) {
		
		articleMapper.uploadArticle(article);
		
	}
	@Override
	public int delArticleById(int id) {
		// TODO Auto-generated method stub
		return articleMapper.delArticleById(id);
	}

}
