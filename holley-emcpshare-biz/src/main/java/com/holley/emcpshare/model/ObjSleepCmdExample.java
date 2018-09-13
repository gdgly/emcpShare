package com.holley.emcpshare.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjSleepCmdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ObjSleepCmdExample() {
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

        public Criteria andCmdtypeIsNull() {
            addCriterion("CMDTYPE is null");
            return (Criteria) this;
        }

        public Criteria andCmdtypeIsNotNull() {
            addCriterion("CMDTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCmdtypeEqualTo(Short value) {
            addCriterion("CMDTYPE =", value, "cmdtype");
            return (Criteria) this;
        }

        public Criteria andCmdtypeNotEqualTo(Short value) {
            addCriterion("CMDTYPE <>", value, "cmdtype");
            return (Criteria) this;
        }

        public Criteria andCmdtypeGreaterThan(Short value) {
            addCriterion("CMDTYPE >", value, "cmdtype");
            return (Criteria) this;
        }

        public Criteria andCmdtypeGreaterThanOrEqualTo(Short value) {
            addCriterion("CMDTYPE >=", value, "cmdtype");
            return (Criteria) this;
        }

        public Criteria andCmdtypeLessThan(Short value) {
            addCriterion("CMDTYPE <", value, "cmdtype");
            return (Criteria) this;
        }

        public Criteria andCmdtypeLessThanOrEqualTo(Short value) {
            addCriterion("CMDTYPE <=", value, "cmdtype");
            return (Criteria) this;
        }

        public Criteria andCmdtypeIn(List<Short> values) {
            addCriterion("CMDTYPE in", values, "cmdtype");
            return (Criteria) this;
        }

        public Criteria andCmdtypeNotIn(List<Short> values) {
            addCriterion("CMDTYPE not in", values, "cmdtype");
            return (Criteria) this;
        }

        public Criteria andCmdtypeBetween(Short value1, Short value2) {
            addCriterion("CMDTYPE between", value1, value2, "cmdtype");
            return (Criteria) this;
        }

        public Criteria andCmdtypeNotBetween(Short value1, Short value2) {
            addCriterion("CMDTYPE not between", value1, value2, "cmdtype");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CREATETIME =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CREATETIME <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CREATETIME >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATETIME >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CREATETIME <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATETIME <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CREATETIME in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CREATETIME not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CREATETIME between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATETIME not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andObjidIsNull() {
            addCriterion("OBJID is null");
            return (Criteria) this;
        }

        public Criteria andObjidIsNotNull() {
            addCriterion("OBJID is not null");
            return (Criteria) this;
        }

        public Criteria andObjidEqualTo(Integer value) {
            addCriterion("OBJID =", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidNotEqualTo(Integer value) {
            addCriterion("OBJID <>", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidGreaterThan(Integer value) {
            addCriterion("OBJID >", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidGreaterThanOrEqualTo(Integer value) {
            addCriterion("OBJID >=", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidLessThan(Integer value) {
            addCriterion("OBJID <", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidLessThanOrEqualTo(Integer value) {
            addCriterion("OBJID <=", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidIn(List<Integer> values) {
            addCriterion("OBJID in", values, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidNotIn(List<Integer> values) {
            addCriterion("OBJID not in", values, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidBetween(Integer value1, Integer value2) {
            addCriterion("OBJID between", value1, value2, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidNotBetween(Integer value1, Integer value2) {
            addCriterion("OBJID not between", value1, value2, "objid");
            return (Criteria) this;
        }

        public Criteria andObjtypeIsNull() {
            addCriterion("OBJTYPE is null");
            return (Criteria) this;
        }

        public Criteria andObjtypeIsNotNull() {
            addCriterion("OBJTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andObjtypeEqualTo(Short value) {
            addCriterion("OBJTYPE =", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeNotEqualTo(Short value) {
            addCriterion("OBJTYPE <>", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeGreaterThan(Short value) {
            addCriterion("OBJTYPE >", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeGreaterThanOrEqualTo(Short value) {
            addCriterion("OBJTYPE >=", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeLessThan(Short value) {
            addCriterion("OBJTYPE <", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeLessThanOrEqualTo(Short value) {
            addCriterion("OBJTYPE <=", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeIn(List<Short> values) {
            addCriterion("OBJTYPE in", values, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeNotIn(List<Short> values) {
            addCriterion("OBJTYPE not in", values, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeBetween(Short value1, Short value2) {
            addCriterion("OBJTYPE between", value1, value2, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeNotBetween(Short value1, Short value2) {
            addCriterion("OBJTYPE not between", value1, value2, "objtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeIsNull() {
            addCriterion("SENDTYPE is null");
            return (Criteria) this;
        }

        public Criteria andSendtypeIsNotNull() {
            addCriterion("SENDTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSendtypeEqualTo(Short value) {
            addCriterion("SENDTYPE =", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotEqualTo(Short value) {
            addCriterion("SENDTYPE <>", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeGreaterThan(Short value) {
            addCriterion("SENDTYPE >", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeGreaterThanOrEqualTo(Short value) {
            addCriterion("SENDTYPE >=", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeLessThan(Short value) {
            addCriterion("SENDTYPE <", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeLessThanOrEqualTo(Short value) {
            addCriterion("SENDTYPE <=", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeIn(List<Short> values) {
            addCriterion("SENDTYPE in", values, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotIn(List<Short> values) {
            addCriterion("SENDTYPE not in", values, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeBetween(Short value1, Short value2) {
            addCriterion("SENDTYPE between", value1, value2, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotBetween(Short value1, Short value2) {
            addCriterion("SENDTYPE not between", value1, value2, "sendtype");
            return (Criteria) this;
        }

        public Criteria andParamsIsNull() {
            addCriterion("PARAMS is null");
            return (Criteria) this;
        }

        public Criteria andParamsIsNotNull() {
            addCriterion("PARAMS is not null");
            return (Criteria) this;
        }

        public Criteria andParamsEqualTo(String value) {
            addCriterion("PARAMS =", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotEqualTo(String value) {
            addCriterion("PARAMS <>", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsGreaterThan(String value) {
            addCriterion("PARAMS >", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsGreaterThanOrEqualTo(String value) {
            addCriterion("PARAMS >=", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLessThan(String value) {
            addCriterion("PARAMS <", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLessThanOrEqualTo(String value) {
            addCriterion("PARAMS <=", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLike(String value) {
            addCriterion("PARAMS like", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotLike(String value) {
            addCriterion("PARAMS not like", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsIn(List<String> values) {
            addCriterion("PARAMS in", values, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotIn(List<String> values) {
            addCriterion("PARAMS not in", values, "params");
            return (Criteria) this;
        }

        public Criteria andParamsBetween(String value1, String value2) {
            addCriterion("PARAMS between", value1, value2, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotBetween(String value1, String value2) {
            addCriterion("PARAMS not between", value1, value2, "params");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andExecutetimeIsNull() {
            addCriterion("EXECUTETIME is null");
            return (Criteria) this;
        }

        public Criteria andExecutetimeIsNotNull() {
            addCriterion("EXECUTETIME is not null");
            return (Criteria) this;
        }

        public Criteria andExecutetimeEqualTo(Date value) {
            addCriterion("EXECUTETIME =", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeNotEqualTo(Date value) {
            addCriterion("EXECUTETIME <>", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeGreaterThan(Date value) {
            addCriterion("EXECUTETIME >", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EXECUTETIME >=", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeLessThan(Date value) {
            addCriterion("EXECUTETIME <", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeLessThanOrEqualTo(Date value) {
            addCriterion("EXECUTETIME <=", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeIn(List<Date> values) {
            addCriterion("EXECUTETIME in", values, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeNotIn(List<Date> values) {
            addCriterion("EXECUTETIME not in", values, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeBetween(Date value1, Date value2) {
            addCriterion("EXECUTETIME between", value1, value2, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeNotBetween(Date value1, Date value2) {
            addCriterion("EXECUTETIME not between", value1, value2, "executetime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
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