package com.holley.emcpshare.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PpfCustomerFeeMonthDetailOtherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PpfCustomerFeeMonthDetailOtherExample() {
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

        public Criteria andCustomeridIsNull() {
            addCriterion("CUSTOMERID is null");
            return (Criteria) this;
        }

        public Criteria andCustomeridIsNotNull() {
            addCriterion("CUSTOMERID is not null");
            return (Criteria) this;
        }

        public Criteria andCustomeridEqualTo(Integer value) {
            addCriterion("CUSTOMERID =", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridNotEqualTo(Integer value) {
            addCriterion("CUSTOMERID <>", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridGreaterThan(Integer value) {
            addCriterion("CUSTOMERID >", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridGreaterThanOrEqualTo(Integer value) {
            addCriterion("CUSTOMERID >=", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridLessThan(Integer value) {
            addCriterion("CUSTOMERID <", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridLessThanOrEqualTo(Integer value) {
            addCriterion("CUSTOMERID <=", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridIn(List<Integer> values) {
            addCriterion("CUSTOMERID in", values, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridNotIn(List<Integer> values) {
            addCriterion("CUSTOMERID not in", values, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridBetween(Integer value1, Integer value2) {
            addCriterion("CUSTOMERID between", value1, value2, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridNotBetween(Integer value1, Integer value2) {
            addCriterion("CUSTOMERID not between", value1, value2, "customerid");
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

        public Criteria andStarttimeIsNull() {
            addCriterion("STARTTIME is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("STARTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("STARTTIME =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("STARTTIME <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("STARTTIME >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("STARTTIME >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("STARTTIME <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("STARTTIME <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("STARTTIME in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("STARTTIME not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("STARTTIME between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("STARTTIME not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("ENDTIME is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("ENDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("ENDTIME =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("ENDTIME <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("ENDTIME >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ENDTIME >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("ENDTIME <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("ENDTIME <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("ENDTIME in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("ENDTIME not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("ENDTIME between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("ENDTIME not between", value1, value2, "endtime");
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

        public Criteria andFeeIsNull() {
            addCriterion("FEE is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("FEE is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(BigDecimal value) {
            addCriterion("FEE =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(BigDecimal value) {
            addCriterion("FEE <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(BigDecimal value) {
            addCriterion("FEE >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FEE >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(BigDecimal value) {
            addCriterion("FEE <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FEE <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<BigDecimal> values) {
            addCriterion("FEE in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<BigDecimal> values) {
            addCriterion("FEE not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEE between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEE not between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andPercentIsNull() {
            addCriterion("PERCENT is null");
            return (Criteria) this;
        }

        public Criteria andPercentIsNotNull() {
            addCriterion("PERCENT is not null");
            return (Criteria) this;
        }

        public Criteria andPercentEqualTo(Short value) {
            addCriterion("PERCENT =", value, "percent");
            return (Criteria) this;
        }

        public Criteria andPercentNotEqualTo(Short value) {
            addCriterion("PERCENT <>", value, "percent");
            return (Criteria) this;
        }

        public Criteria andPercentGreaterThan(Short value) {
            addCriterion("PERCENT >", value, "percent");
            return (Criteria) this;
        }

        public Criteria andPercentGreaterThanOrEqualTo(Short value) {
            addCriterion("PERCENT >=", value, "percent");
            return (Criteria) this;
        }

        public Criteria andPercentLessThan(Short value) {
            addCriterion("PERCENT <", value, "percent");
            return (Criteria) this;
        }

        public Criteria andPercentLessThanOrEqualTo(Short value) {
            addCriterion("PERCENT <=", value, "percent");
            return (Criteria) this;
        }

        public Criteria andPercentIn(List<Short> values) {
            addCriterion("PERCENT in", values, "percent");
            return (Criteria) this;
        }

        public Criteria andPercentNotIn(List<Short> values) {
            addCriterion("PERCENT not in", values, "percent");
            return (Criteria) this;
        }

        public Criteria andPercentBetween(Short value1, Short value2) {
            addCriterion("PERCENT between", value1, value2, "percent");
            return (Criteria) this;
        }

        public Criteria andPercentNotBetween(Short value1, Short value2) {
            addCriterion("PERCENT not between", value1, value2, "percent");
            return (Criteria) this;
        }

        public Criteria andPriceidIsNull() {
            addCriterion("PRICEID is null");
            return (Criteria) this;
        }

        public Criteria andPriceidIsNotNull() {
            addCriterion("PRICEID is not null");
            return (Criteria) this;
        }

        public Criteria andPriceidEqualTo(Integer value) {
            addCriterion("PRICEID =", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidNotEqualTo(Integer value) {
            addCriterion("PRICEID <>", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidGreaterThan(Integer value) {
            addCriterion("PRICEID >", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRICEID >=", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidLessThan(Integer value) {
            addCriterion("PRICEID <", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidLessThanOrEqualTo(Integer value) {
            addCriterion("PRICEID <=", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidIn(List<Integer> values) {
            addCriterion("PRICEID in", values, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidNotIn(List<Integer> values) {
            addCriterion("PRICEID not in", values, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidBetween(Integer value1, Integer value2) {
            addCriterion("PRICEID between", value1, value2, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidNotBetween(Integer value1, Integer value2) {
            addCriterion("PRICEID not between", value1, value2, "priceid");
            return (Criteria) this;
        }

        public Criteria andStartbmtimeIsNull() {
            addCriterion("STARTBMTIME is null");
            return (Criteria) this;
        }

        public Criteria andStartbmtimeIsNotNull() {
            addCriterion("STARTBMTIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartbmtimeEqualTo(Date value) {
            addCriterion("STARTBMTIME =", value, "startbmtime");
            return (Criteria) this;
        }

        public Criteria andStartbmtimeNotEqualTo(Date value) {
            addCriterion("STARTBMTIME <>", value, "startbmtime");
            return (Criteria) this;
        }

        public Criteria andStartbmtimeGreaterThan(Date value) {
            addCriterion("STARTBMTIME >", value, "startbmtime");
            return (Criteria) this;
        }

        public Criteria andStartbmtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("STARTBMTIME >=", value, "startbmtime");
            return (Criteria) this;
        }

        public Criteria andStartbmtimeLessThan(Date value) {
            addCriterion("STARTBMTIME <", value, "startbmtime");
            return (Criteria) this;
        }

        public Criteria andStartbmtimeLessThanOrEqualTo(Date value) {
            addCriterion("STARTBMTIME <=", value, "startbmtime");
            return (Criteria) this;
        }

        public Criteria andStartbmtimeIn(List<Date> values) {
            addCriterion("STARTBMTIME in", values, "startbmtime");
            return (Criteria) this;
        }

        public Criteria andStartbmtimeNotIn(List<Date> values) {
            addCriterion("STARTBMTIME not in", values, "startbmtime");
            return (Criteria) this;
        }

        public Criteria andStartbmtimeBetween(Date value1, Date value2) {
            addCriterion("STARTBMTIME between", value1, value2, "startbmtime");
            return (Criteria) this;
        }

        public Criteria andStartbmtimeNotBetween(Date value1, Date value2) {
            addCriterion("STARTBMTIME not between", value1, value2, "startbmtime");
            return (Criteria) this;
        }

        public Criteria andStartbmIsNull() {
            addCriterion("STARTBM is null");
            return (Criteria) this;
        }

        public Criteria andStartbmIsNotNull() {
            addCriterion("STARTBM is not null");
            return (Criteria) this;
        }

        public Criteria andStartbmEqualTo(BigDecimal value) {
            addCriterion("STARTBM =", value, "startbm");
            return (Criteria) this;
        }

        public Criteria andStartbmNotEqualTo(BigDecimal value) {
            addCriterion("STARTBM <>", value, "startbm");
            return (Criteria) this;
        }

        public Criteria andStartbmGreaterThan(BigDecimal value) {
            addCriterion("STARTBM >", value, "startbm");
            return (Criteria) this;
        }

        public Criteria andStartbmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBM >=", value, "startbm");
            return (Criteria) this;
        }

        public Criteria andStartbmLessThan(BigDecimal value) {
            addCriterion("STARTBM <", value, "startbm");
            return (Criteria) this;
        }

        public Criteria andStartbmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBM <=", value, "startbm");
            return (Criteria) this;
        }

        public Criteria andStartbmIn(List<BigDecimal> values) {
            addCriterion("STARTBM in", values, "startbm");
            return (Criteria) this;
        }

        public Criteria andStartbmNotIn(List<BigDecimal> values) {
            addCriterion("STARTBM not in", values, "startbm");
            return (Criteria) this;
        }

        public Criteria andStartbmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBM between", value1, value2, "startbm");
            return (Criteria) this;
        }

        public Criteria andStartbmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBM not between", value1, value2, "startbm");
            return (Criteria) this;
        }

        public Criteria andEndbmtimeIsNull() {
            addCriterion("ENDBMTIME is null");
            return (Criteria) this;
        }

        public Criteria andEndbmtimeIsNotNull() {
            addCriterion("ENDBMTIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndbmtimeEqualTo(Date value) {
            addCriterion("ENDBMTIME =", value, "endbmtime");
            return (Criteria) this;
        }

        public Criteria andEndbmtimeNotEqualTo(Date value) {
            addCriterion("ENDBMTIME <>", value, "endbmtime");
            return (Criteria) this;
        }

        public Criteria andEndbmtimeGreaterThan(Date value) {
            addCriterion("ENDBMTIME >", value, "endbmtime");
            return (Criteria) this;
        }

        public Criteria andEndbmtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ENDBMTIME >=", value, "endbmtime");
            return (Criteria) this;
        }

        public Criteria andEndbmtimeLessThan(Date value) {
            addCriterion("ENDBMTIME <", value, "endbmtime");
            return (Criteria) this;
        }

        public Criteria andEndbmtimeLessThanOrEqualTo(Date value) {
            addCriterion("ENDBMTIME <=", value, "endbmtime");
            return (Criteria) this;
        }

        public Criteria andEndbmtimeIn(List<Date> values) {
            addCriterion("ENDBMTIME in", values, "endbmtime");
            return (Criteria) this;
        }

        public Criteria andEndbmtimeNotIn(List<Date> values) {
            addCriterion("ENDBMTIME not in", values, "endbmtime");
            return (Criteria) this;
        }

        public Criteria andEndbmtimeBetween(Date value1, Date value2) {
            addCriterion("ENDBMTIME between", value1, value2, "endbmtime");
            return (Criteria) this;
        }

        public Criteria andEndbmtimeNotBetween(Date value1, Date value2) {
            addCriterion("ENDBMTIME not between", value1, value2, "endbmtime");
            return (Criteria) this;
        }

        public Criteria andEndbmIsNull() {
            addCriterion("ENDBM is null");
            return (Criteria) this;
        }

        public Criteria andEndbmIsNotNull() {
            addCriterion("ENDBM is not null");
            return (Criteria) this;
        }

        public Criteria andEndbmEqualTo(BigDecimal value) {
            addCriterion("ENDBM =", value, "endbm");
            return (Criteria) this;
        }

        public Criteria andEndbmNotEqualTo(BigDecimal value) {
            addCriterion("ENDBM <>", value, "endbm");
            return (Criteria) this;
        }

        public Criteria andEndbmGreaterThan(BigDecimal value) {
            addCriterion("ENDBM >", value, "endbm");
            return (Criteria) this;
        }

        public Criteria andEndbmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBM >=", value, "endbm");
            return (Criteria) this;
        }

        public Criteria andEndbmLessThan(BigDecimal value) {
            addCriterion("ENDBM <", value, "endbm");
            return (Criteria) this;
        }

        public Criteria andEndbmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBM <=", value, "endbm");
            return (Criteria) this;
        }

        public Criteria andEndbmIn(List<BigDecimal> values) {
            addCriterion("ENDBM in", values, "endbm");
            return (Criteria) this;
        }

        public Criteria andEndbmNotIn(List<BigDecimal> values) {
            addCriterion("ENDBM not in", values, "endbm");
            return (Criteria) this;
        }

        public Criteria andEndbmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBM between", value1, value2, "endbm");
            return (Criteria) this;
        }

        public Criteria andEndbmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBM not between", value1, value2, "endbm");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("RATE is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("RATE is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(BigDecimal value) {
            addCriterion("RATE =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(BigDecimal value) {
            addCriterion("RATE <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(BigDecimal value) {
            addCriterion("RATE >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RATE >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(BigDecimal value) {
            addCriterion("RATE <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RATE <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<BigDecimal> values) {
            addCriterion("RATE in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<BigDecimal> values) {
            addCriterion("RATE not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATE between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATE not between", value1, value2, "rate");
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

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("UPDATETIME =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("UPDATETIME <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("UPDATETIME >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATETIME >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("UPDATETIME <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATETIME <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("UPDATETIME in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("UPDATETIME not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("UPDATETIME between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATETIME not between", value1, value2, "updatetime");
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