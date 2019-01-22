package com.reptile.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(String value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(String value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(String value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(String value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(String value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(String value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLike(String value) {
            addCriterion("article_id like", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotLike(String value) {
            addCriterion("article_id not like", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<String> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<String> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(String value1, String value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(String value1, String value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdIsNull() {
            addCriterion("article_type_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdIsNotNull() {
            addCriterion("article_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdEqualTo(Integer value) {
            addCriterion("article_type_id =", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdNotEqualTo(Integer value) {
            addCriterion("article_type_id <>", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdGreaterThan(Integer value) {
            addCriterion("article_type_id >", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_type_id >=", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdLessThan(Integer value) {
            addCriterion("article_type_id <", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("article_type_id <=", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdIn(List<Integer> values) {
            addCriterion("article_type_id in", values, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdNotIn(List<Integer> values) {
            addCriterion("article_type_id not in", values, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("article_type_id between", value1, value2, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("article_type_id not between", value1, value2, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNull() {
            addCriterion("article_title is null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNotNull() {
            addCriterion("article_title is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleEqualTo(String value) {
            addCriterion("article_title =", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotEqualTo(String value) {
            addCriterion("article_title <>", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThan(String value) {
            addCriterion("article_title >", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThanOrEqualTo(String value) {
            addCriterion("article_title >=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThan(String value) {
            addCriterion("article_title <", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThanOrEqualTo(String value) {
            addCriterion("article_title <=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLike(String value) {
            addCriterion("article_title like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotLike(String value) {
            addCriterion("article_title not like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIn(List<String> values) {
            addCriterion("article_title in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotIn(List<String> values) {
            addCriterion("article_title not in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleBetween(String value1, String value2) {
            addCriterion("article_title between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotBetween(String value1, String value2) {
            addCriterion("article_title not between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleKeywordIsNull() {
            addCriterion("article_keyword is null");
            return (Criteria) this;
        }

        public Criteria andArticleKeywordIsNotNull() {
            addCriterion("article_keyword is not null");
            return (Criteria) this;
        }

        public Criteria andArticleKeywordEqualTo(String value) {
            addCriterion("article_keyword =", value, "articleKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleKeywordNotEqualTo(String value) {
            addCriterion("article_keyword <>", value, "articleKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleKeywordGreaterThan(String value) {
            addCriterion("article_keyword >", value, "articleKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("article_keyword >=", value, "articleKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleKeywordLessThan(String value) {
            addCriterion("article_keyword <", value, "articleKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleKeywordLessThanOrEqualTo(String value) {
            addCriterion("article_keyword <=", value, "articleKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleKeywordLike(String value) {
            addCriterion("article_keyword like", value, "articleKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleKeywordNotLike(String value) {
            addCriterion("article_keyword not like", value, "articleKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleKeywordIn(List<String> values) {
            addCriterion("article_keyword in", values, "articleKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleKeywordNotIn(List<String> values) {
            addCriterion("article_keyword not in", values, "articleKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleKeywordBetween(String value1, String value2) {
            addCriterion("article_keyword between", value1, value2, "articleKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleKeywordNotBetween(String value1, String value2) {
            addCriterion("article_keyword not between", value1, value2, "articleKeyword");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andShareCountIsNull() {
            addCriterion("share_count is null");
            return (Criteria) this;
        }

        public Criteria andShareCountIsNotNull() {
            addCriterion("share_count is not null");
            return (Criteria) this;
        }

        public Criteria andShareCountEqualTo(Integer value) {
            addCriterion("share_count =", value, "shareCount");
            return (Criteria) this;
        }

        public Criteria andShareCountNotEqualTo(Integer value) {
            addCriterion("share_count <>", value, "shareCount");
            return (Criteria) this;
        }

        public Criteria andShareCountGreaterThan(Integer value) {
            addCriterion("share_count >", value, "shareCount");
            return (Criteria) this;
        }

        public Criteria andShareCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_count >=", value, "shareCount");
            return (Criteria) this;
        }

        public Criteria andShareCountLessThan(Integer value) {
            addCriterion("share_count <", value, "shareCount");
            return (Criteria) this;
        }

        public Criteria andShareCountLessThanOrEqualTo(Integer value) {
            addCriterion("share_count <=", value, "shareCount");
            return (Criteria) this;
        }

        public Criteria andShareCountIn(List<Integer> values) {
            addCriterion("share_count in", values, "shareCount");
            return (Criteria) this;
        }

        public Criteria andShareCountNotIn(List<Integer> values) {
            addCriterion("share_count not in", values, "shareCount");
            return (Criteria) this;
        }

        public Criteria andShareCountBetween(Integer value1, Integer value2) {
            addCriterion("share_count between", value1, value2, "shareCount");
            return (Criteria) this;
        }

        public Criteria andShareCountNotBetween(Integer value1, Integer value2) {
            addCriterion("share_count not between", value1, value2, "shareCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountIsNull() {
            addCriterion("collect_count is null");
            return (Criteria) this;
        }

        public Criteria andCollectCountIsNotNull() {
            addCriterion("collect_count is not null");
            return (Criteria) this;
        }

        public Criteria andCollectCountEqualTo(Integer value) {
            addCriterion("collect_count =", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountNotEqualTo(Integer value) {
            addCriterion("collect_count <>", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountGreaterThan(Integer value) {
            addCriterion("collect_count >", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_count >=", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountLessThan(Integer value) {
            addCriterion("collect_count <", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountLessThanOrEqualTo(Integer value) {
            addCriterion("collect_count <=", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountIn(List<Integer> values) {
            addCriterion("collect_count in", values, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountNotIn(List<Integer> values) {
            addCriterion("collect_count not in", values, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountBetween(Integer value1, Integer value2) {
            addCriterion("collect_count between", value1, value2, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_count not between", value1, value2, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectInitcountIsNull() {
            addCriterion("collect_initcount is null");
            return (Criteria) this;
        }

        public Criteria andCollectInitcountIsNotNull() {
            addCriterion("collect_initcount is not null");
            return (Criteria) this;
        }

        public Criteria andCollectInitcountEqualTo(Integer value) {
            addCriterion("collect_initcount =", value, "collectInitcount");
            return (Criteria) this;
        }

        public Criteria andCollectInitcountNotEqualTo(Integer value) {
            addCriterion("collect_initcount <>", value, "collectInitcount");
            return (Criteria) this;
        }

        public Criteria andCollectInitcountGreaterThan(Integer value) {
            addCriterion("collect_initcount >", value, "collectInitcount");
            return (Criteria) this;
        }

        public Criteria andCollectInitcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_initcount >=", value, "collectInitcount");
            return (Criteria) this;
        }

        public Criteria andCollectInitcountLessThan(Integer value) {
            addCriterion("collect_initcount <", value, "collectInitcount");
            return (Criteria) this;
        }

        public Criteria andCollectInitcountLessThanOrEqualTo(Integer value) {
            addCriterion("collect_initcount <=", value, "collectInitcount");
            return (Criteria) this;
        }

        public Criteria andCollectInitcountIn(List<Integer> values) {
            addCriterion("collect_initcount in", values, "collectInitcount");
            return (Criteria) this;
        }

        public Criteria andCollectInitcountNotIn(List<Integer> values) {
            addCriterion("collect_initcount not in", values, "collectInitcount");
            return (Criteria) this;
        }

        public Criteria andCollectInitcountBetween(Integer value1, Integer value2) {
            addCriterion("collect_initcount between", value1, value2, "collectInitcount");
            return (Criteria) this;
        }

        public Criteria andCollectInitcountNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_initcount not between", value1, value2, "collectInitcount");
            return (Criteria) this;
        }

        public Criteria andShareInitcountIsNull() {
            addCriterion("share_initcount is null");
            return (Criteria) this;
        }

        public Criteria andShareInitcountIsNotNull() {
            addCriterion("share_initcount is not null");
            return (Criteria) this;
        }

        public Criteria andShareInitcountEqualTo(Integer value) {
            addCriterion("share_initcount =", value, "shareInitcount");
            return (Criteria) this;
        }

        public Criteria andShareInitcountNotEqualTo(Integer value) {
            addCriterion("share_initcount <>", value, "shareInitcount");
            return (Criteria) this;
        }

        public Criteria andShareInitcountGreaterThan(Integer value) {
            addCriterion("share_initcount >", value, "shareInitcount");
            return (Criteria) this;
        }

        public Criteria andShareInitcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_initcount >=", value, "shareInitcount");
            return (Criteria) this;
        }

        public Criteria andShareInitcountLessThan(Integer value) {
            addCriterion("share_initcount <", value, "shareInitcount");
            return (Criteria) this;
        }

        public Criteria andShareInitcountLessThanOrEqualTo(Integer value) {
            addCriterion("share_initcount <=", value, "shareInitcount");
            return (Criteria) this;
        }

        public Criteria andShareInitcountIn(List<Integer> values) {
            addCriterion("share_initcount in", values, "shareInitcount");
            return (Criteria) this;
        }

        public Criteria andShareInitcountNotIn(List<Integer> values) {
            addCriterion("share_initcount not in", values, "shareInitcount");
            return (Criteria) this;
        }

        public Criteria andShareInitcountBetween(Integer value1, Integer value2) {
            addCriterion("share_initcount between", value1, value2, "shareInitcount");
            return (Criteria) this;
        }

        public Criteria andShareInitcountNotBetween(Integer value1, Integer value2) {
            addCriterion("share_initcount not between", value1, value2, "shareInitcount");
            return (Criteria) this;
        }

        public Criteria andContentTypeIsNull() {
            addCriterion("content_type is null");
            return (Criteria) this;
        }

        public Criteria andContentTypeIsNotNull() {
            addCriterion("content_type is not null");
            return (Criteria) this;
        }

        public Criteria andContentTypeEqualTo(Integer value) {
            addCriterion("content_type =", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotEqualTo(Integer value) {
            addCriterion("content_type <>", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThan(Integer value) {
            addCriterion("content_type >", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("content_type >=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThan(Integer value) {
            addCriterion("content_type <", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("content_type <=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeIn(List<Integer> values) {
            addCriterion("content_type in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotIn(List<Integer> values) {
            addCriterion("content_type not in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeBetween(Integer value1, Integer value2) {
            addCriterion("content_type between", value1, value2, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("content_type not between", value1, value2, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentManualIsNull() {
            addCriterion("content_manual is null");
            return (Criteria) this;
        }

        public Criteria andContentManualIsNotNull() {
            addCriterion("content_manual is not null");
            return (Criteria) this;
        }

        public Criteria andContentManualEqualTo(String value) {
            addCriterion("content_manual =", value, "contentManual");
            return (Criteria) this;
        }

        public Criteria andContentManualNotEqualTo(String value) {
            addCriterion("content_manual <>", value, "contentManual");
            return (Criteria) this;
        }

        public Criteria andContentManualGreaterThan(String value) {
            addCriterion("content_manual >", value, "contentManual");
            return (Criteria) this;
        }

        public Criteria andContentManualGreaterThanOrEqualTo(String value) {
            addCriterion("content_manual >=", value, "contentManual");
            return (Criteria) this;
        }

        public Criteria andContentManualLessThan(String value) {
            addCriterion("content_manual <", value, "contentManual");
            return (Criteria) this;
        }

        public Criteria andContentManualLessThanOrEqualTo(String value) {
            addCriterion("content_manual <=", value, "contentManual");
            return (Criteria) this;
        }

        public Criteria andContentManualLike(String value) {
            addCriterion("content_manual like", value, "contentManual");
            return (Criteria) this;
        }

        public Criteria andContentManualNotLike(String value) {
            addCriterion("content_manual not like", value, "contentManual");
            return (Criteria) this;
        }

        public Criteria andContentManualIn(List<String> values) {
            addCriterion("content_manual in", values, "contentManual");
            return (Criteria) this;
        }

        public Criteria andContentManualNotIn(List<String> values) {
            addCriterion("content_manual not in", values, "contentManual");
            return (Criteria) this;
        }

        public Criteria andContentManualBetween(String value1, String value2) {
            addCriterion("content_manual between", value1, value2, "contentManual");
            return (Criteria) this;
        }

        public Criteria andContentManualNotBetween(String value1, String value2) {
            addCriterion("content_manual not between", value1, value2, "contentManual");
            return (Criteria) this;
        }

        public Criteria andContentReadcountIsNull() {
            addCriterion("content_readcount is null");
            return (Criteria) this;
        }

        public Criteria andContentReadcountIsNotNull() {
            addCriterion("content_readcount is not null");
            return (Criteria) this;
        }

        public Criteria andContentReadcountEqualTo(Integer value) {
            addCriterion("content_readcount =", value, "contentReadcount");
            return (Criteria) this;
        }

        public Criteria andContentReadcountNotEqualTo(Integer value) {
            addCriterion("content_readcount <>", value, "contentReadcount");
            return (Criteria) this;
        }

        public Criteria andContentReadcountGreaterThan(Integer value) {
            addCriterion("content_readcount >", value, "contentReadcount");
            return (Criteria) this;
        }

        public Criteria andContentReadcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("content_readcount >=", value, "contentReadcount");
            return (Criteria) this;
        }

        public Criteria andContentReadcountLessThan(Integer value) {
            addCriterion("content_readcount <", value, "contentReadcount");
            return (Criteria) this;
        }

        public Criteria andContentReadcountLessThanOrEqualTo(Integer value) {
            addCriterion("content_readcount <=", value, "contentReadcount");
            return (Criteria) this;
        }

        public Criteria andContentReadcountIn(List<Integer> values) {
            addCriterion("content_readcount in", values, "contentReadcount");
            return (Criteria) this;
        }

        public Criteria andContentReadcountNotIn(List<Integer> values) {
            addCriterion("content_readcount not in", values, "contentReadcount");
            return (Criteria) this;
        }

        public Criteria andContentReadcountBetween(Integer value1, Integer value2) {
            addCriterion("content_readcount between", value1, value2, "contentReadcount");
            return (Criteria) this;
        }

        public Criteria andContentReadcountNotBetween(Integer value1, Integer value2) {
            addCriterion("content_readcount not between", value1, value2, "contentReadcount");
            return (Criteria) this;
        }

        public Criteria andContentExcerptIsNull() {
            addCriterion("content_excerpt is null");
            return (Criteria) this;
        }

        public Criteria andContentExcerptIsNotNull() {
            addCriterion("content_excerpt is not null");
            return (Criteria) this;
        }

        public Criteria andContentExcerptEqualTo(String value) {
            addCriterion("content_excerpt =", value, "contentExcerpt");
            return (Criteria) this;
        }

        public Criteria andContentExcerptNotEqualTo(String value) {
            addCriterion("content_excerpt <>", value, "contentExcerpt");
            return (Criteria) this;
        }

        public Criteria andContentExcerptGreaterThan(String value) {
            addCriterion("content_excerpt >", value, "contentExcerpt");
            return (Criteria) this;
        }

        public Criteria andContentExcerptGreaterThanOrEqualTo(String value) {
            addCriterion("content_excerpt >=", value, "contentExcerpt");
            return (Criteria) this;
        }

        public Criteria andContentExcerptLessThan(String value) {
            addCriterion("content_excerpt <", value, "contentExcerpt");
            return (Criteria) this;
        }

        public Criteria andContentExcerptLessThanOrEqualTo(String value) {
            addCriterion("content_excerpt <=", value, "contentExcerpt");
            return (Criteria) this;
        }

        public Criteria andContentExcerptLike(String value) {
            addCriterion("content_excerpt like", value, "contentExcerpt");
            return (Criteria) this;
        }

        public Criteria andContentExcerptNotLike(String value) {
            addCriterion("content_excerpt not like", value, "contentExcerpt");
            return (Criteria) this;
        }

        public Criteria andContentExcerptIn(List<String> values) {
            addCriterion("content_excerpt in", values, "contentExcerpt");
            return (Criteria) this;
        }

        public Criteria andContentExcerptNotIn(List<String> values) {
            addCriterion("content_excerpt not in", values, "contentExcerpt");
            return (Criteria) this;
        }

        public Criteria andContentExcerptBetween(String value1, String value2) {
            addCriterion("content_excerpt between", value1, value2, "contentExcerpt");
            return (Criteria) this;
        }

        public Criteria andContentExcerptNotBetween(String value1, String value2) {
            addCriterion("content_excerpt not between", value1, value2, "contentExcerpt");
            return (Criteria) this;
        }

        public Criteria andImagePathIsNull() {
            addCriterion("image_path is null");
            return (Criteria) this;
        }

        public Criteria andImagePathIsNotNull() {
            addCriterion("image_path is not null");
            return (Criteria) this;
        }

        public Criteria andImagePathEqualTo(String value) {
            addCriterion("image_path =", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotEqualTo(String value) {
            addCriterion("image_path <>", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathGreaterThan(String value) {
            addCriterion("image_path >", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathGreaterThanOrEqualTo(String value) {
            addCriterion("image_path >=", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLessThan(String value) {
            addCriterion("image_path <", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLessThanOrEqualTo(String value) {
            addCriterion("image_path <=", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLike(String value) {
            addCriterion("image_path like", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotLike(String value) {
            addCriterion("image_path not like", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathIn(List<String> values) {
            addCriterion("image_path in", values, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotIn(List<String> values) {
            addCriterion("image_path not in", values, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathBetween(String value1, String value2) {
            addCriterion("image_path between", value1, value2, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotBetween(String value1, String value2) {
            addCriterion("image_path not between", value1, value2, "imagePath");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andDetailsPathIsNull() {
            addCriterion("details_path is null");
            return (Criteria) this;
        }

        public Criteria andDetailsPathIsNotNull() {
            addCriterion("details_path is not null");
            return (Criteria) this;
        }

        public Criteria andDetailsPathEqualTo(String value) {
            addCriterion("details_path =", value, "detailsPath");
            return (Criteria) this;
        }

        public Criteria andDetailsPathNotEqualTo(String value) {
            addCriterion("details_path <>", value, "detailsPath");
            return (Criteria) this;
        }

        public Criteria andDetailsPathGreaterThan(String value) {
            addCriterion("details_path >", value, "detailsPath");
            return (Criteria) this;
        }

        public Criteria andDetailsPathGreaterThanOrEqualTo(String value) {
            addCriterion("details_path >=", value, "detailsPath");
            return (Criteria) this;
        }

        public Criteria andDetailsPathLessThan(String value) {
            addCriterion("details_path <", value, "detailsPath");
            return (Criteria) this;
        }

        public Criteria andDetailsPathLessThanOrEqualTo(String value) {
            addCriterion("details_path <=", value, "detailsPath");
            return (Criteria) this;
        }

        public Criteria andDetailsPathLike(String value) {
            addCriterion("details_path like", value, "detailsPath");
            return (Criteria) this;
        }

        public Criteria andDetailsPathNotLike(String value) {
            addCriterion("details_path not like", value, "detailsPath");
            return (Criteria) this;
        }

        public Criteria andDetailsPathIn(List<String> values) {
            addCriterion("details_path in", values, "detailsPath");
            return (Criteria) this;
        }

        public Criteria andDetailsPathNotIn(List<String> values) {
            addCriterion("details_path not in", values, "detailsPath");
            return (Criteria) this;
        }

        public Criteria andDetailsPathBetween(String value1, String value2) {
            addCriterion("details_path between", value1, value2, "detailsPath");
            return (Criteria) this;
        }

        public Criteria andDetailsPathNotBetween(String value1, String value2) {
            addCriterion("details_path not between", value1, value2, "detailsPath");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}