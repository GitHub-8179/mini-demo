package com.reptile.entity;

import java.io.Serializable;
import java.util.Date;

public class ReptileEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String articleId;
	private String articleTitle;
	private String author;
	private Long createTime;
	private byte[] contentCrawl;
	private String source;
	private String articleKeyword;
	private int contentType;
	private Integer articleTypeId;
	private String contentExcerpt;

	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	

	
	public String getContentExcerpt() {
		return contentExcerpt;
	}
	public void setContentExcerpt(String contentExcerpt) {
		this.contentExcerpt = contentExcerpt;
	}
	public Integer getArticleTypeId() {
		return articleTypeId;
	}
	public void setArticleTypeId(Integer articleTypeId) {
		this.articleTypeId = articleTypeId;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public byte[] getContentCrawl() {
		return contentCrawl;
	}
	public void setContentCrawl(byte[] contentCrawl) {
		this.contentCrawl = contentCrawl;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getArticleKeyword() {
		return articleKeyword;
	}
	public void setArticleKeyword(String articleKeyword) {
		this.articleKeyword = articleKeyword;
	}
	public int getContentType() {
		return contentType;
	}
	public void setContentType(int contentType) {
		this.contentType = contentType;
	}

	
	
	
}
