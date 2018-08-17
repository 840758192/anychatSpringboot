package com.anychat.org.model.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatGroupCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    protected int limitStart = -1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    protected int pageSize = -1;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    public ChatGroupCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    public int getLimitStart() {
        return limitStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    public void setPageSize(int pageSize) {
        this.pageSize=pageSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_group
     *
     * @mbg.generated
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table chat_group
     *
     * @mbg.generated
     */
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

        public Criteria andChatGroupIdIsNull() {
            addCriterion("chat_group_id is null");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdIsNotNull() {
            addCriterion("chat_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdEqualTo(String value) {
            addCriterion("chat_group_id =", value, "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdNotEqualTo(String value) {
            addCriterion("chat_group_id <>", value, "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdGreaterThan(String value) {
            addCriterion("chat_group_id >", value, "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("chat_group_id >=", value, "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdLessThan(String value) {
            addCriterion("chat_group_id <", value, "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdLessThanOrEqualTo(String value) {
            addCriterion("chat_group_id <=", value, "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdLike(String value) {
            addCriterion("chat_group_id like", value, "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdNotLike(String value) {
            addCriterion("chat_group_id not like", value, "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdIn(List<String> values) {
            addCriterion("chat_group_id in", values, "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdNotIn(List<String> values) {
            addCriterion("chat_group_id not in", values, "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdBetween(String value1, String value2) {
            addCriterion("chat_group_id between", value1, value2, "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdNotBetween(String value1, String value2) {
            addCriterion("chat_group_id not between", value1, value2, "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupNameIsNull() {
            addCriterion("chat_group_name is null");
            return (Criteria) this;
        }

        public Criteria andChatGroupNameIsNotNull() {
            addCriterion("chat_group_name is not null");
            return (Criteria) this;
        }

        public Criteria andChatGroupNameEqualTo(String value) {
            addCriterion("chat_group_name =", value, "chatGroupName");
            return (Criteria) this;
        }

        public Criteria andChatGroupNameNotEqualTo(String value) {
            addCriterion("chat_group_name <>", value, "chatGroupName");
            return (Criteria) this;
        }

        public Criteria andChatGroupNameGreaterThan(String value) {
            addCriterion("chat_group_name >", value, "chatGroupName");
            return (Criteria) this;
        }

        public Criteria andChatGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("chat_group_name >=", value, "chatGroupName");
            return (Criteria) this;
        }

        public Criteria andChatGroupNameLessThan(String value) {
            addCriterion("chat_group_name <", value, "chatGroupName");
            return (Criteria) this;
        }

        public Criteria andChatGroupNameLessThanOrEqualTo(String value) {
            addCriterion("chat_group_name <=", value, "chatGroupName");
            return (Criteria) this;
        }

        public Criteria andChatGroupNameLike(String value) {
            addCriterion("chat_group_name like", value, "chatGroupName");
            return (Criteria) this;
        }

        public Criteria andChatGroupNameNotLike(String value) {
            addCriterion("chat_group_name not like", value, "chatGroupName");
            return (Criteria) this;
        }

        public Criteria andChatGroupNameIn(List<String> values) {
            addCriterion("chat_group_name in", values, "chatGroupName");
            return (Criteria) this;
        }

        public Criteria andChatGroupNameNotIn(List<String> values) {
            addCriterion("chat_group_name not in", values, "chatGroupName");
            return (Criteria) this;
        }

        public Criteria andChatGroupNameBetween(String value1, String value2) {
            addCriterion("chat_group_name between", value1, value2, "chatGroupName");
            return (Criteria) this;
        }

        public Criteria andChatGroupNameNotBetween(String value1, String value2) {
            addCriterion("chat_group_name not between", value1, value2, "chatGroupName");
            return (Criteria) this;
        }

        public Criteria andChatGroupCreateTimeIsNull() {
            addCriterion("chat_group_create_time is null");
            return (Criteria) this;
        }

        public Criteria andChatGroupCreateTimeIsNotNull() {
            addCriterion("chat_group_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andChatGroupCreateTimeEqualTo(Date value) {
            addCriterion("chat_group_create_time =", value, "chatGroupCreateTime");
            return (Criteria) this;
        }

        public Criteria andChatGroupCreateTimeNotEqualTo(Date value) {
            addCriterion("chat_group_create_time <>", value, "chatGroupCreateTime");
            return (Criteria) this;
        }

        public Criteria andChatGroupCreateTimeGreaterThan(Date value) {
            addCriterion("chat_group_create_time >", value, "chatGroupCreateTime");
            return (Criteria) this;
        }

        public Criteria andChatGroupCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("chat_group_create_time >=", value, "chatGroupCreateTime");
            return (Criteria) this;
        }

        public Criteria andChatGroupCreateTimeLessThan(Date value) {
            addCriterion("chat_group_create_time <", value, "chatGroupCreateTime");
            return (Criteria) this;
        }

        public Criteria andChatGroupCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("chat_group_create_time <=", value, "chatGroupCreateTime");
            return (Criteria) this;
        }

        public Criteria andChatGroupCreateTimeIn(List<Date> values) {
            addCriterion("chat_group_create_time in", values, "chatGroupCreateTime");
            return (Criteria) this;
        }

        public Criteria andChatGroupCreateTimeNotIn(List<Date> values) {
            addCriterion("chat_group_create_time not in", values, "chatGroupCreateTime");
            return (Criteria) this;
        }

        public Criteria andChatGroupCreateTimeBetween(Date value1, Date value2) {
            addCriterion("chat_group_create_time between", value1, value2, "chatGroupCreateTime");
            return (Criteria) this;
        }

        public Criteria andChatGroupCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("chat_group_create_time not between", value1, value2, "chatGroupCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdIsNull() {
            addCriterion("user_group_id is null");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdIsNotNull() {
            addCriterion("user_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdEqualTo(String value) {
            addCriterion("user_group_id =", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdNotEqualTo(String value) {
            addCriterion("user_group_id <>", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdGreaterThan(String value) {
            addCriterion("user_group_id >", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_group_id >=", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdLessThan(String value) {
            addCriterion("user_group_id <", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdLessThanOrEqualTo(String value) {
            addCriterion("user_group_id <=", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdLike(String value) {
            addCriterion("user_group_id like", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdNotLike(String value) {
            addCriterion("user_group_id not like", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdIn(List<String> values) {
            addCriterion("user_group_id in", values, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdNotIn(List<String> values) {
            addCriterion("user_group_id not in", values, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdBetween(String value1, String value2) {
            addCriterion("user_group_id between", value1, value2, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdNotBetween(String value1, String value2) {
            addCriterion("user_group_id not between", value1, value2, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdLikeInsensitive(String value) {
            addCriterion("upper(chat_group_id) like", value.toUpperCase(), "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupNameLikeInsensitive(String value) {
            addCriterion("upper(chat_group_name) like", value.toUpperCase(), "chatGroupName");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdLikeInsensitive(String value) {
            addCriterion("upper(user_group_id) like", value.toUpperCase(), "userGroupId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table chat_group
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table chat_group
     *
     * @mbg.generated
     */
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