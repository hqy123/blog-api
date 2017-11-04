package com.api.service;

import java.util.List;

import com.api.pojo.Article;


public interface ArticleService {


	List<Article> getArticles(int category);

	Article getOneArticle(int id);

}
