package com.holley.emcpshare.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatStaPointUsedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DatStaPointUsedExample() {
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

        public Criteria andCircletypeidIsNull() {
            addCriterion("CIRCLETYPEID is null");
            return (Criteria) this;
        }

        public Criteria andCircletypeidIsNotNull() {
            addCriterion("CIRCLETYPEID is not null");
            return (Criteria) this;
        }

        public Criteria andCircletypeidEqualTo(Short value) {
            addCriterion("CIRCLETYPEID =", value, "circletypeid");
            return (Criteria) this;
        }

        public Criteria andCircletypeidNotEqualTo(Short value) {
            addCriterion("CIRCLETYPEID <>", value, "circletypeid");
            return (Criteria) this;
        }

        public Criteria andCircletypeidGreaterThan(Short value) {
            addCriterion("CIRCLETYPEID >", value, "circletypeid");
            return (Criteria) this;
        }

        public Criteria andCircletypeidGreaterThanOrEqualTo(Short value) {
            addCriterion("CIRCLETYPEID >=", value, "circletypeid");
            return (Criteria) this;
        }

        public Criteria andCircletypeidLessThan(Short value) {
            addCriterion("CIRCLETYPEID <", value, "circletypeid");
            return (Criteria) this;
        }

        public Criteria andCircletypeidLessThanOrEqualTo(Short value) {
            addCriterion("CIRCLETYPEID <=", value, "circletypeid");
            return (Criteria) this;
        }

        public Criteria andCircletypeidIn(List<Short> values) {
            addCriterion("CIRCLETYPEID in", values, "circletypeid");
            return (Criteria) this;
        }

        public Criteria andCircletypeidNotIn(List<Short> values) {
            addCriterion("CIRCLETYPEID not in", values, "circletypeid");
            return (Criteria) this;
        }

        public Criteria andCircletypeidBetween(Short value1, Short value2) {
            addCriterion("CIRCLETYPEID between", value1, value2, "circletypeid");
            return (Criteria) this;
        }

        public Criteria andCircletypeidNotBetween(Short value1, Short value2) {
            addCriterion("CIRCLETYPEID not between", value1, value2, "circletypeid");
            return (Criteria) this;
        }

        public Criteria andDatatimeIsNull() {
            addCriterion("DATATIME is null");
            return (Criteria) this;
        }

        public Criteria andDatatimeIsNotNull() {
            addCriterion("DATATIME is not null");
            return (Criteria) this;
        }

        public Criteria andDatatimeEqualTo(Date value) {
            addCriterion("DATATIME =", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeNotEqualTo(Date value) {
            addCriterion("DATATIME <>", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeGreaterThan(Date value) {
            addCriterion("DATATIME >", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DATATIME >=", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeLessThan(Date value) {
            addCriterion("DATATIME <", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeLessThanOrEqualTo(Date value) {
            addCriterion("DATATIME <=", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeIn(List<Date> values) {
            addCriterion("DATATIME in", values, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeNotIn(List<Date> values) {
            addCriterion("DATATIME not in", values, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeBetween(Date value1, Date value2) {
            addCriterion("DATATIME between", value1, value2, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeNotBetween(Date value1, Date value2) {
            addCriterion("DATATIME not between", value1, value2, "datatime");
            return (Criteria) this;
        }

        public Criteria andPointidIsNull() {
            addCriterion("POINTID is null");
            return (Criteria) this;
        }

        public Criteria andPointidIsNotNull() {
            addCriterion("POINTID is not null");
            return (Criteria) this;
        }

        public Criteria andPointidEqualTo(Integer value) {
            addCriterion("POINTID =", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidNotEqualTo(Integer value) {
            addCriterion("POINTID <>", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidGreaterThan(Integer value) {
            addCriterion("POINTID >", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidGreaterThanOrEqualTo(Integer value) {
            addCriterion("POINTID >=", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidLessThan(Integer value) {
            addCriterion("POINTID <", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidLessThanOrEqualTo(Integer value) {
            addCriterion("POINTID <=", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidIn(List<Integer> values) {
            addCriterion("POINTID in", values, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidNotIn(List<Integer> values) {
            addCriterion("POINTID not in", values, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidBetween(Integer value1, Integer value2) {
            addCriterion("POINTID between", value1, value2, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidNotBetween(Integer value1, Integer value2) {
            addCriterion("POINTID not between", value1, value2, "pointid");
            return (Criteria) this;
        }

        public Criteria andUsedIsNull() {
            addCriterion("USED is null");
            return (Criteria) this;
        }

        public Criteria andUsedIsNotNull() {
            addCriterion("USED is not null");
            return (Criteria) this;
        }

        public Criteria andUsedEqualTo(BigDecimal value) {
            addCriterion("USED =", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotEqualTo(BigDecimal value) {
            addCriterion("USED <>", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedGreaterThan(BigDecimal value) {
            addCriterion("USED >", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("USED >=", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedLessThan(BigDecimal value) {
            addCriterion("USED <", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("USED <=", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedIn(List<BigDecimal> values) {
            addCriterion("USED in", values, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotIn(List<BigDecimal> values) {
            addCriterion("USED not in", values, "used");
            return (Criteria) this;
        }

        public Criteria andUsedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED between", value1, value2, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED not between", value1, value2, "used");
            return (Criteria) this;
        }

        public Criteria andPropIsNull() {
            addCriterion("PROP is null");
            return (Criteria) this;
        }

        public Criteria andPropIsNotNull() {
            addCriterion("PROP is not null");
            return (Criteria) this;
        }

        public Criteria andPropEqualTo(Short value) {
            addCriterion("PROP =", value, "prop");
            return (Criteria) this;
        }

        public Criteria andPropNotEqualTo(Short value) {
            addCriterion("PROP <>", value, "prop");
            return (Criteria) this;
        }

        public Criteria andPropGreaterThan(Short value) {
            addCriterion("PROP >", value, "prop");
            return (Criteria) this;
        }

        public Criteria andPropGreaterThanOrEqualTo(Short value) {
            addCriterion("PROP >=", value, "prop");
            return (Criteria) this;
        }

        public Criteria andPropLessThan(Short value) {
            addCriterion("PROP <", value, "prop");
            return (Criteria) this;
        }

        public Criteria andPropLessThanOrEqualTo(Short value) {
            addCriterion("PROP <=", value, "prop");
            return (Criteria) this;
        }

        public Criteria andPropIn(List<Short> values) {
            addCriterion("PROP in", values, "prop");
            return (Criteria) this;
        }

        public Criteria andPropNotIn(List<Short> values) {
            addCriterion("PROP not in", values, "prop");
            return (Criteria) this;
        }

        public Criteria andPropBetween(Short value1, Short value2) {
            addCriterion("PROP between", value1, value2, "prop");
            return (Criteria) this;
        }

        public Criteria andPropNotBetween(Short value1, Short value2) {
            addCriterion("PROP not between", value1, value2, "prop");
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