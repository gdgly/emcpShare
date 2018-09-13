package com.holley.emcpshare.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatBmRealExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DatBmRealExample() {
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

        public Criteria andDataitemIsNull() {
            addCriterion("DATAITEM is null");
            return (Criteria) this;
        }

        public Criteria andDataitemIsNotNull() {
            addCriterion("DATAITEM is not null");
            return (Criteria) this;
        }

        public Criteria andDataitemEqualTo(Short value) {
            addCriterion("DATAITEM =", value, "dataitem");
            return (Criteria) this;
        }

        public Criteria andDataitemNotEqualTo(Short value) {
            addCriterion("DATAITEM <>", value, "dataitem");
            return (Criteria) this;
        }

        public Criteria andDataitemGreaterThan(Short value) {
            addCriterion("DATAITEM >", value, "dataitem");
            return (Criteria) this;
        }

        public Criteria andDataitemGreaterThanOrEqualTo(Short value) {
            addCriterion("DATAITEM >=", value, "dataitem");
            return (Criteria) this;
        }

        public Criteria andDataitemLessThan(Short value) {
            addCriterion("DATAITEM <", value, "dataitem");
            return (Criteria) this;
        }

        public Criteria andDataitemLessThanOrEqualTo(Short value) {
            addCriterion("DATAITEM <=", value, "dataitem");
            return (Criteria) this;
        }

        public Criteria andDataitemIn(List<Short> values) {
            addCriterion("DATAITEM in", values, "dataitem");
            return (Criteria) this;
        }

        public Criteria andDataitemNotIn(List<Short> values) {
            addCriterion("DATAITEM not in", values, "dataitem");
            return (Criteria) this;
        }

        public Criteria andDataitemBetween(Short value1, Short value2) {
            addCriterion("DATAITEM between", value1, value2, "dataitem");
            return (Criteria) this;
        }

        public Criteria andDataitemNotBetween(Short value1, Short value2) {
            addCriterion("DATAITEM not between", value1, value2, "dataitem");
            return (Criteria) this;
        }

        public Criteria andEnergytypeIsNull() {
            addCriterion("ENERGYTYPE is null");
            return (Criteria) this;
        }

        public Criteria andEnergytypeIsNotNull() {
            addCriterion("ENERGYTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andEnergytypeEqualTo(Short value) {
            addCriterion("ENERGYTYPE =", value, "energytype");
            return (Criteria) this;
        }

        public Criteria andEnergytypeNotEqualTo(Short value) {
            addCriterion("ENERGYTYPE <>", value, "energytype");
            return (Criteria) this;
        }

        public Criteria andEnergytypeGreaterThan(Short value) {
            addCriterion("ENERGYTYPE >", value, "energytype");
            return (Criteria) this;
        }

        public Criteria andEnergytypeGreaterThanOrEqualTo(Short value) {
            addCriterion("ENERGYTYPE >=", value, "energytype");
            return (Criteria) this;
        }

        public Criteria andEnergytypeLessThan(Short value) {
            addCriterion("ENERGYTYPE <", value, "energytype");
            return (Criteria) this;
        }

        public Criteria andEnergytypeLessThanOrEqualTo(Short value) {
            addCriterion("ENERGYTYPE <=", value, "energytype");
            return (Criteria) this;
        }

        public Criteria andEnergytypeIn(List<Short> values) {
            addCriterion("ENERGYTYPE in", values, "energytype");
            return (Criteria) this;
        }

        public Criteria andEnergytypeNotIn(List<Short> values) {
            addCriterion("ENERGYTYPE not in", values, "energytype");
            return (Criteria) this;
        }

        public Criteria andEnergytypeBetween(Short value1, Short value2) {
            addCriterion("ENERGYTYPE between", value1, value2, "energytype");
            return (Criteria) this;
        }

        public Criteria andEnergytypeNotBetween(Short value1, Short value2) {
            addCriterion("ENERGYTYPE not between", value1, value2, "energytype");
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

        public Criteria andBmIsNull() {
            addCriterion("BM is null");
            return (Criteria) this;
        }

        public Criteria andBmIsNotNull() {
            addCriterion("BM is not null");
            return (Criteria) this;
        }

        public Criteria andBmEqualTo(BigDecimal value) {
            addCriterion("BM =", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmNotEqualTo(BigDecimal value) {
            addCriterion("BM <>", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmGreaterThan(BigDecimal value) {
            addCriterion("BM >", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BM >=", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmLessThan(BigDecimal value) {
            addCriterion("BM <", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BM <=", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmIn(List<BigDecimal> values) {
            addCriterion("BM in", values, "bm");
            return (Criteria) this;
        }

        public Criteria andBmNotIn(List<BigDecimal> values) {
            addCriterion("BM not in", values, "bm");
            return (Criteria) this;
        }

        public Criteria andBmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BM between", value1, value2, "bm");
            return (Criteria) this;
        }

        public Criteria andBmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BM not between", value1, value2, "bm");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeIsNull() {
            addCriterion("OLDDATATIME is null");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeIsNotNull() {
            addCriterion("OLDDATATIME is not null");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeEqualTo(Date value) {
            addCriterion("OLDDATATIME =", value, "olddatatime");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeNotEqualTo(Date value) {
            addCriterion("OLDDATATIME <>", value, "olddatatime");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeGreaterThan(Date value) {
            addCriterion("OLDDATATIME >", value, "olddatatime");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OLDDATATIME >=", value, "olddatatime");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeLessThan(Date value) {
            addCriterion("OLDDATATIME <", value, "olddatatime");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeLessThanOrEqualTo(Date value) {
            addCriterion("OLDDATATIME <=", value, "olddatatime");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeIn(List<Date> values) {
            addCriterion("OLDDATATIME in", values, "olddatatime");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeNotIn(List<Date> values) {
            addCriterion("OLDDATATIME not in", values, "olddatatime");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeBetween(Date value1, Date value2) {
            addCriterion("OLDDATATIME between", value1, value2, "olddatatime");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeNotBetween(Date value1, Date value2) {
            addCriterion("OLDDATATIME not between", value1, value2, "olddatatime");
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