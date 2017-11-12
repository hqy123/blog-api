package com.api.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.pojo.Article;

@Repository
public interface ArticleMapper {
	
	public List<Article> getArticlesByCategory(int category);
	
	public Article getOneArticle(int id);

	public List<Article> getArticleList();

	public void uploadArticle(Article article);

	public int delArticleById(int id);

}
