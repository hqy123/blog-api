package com.api.pojo;

public class Article {
	private int pk_article_id;
	private String title;
	private String content;
	private long published_time;
	private int page_view;
	private int node;
	
	public int getPk_article_id() {
		return pk_article_id;
	}
	public void setPk_article_id(int pk_article_id) {
		this.pk_article_id = pk_article_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getPublished_time() {
		return published_time;
	}
	public void setPublished_time(long published_time) {
		this.published_time = published_time;
	}
	public int getPage_view() {
		return page_view;
	}
	public void setPage_view(int page_view) {
		this.page_view = page_view;
	}
	public int getNode() {
		return node;
	}
	public void setNode(int node) {
		this.node = node;
	}
	@Override
	public String toString() {
		return "Article [pk_article_id=" + pk_article_id + ", title=" + title + ", content=" + content
				+ ", published_time=" + published_time + ", page_view=" + page_view + ", node=" + node + "]";
	}

	
}
