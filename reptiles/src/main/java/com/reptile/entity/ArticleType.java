package com.reptile.entity;

import java.util.Date;

public class ArticleType {
    private Integer articleTypeId;

    private String articleTypeName;

    private String articleTypeKeyword;

    private Date createTime;

    private String iamgeIcon;

    private String iamgeBack;

    private Integer parentid;

    public Integer getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Integer articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public String getArticleTypeName() {
        return articleTypeName;
    }

    public void setArticleTypeName(String articleTypeName) {
        this.articleTypeName = articleTypeName == null ? null : articleTypeName.trim();
    }

    public String getArticleTypeKeyword() {
        return articleTypeKeyword;
    }

    public void setArticleTypeKeyword(String articleTypeKeyword) {
        this.articleTypeKeyword = articleTypeKeyword == null ? null : articleTypeKeyword.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIamgeIcon() {
        return iamgeIcon;
    }

    public void setIamgeIcon(String iamgeIcon) {
        this.iamgeIcon = iamgeIcon == null ? null : iamgeIcon.trim();
    }

    public String getIamgeBack() {
        return iamgeBack;
    }

    public void setIamgeBack(String iamgeBack) {
        this.iamgeBack = iamgeBack == null ? null : iamgeBack.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
}