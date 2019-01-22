package com.reptile.entity;

import java.util.Date;

public class Article {
    private String articleId;

    private Integer articleTypeId;

    private String articleTitle;

    private String articleKeyword;

    private String author;

    private Date updateTime;

    private Date createTime;

    private String source;

    private Integer shareCount;

    private Integer collectCount;

    private Integer collectInitcount;

    private Integer shareInitcount;

    private Integer contentType;

    private String contentManual;

    private Integer contentReadcount;

    private String contentExcerpt;

    private String imagePath;

    private Integer state;

    private String detailsPath;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
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


    public Integer getArticleTypeId() {
		return articleTypeId;
	}

	public void setArticleTypeId(Integer articleTypeId) {
		this.articleTypeId = articleTypeId;
	}

	public Integer getShareCount() {
		return shareCount;
	}

	public void setShareCount(Integer shareCount) {
		this.shareCount = shareCount;
	}

	public Integer getCollectCount() {
		return collectCount;
	}

	public void setCollectCount(Integer collectCount) {
		this.collectCount = collectCount;
	}

	public Integer getCollectInitcount() {
		return collectInitcount;
	}

	public void setCollectInitcount(Integer collectInitcount) {
		this.collectInitcount = collectInitcount;
	}


    public String getContentManual() {
        return contentManual;
    }

    public void setContentManual(String contentManual) {
        this.contentManual = contentManual == null ? null : contentManual.trim();
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


    public Integer getShareInitcount() {
		return shareInitcount;
	}

	public void setShareInitcount(Integer shareInitcount) {
		this.shareInitcount = shareInitcount;
	}

	public Integer getContentType() {
		return contentType;
	}

	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}

	public Integer getContentReadcount() {
		return contentReadcount;
	}

	public void setContentReadcount(Integer contentReadcount) {
		this.contentReadcount = contentReadcount;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getDetailsPath() {
        return detailsPath;
    }

    public void setDetailsPath(String detailsPath) {
        this.detailsPath = detailsPath == null ? null : detailsPath.trim();
    }
}