package com.reptile.entity;

import java.util.Date;

public class Article {
    private String articleId;

    private Double articleTypeId;

    private String articleTitle;

    private String articleKeyword;

    private String author;

    private Date updateTime;

    private Date createTime;

    private String source;

    private Double shareCount;

    private Double collectCount;

    private Double collectInitcount;

    private Double shareInitcount;

    private Double contentType;

    private String contentManual;

    private Double contentReadcount;

    private String contentExcerpt;

    private String imagePath;

    private Double state;

    private String detailsPath;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
    }

    public Double getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Double articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public String getArticleKeyword() {
        return articleKeyword;
    }

    public void setArticleKeyword(String articleKeyword) {
        this.articleKeyword = articleKeyword == null ? null : articleKeyword.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Double getShareCount() {
        return shareCount;
    }

    public void setShareCount(Double shareCount) {
        this.shareCount = shareCount;
    }

    public Double getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Double collectCount) {
        this.collectCount = collectCount;
    }

    public Double getCollectInitcount() {
        return collectInitcount;
    }

    public void setCollectInitcount(Double collectInitcount) {
        this.collectInitcount = collectInitcount;
    }

    public Double getShareInitcount() {
        return shareInitcount;
    }

    public void setShareInitcount(Double shareInitcount) {
        this.shareInitcount = shareInitcount;
    }

    public Double getContentType() {
        return contentType;
    }

    public void setContentType(Double contentType) {
        this.contentType = contentType;
    }

    public String getContentManual() {
        return contentManual;
    }

    public void setContentManual(String contentManual) {
        this.contentManual = contentManual == null ? null : contentManual.trim();
    }

    public Double getContentReadcount() {
        return contentReadcount;
    }

    public void setContentReadcount(Double contentReadcount) {
        this.contentReadcount = contentReadcount;
    }

    public String getContentExcerpt() {
        return contentExcerpt;
    }

    public void setContentExcerpt(String contentExcerpt) {
        this.contentExcerpt = contentExcerpt == null ? null : contentExcerpt.trim();
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    public Double getState() {
        return state;
    }

    public void setState(Double state) {
        this.state = state;
    }

    public String getDetailsPath() {
        return detailsPath;
    }

    public void setDetailsPath(String detailsPath) {
        this.detailsPath = detailsPath == null ? null : detailsPath.trim();
    }
}