package com.reptile.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleTypeExample() {
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

        public Criteria andArticleTypeNameIsNull() {
            addCriterion("article_type_name is null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameIsNotNull() {
            addCriterion("article_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameEqualTo(String value) {
            addCriterion("article_type_name =", value, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameNotEqualTo(String value) {
            addCriterion("article_type_name <>", value, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameGreaterThan(String value) {
            addCriterion("article_type_name >", value, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("article_type_name >=", value, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameLessThan(String value) {
            addCriterion("article_type_name <", value, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameLessThanOrEqualTo(String value) {
            addCriterion("article_type_name <=", value, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameLike(String value) {
            addCriterion("article_type_name like", value, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameNotLike(String value) {
            addCriterion("article_type_name not like", value, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameIn(List<String> values) {
            addCriterion("article_type_name in", values, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameNotIn(List<String> values) {
            addCriterion("article_type_name not in", values, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameBetween(String value1, String value2) {
            addCriterion("article_type_name between", value1, value2, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameNotBetween(String value1, String value2) {
            addCriterion("article_type_name not between", value1, value2, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeKeywordIsNull() {
            addCriterion("article_type_keyword is null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeKeywordIsNotNull() {
            addCriterion("article_type_keyword is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeKeywordEqualTo(String value) {
            addCriterion("article_type_keyword =", value, "articleTypeKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleTypeKeywordNotEqualTo(String value) {
            addCriterion("article_type_keyword <>", value, "articleTypeKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleTypeKeywordGreaterThan(String value) {
            addCriterion("article_type_keyword >", value, "articleTypeKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleTypeKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("article_type_keyword >=", value, "articleTypeKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleTypeKeywordLessThan(String value) {
            addCriterion("article_type_keyword <", value, "articleTypeKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleTypeKeywordLessThanOrEqualTo(String value) {
            addCriterion("article_type_keyword <=", value, "articleTypeKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleTypeKeywordLike(String value) {
            addCriterion("article_type_keyword like", value, "articleTypeKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleTypeKeywordNotLike(String value) {
            addCriterion("article_type_keyword not like", value, "articleTypeKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleTypeKeywordIn(List<String> values) {
            addCriterion("article_type_keyword in", values, "articleTypeKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleTypeKeywordNotIn(List<String> values) {
            addCriterion("article_type_keyword not in", values, "articleTypeKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleTypeKeywordBetween(String value1, String value2) {
            addCriterion("article_type_keyword between", value1, value2, "articleTypeKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleTypeKeywordNotBetween(String value1, String value2) {
            addCriterion("article_type_keyword not between", value1, value2, "articleTypeKeyword");
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

        public Criteria andIamgeIconIsNull() {
            addCriterion("iamge_icon is null");
            return (Criteria) this;
        }

        public Criteria andIamgeIconIsNotNull() {
            addCriterion("iamge_icon is not null");
            return (Criteria) this;
        }

        public Criteria andIamgeIconEqualTo(String value) {
            addCriterion("iamge_icon =", value, "iamgeIcon");
            return (Criteria) this;
        }

        public Criteria andIamgeIconNotEqualTo(String value) {
            addCriterion("iamge_icon <>", value, "iamgeIcon");
            return (Criteria) this;
        }

        public Criteria andIamgeIconGreaterThan(String value) {
            addCriterion("iamge_icon >", value, "iamgeIcon");
            return (Criteria) this;
        }

        public Criteria andIamgeIconGreaterThanOrEqualTo(String value) {
            addCriterion("iamge_icon >=", value, "iamgeIcon");
            return (Criteria) this;
        }

        public Criteria andIamgeIconLessThan(String value) {
            addCriterion("iamge_icon <", value, "iamgeIcon");
            return (Criteria) this;
        }

        public Criteria andIamgeIconLessThanOrEqualTo(String value) {
            addCriterion("iamge_icon <=", value, "iamgeIcon");
            return (Criteria) this;
        }

        public Criteria andIamgeIconLike(String value) {
            addCriterion("iamge_icon like", value, "iamgeIcon");
            return (Criteria) this;
        }

        public Criteria andIamgeIconNotLike(String value) {
            addCriterion("iamge_icon not like", value, "iamgeIcon");
            return (Criteria) this;
        }

        public Criteria andIamgeIconIn(List<String> values) {
            addCriterion("iamge_icon in", values, "iamgeIcon");
            return (Criteria) this;
        }

        public Criteria andIamgeIconNotIn(List<String> values) {
            addCriterion("iamge_icon not in", values, "iamgeIcon");
            return (Criteria) this;
        }

        public Criteria andIamgeIconBetween(String value1, String value2) {
            addCriterion("iamge_icon between", value1, value2, "iamgeIcon");
            return (Criteria) this;
        }

        public Criteria andIamgeIconNotBetween(String value1, String value2) {
            addCriterion("iamge_icon not between", value1, value2, "iamgeIcon");
            return (Criteria) this;
        }

        public Criteria andIamgeBackIsNull() {
            addCriterion("iamge_back is null");
            return (Criteria) this;
        }

        public Criteria andIamgeBackIsNotNull() {
            addCriterion("iamge_back is not null");
            return (Criteria) this;
        }

        public Criteria andIamgeBackEqualTo(String value) {
            addCriterion("iamge_back =", value, "iamgeBack");
            return (Criteria) this;
        }

        public Criteria andIamgeBackNotEqualTo(String value) {
            addCriterion("iamge_back <>", value, "iamgeBack");
            return (Criteria) this;
        }

        public Criteria andIamgeBackGreaterThan(String value) {
            addCriterion("iamge_back >", value, "iamgeBack");
            return (Criteria) this;
        }

        public Criteria andIamgeBackGreaterThanOrEqualTo(String value) {
            addCriterion("iamge_back >=", value, "iamgeBack");
            return (Criteria) this;
        }

        public Criteria andIamgeBackLessThan(String value) {
            addCriterion("iamge_back <", value, "iamgeBack");
            return (Criteria) this;
        }

        public Criteria andIamgeBackLessThanOrEqualTo(String value) {
            addCriterion("iamge_back <=", value, "iamgeBack");
            return (Criteria) this;
        }

        public Criteria andIamgeBackLike(String value) {
            addCriterion("iamge_back like", value, "iamgeBack");
            return (Criteria) this;
        }

        public Criteria andIamgeBackNotLike(String value) {
            addCriterion("iamge_back not like", value, "iamgeBack");
            return (Criteria) this;
        }

        public Criteria andIamgeBackIn(List<String> values) {
            addCriterion("iamge_back in", values, "iamgeBack");
            return (Criteria) this;
        }

        public Criteria andIamgeBackNotIn(List<String> values) {
            addCriterion("iamge_back not in", values, "iamgeBack");
            return (Criteria) this;
        }

        public Criteria andIamgeBackBetween(String value1, String value2) {
            addCriterion("iamge_back between", value1, value2, "iamgeBack");
            return (Criteria) this;
        }

        public Criteria andIamgeBackNotBetween(String value1, String value2) {
            addCriterion("iamge_back not between", value1, value2, "iamgeBack");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("parentid is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("parentid is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(Integer value) {
            addCriterion("parentid =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(Integer value) {
            addCriterion("parentid <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(Integer value) {
            addCriterion("parentid >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentid >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(Integer value) {
            addCriterion("parentid <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(Integer value) {
            addCriterion("parentid <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<Integer> values) {
            addCriterion("parentid in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<Integer> values) {
            addCriterion("parentid not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(Integer value1, Integer value2) {
            addCriterion("parentid between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("parentid not between", value1, value2, "parentid");
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