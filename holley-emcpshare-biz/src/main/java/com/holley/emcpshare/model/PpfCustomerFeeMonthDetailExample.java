package com.holley.emcpshare.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PpfCustomerFeeMonthDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PpfCustomerFeeMonthDetailExample() {
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

        public Criteria andEnergyzongIsNull() {
            addCriterion("ENERGYZONG is null");
            return (Criteria) this;
        }

        public Criteria andEnergyzongIsNotNull() {
            addCriterion("ENERGYZONG is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyzongEqualTo(BigDecimal value) {
            addCriterion("ENERGYZONG =", value, "energyzong");
            return (Criteria) this;
        }

        public Criteria andEnergyzongNotEqualTo(BigDecimal value) {
            addCriterion("ENERGYZONG <>", value, "energyzong");
            return (Criteria) this;
        }

        public Criteria andEnergyzongGreaterThan(BigDecimal value) {
            addCriterion("ENERGYZONG >", value, "energyzong");
            return (Criteria) this;
        }

        public Criteria andEnergyzongGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENERGYZONG >=", value, "energyzong");
            return (Criteria) this;
        }

        public Criteria andEnergyzongLessThan(BigDecimal value) {
            addCriterion("ENERGYZONG <", value, "energyzong");
            return (Criteria) this;
        }

        public Criteria andEnergyzongLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENERGYZONG <=", value, "energyzong");
            return (Criteria) this;
        }

        public Criteria andEnergyzongIn(List<BigDecimal> values) {
            addCriterion("ENERGYZONG in", values, "energyzong");
            return (Criteria) this;
        }

        public Criteria andEnergyzongNotIn(List<BigDecimal> values) {
            addCriterion("ENERGYZONG not in", values, "energyzong");
            return (Criteria) this;
        }

        public Criteria andEnergyzongBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENERGYZONG between", value1, value2, "energyzong");
            return (Criteria) this;
        }

        public Criteria andEnergyzongNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENERGYZONG not between", value1, value2, "energyzong");
            return (Criteria) this;
        }

        public Criteria andEnergyjianIsNull() {
            addCriterion("ENERGYJIAN is null");
            return (Criteria) this;
        }

        public Criteria andEnergyjianIsNotNull() {
            addCriterion("ENERGYJIAN is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyjianEqualTo(BigDecimal value) {
            addCriterion("ENERGYJIAN =", value, "energyjian");
            return (Criteria) this;
        }

        public Criteria andEnergyjianNotEqualTo(BigDecimal value) {
            addCriterion("ENERGYJIAN <>", value, "energyjian");
            return (Criteria) this;
        }

        public Criteria andEnergyjianGreaterThan(BigDecimal value) {
            addCriterion("ENERGYJIAN >", value, "energyjian");
            return (Criteria) this;
        }

        public Criteria andEnergyjianGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENERGYJIAN >=", value, "energyjian");
            return (Criteria) this;
        }

        public Criteria andEnergyjianLessThan(BigDecimal value) {
            addCriterion("ENERGYJIAN <", value, "energyjian");
            return (Criteria) this;
        }

        public Criteria andEnergyjianLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENERGYJIAN <=", value, "energyjian");
            return (Criteria) this;
        }

        public Criteria andEnergyjianIn(List<BigDecimal> values) {
            addCriterion("ENERGYJIAN in", values, "energyjian");
            return (Criteria) this;
        }

        public Criteria andEnergyjianNotIn(List<BigDecimal> values) {
            addCriterion("ENERGYJIAN not in", values, "energyjian");
            return (Criteria) this;
        }

        public Criteria andEnergyjianBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENERGYJIAN between", value1, value2, "energyjian");
            return (Criteria) this;
        }

        public Criteria andEnergyjianNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENERGYJIAN not between", value1, value2, "energyjian");
            return (Criteria) this;
        }

        public Criteria andEnergyfengIsNull() {
            addCriterion("ENERGYFENG is null");
            return (Criteria) this;
        }

        public Criteria andEnergyfengIsNotNull() {
            addCriterion("ENERGYFENG is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyfengEqualTo(BigDecimal value) {
            addCriterion("ENERGYFENG =", value, "energyfeng");
            return (Criteria) this;
        }

        public Criteria andEnergyfengNotEqualTo(BigDecimal value) {
            addCriterion("ENERGYFENG <>", value, "energyfeng");
            return (Criteria) this;
        }

        public Criteria andEnergyfengGreaterThan(BigDecimal value) {
            addCriterion("ENERGYFENG >", value, "energyfeng");
            return (Criteria) this;
        }

        public Criteria andEnergyfengGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENERGYFENG >=", value, "energyfeng");
            return (Criteria) this;
        }

        public Criteria andEnergyfengLessThan(BigDecimal value) {
            addCriterion("ENERGYFENG <", value, "energyfeng");
            return (Criteria) this;
        }

        public Criteria andEnergyfengLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENERGYFENG <=", value, "energyfeng");
            return (Criteria) this;
        }

        public Criteria andEnergyfengIn(List<BigDecimal> values) {
            addCriterion("ENERGYFENG in", values, "energyfeng");
            return (Criteria) this;
        }

        public Criteria andEnergyfengNotIn(List<BigDecimal> values) {
            addCriterion("ENERGYFENG not in", values, "energyfeng");
            return (Criteria) this;
        }

        public Criteria andEnergyfengBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENERGYFENG between", value1, value2, "energyfeng");
            return (Criteria) this;
        }

        public Criteria andEnergyfengNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENERGYFENG not between", value1, value2, "energyfeng");
            return (Criteria) this;
        }

        public Criteria andEnergypingIsNull() {
            addCriterion("ENERGYPING is null");
            return (Criteria) this;
        }

        public Criteria andEnergypingIsNotNull() {
            addCriterion("ENERGYPING is not null");
            return (Criteria) this;
        }

        public Criteria andEnergypingEqualTo(BigDecimal value) {
            addCriterion("ENERGYPING =", value, "energyping");
            return (Criteria) this;
        }

        public Criteria andEnergypingNotEqualTo(BigDecimal value) {
            addCriterion("ENERGYPING <>", value, "energyping");
            return (Criteria) this;
        }

        public Criteria andEnergypingGreaterThan(BigDecimal value) {
            addCriterion("ENERGYPING >", value, "energyping");
            return (Criteria) this;
        }

        public Criteria andEnergypingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENERGYPING >=", value, "energyping");
            return (Criteria) this;
        }

        public Criteria andEnergypingLessThan(BigDecimal value) {
            addCriterion("ENERGYPING <", value, "energyping");
            return (Criteria) this;
        }

        public Criteria andEnergypingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENERGYPING <=", value, "energyping");
            return (Criteria) this;
        }

        public Criteria andEnergypingIn(List<BigDecimal> values) {
            addCriterion("ENERGYPING in", values, "energyping");
            return (Criteria) this;
        }

        public Criteria andEnergypingNotIn(List<BigDecimal> values) {
            addCriterion("ENERGYPING not in", values, "energyping");
            return (Criteria) this;
        }

        public Criteria andEnergypingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENERGYPING between", value1, value2, "energyping");
            return (Criteria) this;
        }

        public Criteria andEnergypingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENERGYPING not between", value1, value2, "energyping");
            return (Criteria) this;
        }

        public Criteria andEnergyguIsNull() {
            addCriterion("ENERGYGU is null");
            return (Criteria) this;
        }

        public Criteria andEnergyguIsNotNull() {
            addCriterion("ENERGYGU is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyguEqualTo(BigDecimal value) {
            addCriterion("ENERGYGU =", value, "energygu");
            return (Criteria) this;
        }

        public Criteria andEnergyguNotEqualTo(BigDecimal value) {
            addCriterion("ENERGYGU <>", value, "energygu");
            return (Criteria) this;
        }

        public Criteria andEnergyguGreaterThan(BigDecimal value) {
            addCriterion("ENERGYGU >", value, "energygu");
            return (Criteria) this;
        }

        public Criteria andEnergyguGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENERGYGU >=", value, "energygu");
            return (Criteria) this;
        }

        public Criteria andEnergyguLessThan(BigDecimal value) {
            addCriterion("ENERGYGU <", value, "energygu");
            return (Criteria) this;
        }

        public Criteria andEnergyguLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENERGYGU <=", value, "energygu");
            return (Criteria) this;
        }

        public Criteria andEnergyguIn(List<BigDecimal> values) {
            addCriterion("ENERGYGU in", values, "energygu");
            return (Criteria) this;
        }

        public Criteria andEnergyguNotIn(List<BigDecimal> values) {
            addCriterion("ENERGYGU not in", values, "energygu");
            return (Criteria) this;
        }

        public Criteria andEnergyguBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENERGYGU between", value1, value2, "energygu");
            return (Criteria) this;
        }

        public Criteria andEnergyguNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENERGYGU not between", value1, value2, "energygu");
            return (Criteria) this;
        }

        public Criteria andEnergyzongqIsNull() {
            addCriterion("ENERGYZONGQ is null");
            return (Criteria) this;
        }

        public Criteria andEnergyzongqIsNotNull() {
            addCriterion("ENERGYZONGQ is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyzongqEqualTo(BigDecimal value) {
            addCriterion("ENERGYZONGQ =", value, "energyzongq");
            return (Criteria) this;
        }

        public Criteria andEnergyzongqNotEqualTo(BigDecimal value) {
            addCriterion("ENERGYZONGQ <>", value, "energyzongq");
            return (Criteria) this;
        }

        public Criteria andEnergyzongqGreaterThan(BigDecimal value) {
            addCriterion("ENERGYZONGQ >", value, "energyzongq");
            return (Criteria) this;
        }

        public Criteria andEnergyzongqGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENERGYZONGQ >=", value, "energyzongq");
            return (Criteria) this;
        }

        public Criteria andEnergyzongqLessThan(BigDecimal value) {
            addCriterion("ENERGYZONGQ <", value, "energyzongq");
            return (Criteria) this;
        }

        public Criteria andEnergyzongqLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENERGYZONGQ <=", value, "energyzongq");
            return (Criteria) this;
        }

        public Criteria andEnergyzongqIn(List<BigDecimal> values) {
            addCriterion("ENERGYZONGQ in", values, "energyzongq");
            return (Criteria) this;
        }

        public Criteria andEnergyzongqNotIn(List<BigDecimal> values) {
            addCriterion("ENERGYZONGQ not in", values, "energyzongq");
            return (Criteria) this;
        }

        public Criteria andEnergyzongqBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENERGYZONGQ between", value1, value2, "energyzongq");
            return (Criteria) this;
        }

        public Criteria andEnergyzongqNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENERGYZONGQ not between", value1, value2, "energyzongq");
            return (Criteria) this;
        }

        public Criteria andActualfeeIsNull() {
            addCriterion("ACTUALFEE is null");
            return (Criteria) this;
        }

        public Criteria andActualfeeIsNotNull() {
            addCriterion("ACTUALFEE is not null");
            return (Criteria) this;
        }

        public Criteria andActualfeeEqualTo(BigDecimal value) {
            addCriterion("ACTUALFEE =", value, "actualfee");
            return (Criteria) this;
        }

        public Criteria andActualfeeNotEqualTo(BigDecimal value) {
            addCriterion("ACTUALFEE <>", value, "actualfee");
            return (Criteria) this;
        }

        public Criteria andActualfeeGreaterThan(BigDecimal value) {
            addCriterion("ACTUALFEE >", value, "actualfee");
            return (Criteria) this;
        }

        public Criteria andActualfeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUALFEE >=", value, "actualfee");
            return (Criteria) this;
        }

        public Criteria andActualfeeLessThan(BigDecimal value) {
            addCriterion("ACTUALFEE <", value, "actualfee");
            return (Criteria) this;
        }

        public Criteria andActualfeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUALFEE <=", value, "actualfee");
            return (Criteria) this;
        }

        public Criteria andActualfeeIn(List<BigDecimal> values) {
            addCriterion("ACTUALFEE in", values, "actualfee");
            return (Criteria) this;
        }

        public Criteria andActualfeeNotIn(List<BigDecimal> values) {
            addCriterion("ACTUALFEE not in", values, "actualfee");
            return (Criteria) this;
        }

        public Criteria andActualfeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUALFEE between", value1, value2, "actualfee");
            return (Criteria) this;
        }

        public Criteria andActualfeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUALFEE not between", value1, value2, "actualfee");
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

        public Criteria andBasefeeIsNull() {
            addCriterion("BASEFEE is null");
            return (Criteria) this;
        }

        public Criteria andBasefeeIsNotNull() {
            addCriterion("BASEFEE is not null");
            return (Criteria) this;
        }

        public Criteria andBasefeeEqualTo(BigDecimal value) {
            addCriterion("BASEFEE =", value, "basefee");
            return (Criteria) this;
        }

        public Criteria andBasefeeNotEqualTo(BigDecimal value) {
            addCriterion("BASEFEE <>", value, "basefee");
            return (Criteria) this;
        }

        public Criteria andBasefeeGreaterThan(BigDecimal value) {
            addCriterion("BASEFEE >", value, "basefee");
            return (Criteria) this;
        }

        public Criteria andBasefeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BASEFEE >=", value, "basefee");
            return (Criteria) this;
        }

        public Criteria andBasefeeLessThan(BigDecimal value) {
            addCriterion("BASEFEE <", value, "basefee");
            return (Criteria) this;
        }

        public Criteria andBasefeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BASEFEE <=", value, "basefee");
            return (Criteria) this;
        }

        public Criteria andBasefeeIn(List<BigDecimal> values) {
            addCriterion("BASEFEE in", values, "basefee");
            return (Criteria) this;
        }

        public Criteria andBasefeeNotIn(List<BigDecimal> values) {
            addCriterion("BASEFEE not in", values, "basefee");
            return (Criteria) this;
        }

        public Criteria andBasefeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BASEFEE between", value1, value2, "basefee");
            return (Criteria) this;
        }

        public Criteria andBasefeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BASEFEE not between", value1, value2, "basefee");
            return (Criteria) this;
        }

        public Criteria andFundfeeIsNull() {
            addCriterion("FUNDFEE is null");
            return (Criteria) this;
        }

        public Criteria andFundfeeIsNotNull() {
            addCriterion("FUNDFEE is not null");
            return (Criteria) this;
        }

        public Criteria andFundfeeEqualTo(BigDecimal value) {
            addCriterion("FUNDFEE =", value, "fundfee");
            return (Criteria) this;
        }

        public Criteria andFundfeeNotEqualTo(BigDecimal value) {
            addCriterion("FUNDFEE <>", value, "fundfee");
            return (Criteria) this;
        }

        public Criteria andFundfeeGreaterThan(BigDecimal value) {
            addCriterion("FUNDFEE >", value, "fundfee");
            return (Criteria) this;
        }

        public Criteria andFundfeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FUNDFEE >=", value, "fundfee");
            return (Criteria) this;
        }

        public Criteria andFundfeeLessThan(BigDecimal value) {
            addCriterion("FUNDFEE <", value, "fundfee");
            return (Criteria) this;
        }

        public Criteria andFundfeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FUNDFEE <=", value, "fundfee");
            return (Criteria) this;
        }

        public Criteria andFundfeeIn(List<BigDecimal> values) {
            addCriterion("FUNDFEE in", values, "fundfee");
            return (Criteria) this;
        }

        public Criteria andFundfeeNotIn(List<BigDecimal> values) {
            addCriterion("FUNDFEE not in", values, "fundfee");
            return (Criteria) this;
        }

        public Criteria andFundfeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FUNDFEE between", value1, value2, "fundfee");
            return (Criteria) this;
        }

        public Criteria andFundfeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FUNDFEE not between", value1, value2, "fundfee");
            return (Criteria) this;
        }

        public Criteria andPffeeIsNull() {
            addCriterion("PFFEE is null");
            return (Criteria) this;
        }

        public Criteria andPffeeIsNotNull() {
            addCriterion("PFFEE is not null");
            return (Criteria) this;
        }

        public Criteria andPffeeEqualTo(BigDecimal value) {
            addCriterion("PFFEE =", value, "pffee");
            return (Criteria) this;
        }

        public Criteria andPffeeNotEqualTo(BigDecimal value) {
            addCriterion("PFFEE <>", value, "pffee");
            return (Criteria) this;
        }

        public Criteria andPffeeGreaterThan(BigDecimal value) {
            addCriterion("PFFEE >", value, "pffee");
            return (Criteria) this;
        }

        public Criteria andPffeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PFFEE >=", value, "pffee");
            return (Criteria) this;
        }

        public Criteria andPffeeLessThan(BigDecimal value) {
            addCriterion("PFFEE <", value, "pffee");
            return (Criteria) this;
        }

        public Criteria andPffeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PFFEE <=", value, "pffee");
            return (Criteria) this;
        }

        public Criteria andPffeeIn(List<BigDecimal> values) {
            addCriterion("PFFEE in", values, "pffee");
            return (Criteria) this;
        }

        public Criteria andPffeeNotIn(List<BigDecimal> values) {
            addCriterion("PFFEE not in", values, "pffee");
            return (Criteria) this;
        }

        public Criteria andPffeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PFFEE between", value1, value2, "pffee");
            return (Criteria) this;
        }

        public Criteria andPffeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PFFEE not between", value1, value2, "pffee");
            return (Criteria) this;
        }

        public Criteria andFund1IsNull() {
            addCriterion("FUND1 is null");
            return (Criteria) this;
        }

        public Criteria andFund1IsNotNull() {
            addCriterion("FUND1 is not null");
            return (Criteria) this;
        }

        public Criteria andFund1EqualTo(BigDecimal value) {
            addCriterion("FUND1 =", value, "fund1");
            return (Criteria) this;
        }

        public Criteria andFund1NotEqualTo(BigDecimal value) {
            addCriterion("FUND1 <>", value, "fund1");
            return (Criteria) this;
        }

        public Criteria andFund1GreaterThan(BigDecimal value) {
            addCriterion("FUND1 >", value, "fund1");
            return (Criteria) this;
        }

        public Criteria andFund1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FUND1 >=", value, "fund1");
            return (Criteria) this;
        }

        public Criteria andFund1LessThan(BigDecimal value) {
            addCriterion("FUND1 <", value, "fund1");
            return (Criteria) this;
        }

        public Criteria andFund1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("FUND1 <=", value, "fund1");
            return (Criteria) this;
        }

        public Criteria andFund1In(List<BigDecimal> values) {
            addCriterion("FUND1 in", values, "fund1");
            return (Criteria) this;
        }

        public Criteria andFund1NotIn(List<BigDecimal> values) {
            addCriterion("FUND1 not in", values, "fund1");
            return (Criteria) this;
        }

        public Criteria andFund1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("FUND1 between", value1, value2, "fund1");
            return (Criteria) this;
        }

        public Criteria andFund1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FUND1 not between", value1, value2, "fund1");
            return (Criteria) this;
        }

        public Criteria andFund2IsNull() {
            addCriterion("FUND2 is null");
            return (Criteria) this;
        }

        public Criteria andFund2IsNotNull() {
            addCriterion("FUND2 is not null");
            return (Criteria) this;
        }

        public Criteria andFund2EqualTo(BigDecimal value) {
            addCriterion("FUND2 =", value, "fund2");
            return (Criteria) this;
        }

        public Criteria andFund2NotEqualTo(BigDecimal value) {
            addCriterion("FUND2 <>", value, "fund2");
            return (Criteria) this;
        }

        public Criteria andFund2GreaterThan(BigDecimal value) {
            addCriterion("FUND2 >", value, "fund2");
            return (Criteria) this;
        }

        public Criteria andFund2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FUND2 >=", value, "fund2");
            return (Criteria) this;
        }

        public Criteria andFund2LessThan(BigDecimal value) {
            addCriterion("FUND2 <", value, "fund2");
            return (Criteria) this;
        }

        public Criteria andFund2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("FUND2 <=", value, "fund2");
            return (Criteria) this;
        }

        public Criteria andFund2In(List<BigDecimal> values) {
            addCriterion("FUND2 in", values, "fund2");
            return (Criteria) this;
        }

        public Criteria andFund2NotIn(List<BigDecimal> values) {
            addCriterion("FUND2 not in", values, "fund2");
            return (Criteria) this;
        }

        public Criteria andFund2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("FUND2 between", value1, value2, "fund2");
            return (Criteria) this;
        }

        public Criteria andFund2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FUND2 not between", value1, value2, "fund2");
            return (Criteria) this;
        }

        public Criteria andFund3IsNull() {
            addCriterion("FUND3 is null");
            return (Criteria) this;
        }

        public Criteria andFund3IsNotNull() {
            addCriterion("FUND3 is not null");
            return (Criteria) this;
        }

        public Criteria andFund3EqualTo(BigDecimal value) {
            addCriterion("FUND3 =", value, "fund3");
            return (Criteria) this;
        }

        public Criteria andFund3NotEqualTo(BigDecimal value) {
            addCriterion("FUND3 <>", value, "fund3");
            return (Criteria) this;
        }

        public Criteria andFund3GreaterThan(BigDecimal value) {
            addCriterion("FUND3 >", value, "fund3");
            return (Criteria) this;
        }

        public Criteria andFund3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FUND3 >=", value, "fund3");
            return (Criteria) this;
        }

        public Criteria andFund3LessThan(BigDecimal value) {
            addCriterion("FUND3 <", value, "fund3");
            return (Criteria) this;
        }

        public Criteria andFund3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("FUND3 <=", value, "fund3");
            return (Criteria) this;
        }

        public Criteria andFund3In(List<BigDecimal> values) {
            addCriterion("FUND3 in", values, "fund3");
            return (Criteria) this;
        }

        public Criteria andFund3NotIn(List<BigDecimal> values) {
            addCriterion("FUND3 not in", values, "fund3");
            return (Criteria) this;
        }

        public Criteria andFund3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("FUND3 between", value1, value2, "fund3");
            return (Criteria) this;
        }

        public Criteria andFund3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FUND3 not between", value1, value2, "fund3");
            return (Criteria) this;
        }

        public Criteria andFund4IsNull() {
            addCriterion("FUND4 is null");
            return (Criteria) this;
        }

        public Criteria andFund4IsNotNull() {
            addCriterion("FUND4 is not null");
            return (Criteria) this;
        }

        public Criteria andFund4EqualTo(BigDecimal value) {
            addCriterion("FUND4 =", value, "fund4");
            return (Criteria) this;
        }

        public Criteria andFund4NotEqualTo(BigDecimal value) {
            addCriterion("FUND4 <>", value, "fund4");
            return (Criteria) this;
        }

        public Criteria andFund4GreaterThan(BigDecimal value) {
            addCriterion("FUND4 >", value, "fund4");
            return (Criteria) this;
        }

        public Criteria andFund4GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FUND4 >=", value, "fund4");
            return (Criteria) this;
        }

        public Criteria andFund4LessThan(BigDecimal value) {
            addCriterion("FUND4 <", value, "fund4");
            return (Criteria) this;
        }

        public Criteria andFund4LessThanOrEqualTo(BigDecimal value) {
            addCriterion("FUND4 <=", value, "fund4");
            return (Criteria) this;
        }

        public Criteria andFund4In(List<BigDecimal> values) {
            addCriterion("FUND4 in", values, "fund4");
            return (Criteria) this;
        }

        public Criteria andFund4NotIn(List<BigDecimal> values) {
            addCriterion("FUND4 not in", values, "fund4");
            return (Criteria) this;
        }

        public Criteria andFund4Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("FUND4 between", value1, value2, "fund4");
            return (Criteria) this;
        }

        public Criteria andFund4NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FUND4 not between", value1, value2, "fund4");
            return (Criteria) this;
        }

        public Criteria andFund5IsNull() {
            addCriterion("FUND5 is null");
            return (Criteria) this;
        }

        public Criteria andFund5IsNotNull() {
            addCriterion("FUND5 is not null");
            return (Criteria) this;
        }

        public Criteria andFund5EqualTo(BigDecimal value) {
            addCriterion("FUND5 =", value, "fund5");
            return (Criteria) this;
        }

        public Criteria andFund5NotEqualTo(BigDecimal value) {
            addCriterion("FUND5 <>", value, "fund5");
            return (Criteria) this;
        }

        public Criteria andFund5GreaterThan(BigDecimal value) {
            addCriterion("FUND5 >", value, "fund5");
            return (Criteria) this;
        }

        public Criteria andFund5GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FUND5 >=", value, "fund5");
            return (Criteria) this;
        }

        public Criteria andFund5LessThan(BigDecimal value) {
            addCriterion("FUND5 <", value, "fund5");
            return (Criteria) this;
        }

        public Criteria andFund5LessThanOrEqualTo(BigDecimal value) {
            addCriterion("FUND5 <=", value, "fund5");
            return (Criteria) this;
        }

        public Criteria andFund5In(List<BigDecimal> values) {
            addCriterion("FUND5 in", values, "fund5");
            return (Criteria) this;
        }

        public Criteria andFund5NotIn(List<BigDecimal> values) {
            addCriterion("FUND5 not in", values, "fund5");
            return (Criteria) this;
        }

        public Criteria andFund5Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("FUND5 between", value1, value2, "fund5");
            return (Criteria) this;
        }

        public Criteria andFund5NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FUND5 not between", value1, value2, "fund5");
            return (Criteria) this;
        }

        public Criteria andFund6IsNull() {
            addCriterion("FUND6 is null");
            return (Criteria) this;
        }

        public Criteria andFund6IsNotNull() {
            addCriterion("FUND6 is not null");
            return (Criteria) this;
        }

        public Criteria andFund6EqualTo(BigDecimal value) {
            addCriterion("FUND6 =", value, "fund6");
            return (Criteria) this;
        }

        public Criteria andFund6NotEqualTo(BigDecimal value) {
            addCriterion("FUND6 <>", value, "fund6");
            return (Criteria) this;
        }

        public Criteria andFund6GreaterThan(BigDecimal value) {
            addCriterion("FUND6 >", value, "fund6");
            return (Criteria) this;
        }

        public Criteria andFund6GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FUND6 >=", value, "fund6");
            return (Criteria) this;
        }

        public Criteria andFund6LessThan(BigDecimal value) {
            addCriterion("FUND6 <", value, "fund6");
            return (Criteria) this;
        }

        public Criteria andFund6LessThanOrEqualTo(BigDecimal value) {
            addCriterion("FUND6 <=", value, "fund6");
            return (Criteria) this;
        }

        public Criteria andFund6In(List<BigDecimal> values) {
            addCriterion("FUND6 in", values, "fund6");
            return (Criteria) this;
        }

        public Criteria andFund6NotIn(List<BigDecimal> values) {
            addCriterion("FUND6 not in", values, "fund6");
            return (Criteria) this;
        }

        public Criteria andFund6Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("FUND6 between", value1, value2, "fund6");
            return (Criteria) this;
        }

        public Criteria andFund6NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FUND6 not between", value1, value2, "fund6");
            return (Criteria) this;
        }

        public Criteria andDemandmaxIsNull() {
            addCriterion("DEMANDMAX is null");
            return (Criteria) this;
        }

        public Criteria andDemandmaxIsNotNull() {
            addCriterion("DEMANDMAX is not null");
            return (Criteria) this;
        }

        public Criteria andDemandmaxEqualTo(BigDecimal value) {
            addCriterion("DEMANDMAX =", value, "demandmax");
            return (Criteria) this;
        }

        public Criteria andDemandmaxNotEqualTo(BigDecimal value) {
            addCriterion("DEMANDMAX <>", value, "demandmax");
            return (Criteria) this;
        }

        public Criteria andDemandmaxGreaterThan(BigDecimal value) {
            addCriterion("DEMANDMAX >", value, "demandmax");
            return (Criteria) this;
        }

        public Criteria andDemandmaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DEMANDMAX >=", value, "demandmax");
            return (Criteria) this;
        }

        public Criteria andDemandmaxLessThan(BigDecimal value) {
            addCriterion("DEMANDMAX <", value, "demandmax");
            return (Criteria) this;
        }

        public Criteria andDemandmaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DEMANDMAX <=", value, "demandmax");
            return (Criteria) this;
        }

        public Criteria andDemandmaxIn(List<BigDecimal> values) {
            addCriterion("DEMANDMAX in", values, "demandmax");
            return (Criteria) this;
        }

        public Criteria andDemandmaxNotIn(List<BigDecimal> values) {
            addCriterion("DEMANDMAX not in", values, "demandmax");
            return (Criteria) this;
        }

        public Criteria andDemandmaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEMANDMAX between", value1, value2, "demandmax");
            return (Criteria) this;
        }

        public Criteria andDemandmaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEMANDMAX not between", value1, value2, "demandmax");
            return (Criteria) this;
        }

        public Criteria andCapabilityIsNull() {
            addCriterion("CAPABILITY is null");
            return (Criteria) this;
        }

        public Criteria andCapabilityIsNotNull() {
            addCriterion("CAPABILITY is not null");
            return (Criteria) this;
        }

        public Criteria andCapabilityEqualTo(Integer value) {
            addCriterion("CAPABILITY =", value, "capability");
            return (Criteria) this;
        }

        public Criteria andCapabilityNotEqualTo(Integer value) {
            addCriterion("CAPABILITY <>", value, "capability");
            return (Criteria) this;
        }

        public Criteria andCapabilityGreaterThan(Integer value) {
            addCriterion("CAPABILITY >", value, "capability");
            return (Criteria) this;
        }

        public Criteria andCapabilityGreaterThanOrEqualTo(Integer value) {
            addCriterion("CAPABILITY >=", value, "capability");
            return (Criteria) this;
        }

        public Criteria andCapabilityLessThan(Integer value) {
            addCriterion("CAPABILITY <", value, "capability");
            return (Criteria) this;
        }

        public Criteria andCapabilityLessThanOrEqualTo(Integer value) {
            addCriterion("CAPABILITY <=", value, "capability");
            return (Criteria) this;
        }

        public Criteria andCapabilityIn(List<Integer> values) {
            addCriterion("CAPABILITY in", values, "capability");
            return (Criteria) this;
        }

        public Criteria andCapabilityNotIn(List<Integer> values) {
            addCriterion("CAPABILITY not in", values, "capability");
            return (Criteria) this;
        }

        public Criteria andCapabilityBetween(Integer value1, Integer value2) {
            addCriterion("CAPABILITY between", value1, value2, "capability");
            return (Criteria) this;
        }

        public Criteria andCapabilityNotBetween(Integer value1, Integer value2) {
            addCriterion("CAPABILITY not between", value1, value2, "capability");
            return (Criteria) this;
        }

        public Criteria andPfIsNull() {
            addCriterion("PF is null");
            return (Criteria) this;
        }

        public Criteria andPfIsNotNull() {
            addCriterion("PF is not null");
            return (Criteria) this;
        }

        public Criteria andPfEqualTo(BigDecimal value) {
            addCriterion("PF =", value, "pf");
            return (Criteria) this;
        }

        public Criteria andPfNotEqualTo(BigDecimal value) {
            addCriterion("PF <>", value, "pf");
            return (Criteria) this;
        }

        public Criteria andPfGreaterThan(BigDecimal value) {
            addCriterion("PF >", value, "pf");
            return (Criteria) this;
        }

        public Criteria andPfGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PF >=", value, "pf");
            return (Criteria) this;
        }

        public Criteria andPfLessThan(BigDecimal value) {
            addCriterion("PF <", value, "pf");
            return (Criteria) this;
        }

        public Criteria andPfLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PF <=", value, "pf");
            return (Criteria) this;
        }

        public Criteria andPfIn(List<BigDecimal> values) {
            addCriterion("PF in", values, "pf");
            return (Criteria) this;
        }

        public Criteria andPfNotIn(List<BigDecimal> values) {
            addCriterion("PF not in", values, "pf");
            return (Criteria) this;
        }

        public Criteria andPfBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PF between", value1, value2, "pf");
            return (Criteria) this;
        }

        public Criteria andPfNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PF not between", value1, value2, "pf");
            return (Criteria) this;
        }

        public Criteria andTotalfeeIsNull() {
            addCriterion("TOTALFEE is null");
            return (Criteria) this;
        }

        public Criteria andTotalfeeIsNotNull() {
            addCriterion("TOTALFEE is not null");
            return (Criteria) this;
        }

        public Criteria andTotalfeeEqualTo(BigDecimal value) {
            addCriterion("TOTALFEE =", value, "totalfee");
            return (Criteria) this;
        }

        public Criteria andTotalfeeNotEqualTo(BigDecimal value) {
            addCriterion("TOTALFEE <>", value, "totalfee");
            return (Criteria) this;
        }

        public Criteria andTotalfeeGreaterThan(BigDecimal value) {
            addCriterion("TOTALFEE >", value, "totalfee");
            return (Criteria) this;
        }

        public Criteria andTotalfeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTALFEE >=", value, "totalfee");
            return (Criteria) this;
        }

        public Criteria andTotalfeeLessThan(BigDecimal value) {
            addCriterion("TOTALFEE <", value, "totalfee");
            return (Criteria) this;
        }

        public Criteria andTotalfeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTALFEE <=", value, "totalfee");
            return (Criteria) this;
        }

        public Criteria andTotalfeeIn(List<BigDecimal> values) {
            addCriterion("TOTALFEE in", values, "totalfee");
            return (Criteria) this;
        }

        public Criteria andTotalfeeNotIn(List<BigDecimal> values) {
            addCriterion("TOTALFEE not in", values, "totalfee");
            return (Criteria) this;
        }

        public Criteria andTotalfeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTALFEE between", value1, value2, "totalfee");
            return (Criteria) this;
        }

        public Criteria andTotalfeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTALFEE not between", value1, value2, "totalfee");
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

        public Criteria andStartbmzongzyIsNull() {
            addCriterion("STARTBMZONGZY is null");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzyIsNotNull() {
            addCriterion("STARTBMZONGZY is not null");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzyEqualTo(BigDecimal value) {
            addCriterion("STARTBMZONGZY =", value, "startbmzongzy");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzyNotEqualTo(BigDecimal value) {
            addCriterion("STARTBMZONGZY <>", value, "startbmzongzy");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzyGreaterThan(BigDecimal value) {
            addCriterion("STARTBMZONGZY >", value, "startbmzongzy");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMZONGZY >=", value, "startbmzongzy");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzyLessThan(BigDecimal value) {
            addCriterion("STARTBMZONGZY <", value, "startbmzongzy");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMZONGZY <=", value, "startbmzongzy");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzyIn(List<BigDecimal> values) {
            addCriterion("STARTBMZONGZY in", values, "startbmzongzy");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzyNotIn(List<BigDecimal> values) {
            addCriterion("STARTBMZONGZY not in", values, "startbmzongzy");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMZONGZY between", value1, value2, "startbmzongzy");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMZONGZY not between", value1, value2, "startbmzongzy");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfyIsNull() {
            addCriterion("STARTBMZONGFY is null");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfyIsNotNull() {
            addCriterion("STARTBMZONGFY is not null");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfyEqualTo(BigDecimal value) {
            addCriterion("STARTBMZONGFY =", value, "startbmzongfy");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfyNotEqualTo(BigDecimal value) {
            addCriterion("STARTBMZONGFY <>", value, "startbmzongfy");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfyGreaterThan(BigDecimal value) {
            addCriterion("STARTBMZONGFY >", value, "startbmzongfy");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMZONGFY >=", value, "startbmzongfy");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfyLessThan(BigDecimal value) {
            addCriterion("STARTBMZONGFY <", value, "startbmzongfy");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMZONGFY <=", value, "startbmzongfy");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfyIn(List<BigDecimal> values) {
            addCriterion("STARTBMZONGFY in", values, "startbmzongfy");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfyNotIn(List<BigDecimal> values) {
            addCriterion("STARTBMZONGFY not in", values, "startbmzongfy");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMZONGFY between", value1, value2, "startbmzongfy");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMZONGFY not between", value1, value2, "startbmzongfy");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzwIsNull() {
            addCriterion("STARTBMZONGZW is null");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzwIsNotNull() {
            addCriterion("STARTBMZONGZW is not null");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzwEqualTo(BigDecimal value) {
            addCriterion("STARTBMZONGZW =", value, "startbmzongzw");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzwNotEqualTo(BigDecimal value) {
            addCriterion("STARTBMZONGZW <>", value, "startbmzongzw");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzwGreaterThan(BigDecimal value) {
            addCriterion("STARTBMZONGZW >", value, "startbmzongzw");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMZONGZW >=", value, "startbmzongzw");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzwLessThan(BigDecimal value) {
            addCriterion("STARTBMZONGZW <", value, "startbmzongzw");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMZONGZW <=", value, "startbmzongzw");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzwIn(List<BigDecimal> values) {
            addCriterion("STARTBMZONGZW in", values, "startbmzongzw");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzwNotIn(List<BigDecimal> values) {
            addCriterion("STARTBMZONGZW not in", values, "startbmzongzw");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMZONGZW between", value1, value2, "startbmzongzw");
            return (Criteria) this;
        }

        public Criteria andStartbmzongzwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMZONGZW not between", value1, value2, "startbmzongzw");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfwIsNull() {
            addCriterion("STARTBMZONGFW is null");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfwIsNotNull() {
            addCriterion("STARTBMZONGFW is not null");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfwEqualTo(BigDecimal value) {
            addCriterion("STARTBMZONGFW =", value, "startbmzongfw");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfwNotEqualTo(BigDecimal value) {
            addCriterion("STARTBMZONGFW <>", value, "startbmzongfw");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfwGreaterThan(BigDecimal value) {
            addCriterion("STARTBMZONGFW >", value, "startbmzongfw");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMZONGFW >=", value, "startbmzongfw");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfwLessThan(BigDecimal value) {
            addCriterion("STARTBMZONGFW <", value, "startbmzongfw");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMZONGFW <=", value, "startbmzongfw");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfwIn(List<BigDecimal> values) {
            addCriterion("STARTBMZONGFW in", values, "startbmzongfw");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfwNotIn(List<BigDecimal> values) {
            addCriterion("STARTBMZONGFW not in", values, "startbmzongfw");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMZONGFW between", value1, value2, "startbmzongfw");
            return (Criteria) this;
        }

        public Criteria andStartbmzongfwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMZONGFW not between", value1, value2, "startbmzongfw");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzyIsNull() {
            addCriterion("STARTBMJIANZY is null");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzyIsNotNull() {
            addCriterion("STARTBMJIANZY is not null");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzyEqualTo(BigDecimal value) {
            addCriterion("STARTBMJIANZY =", value, "startbmjianzy");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzyNotEqualTo(BigDecimal value) {
            addCriterion("STARTBMJIANZY <>", value, "startbmjianzy");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzyGreaterThan(BigDecimal value) {
            addCriterion("STARTBMJIANZY >", value, "startbmjianzy");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMJIANZY >=", value, "startbmjianzy");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzyLessThan(BigDecimal value) {
            addCriterion("STARTBMJIANZY <", value, "startbmjianzy");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMJIANZY <=", value, "startbmjianzy");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzyIn(List<BigDecimal> values) {
            addCriterion("STARTBMJIANZY in", values, "startbmjianzy");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzyNotIn(List<BigDecimal> values) {
            addCriterion("STARTBMJIANZY not in", values, "startbmjianzy");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMJIANZY between", value1, value2, "startbmjianzy");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMJIANZY not between", value1, value2, "startbmjianzy");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfyIsNull() {
            addCriterion("STARTBMJIANFY is null");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfyIsNotNull() {
            addCriterion("STARTBMJIANFY is not null");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfyEqualTo(BigDecimal value) {
            addCriterion("STARTBMJIANFY =", value, "startbmjianfy");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfyNotEqualTo(BigDecimal value) {
            addCriterion("STARTBMJIANFY <>", value, "startbmjianfy");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfyGreaterThan(BigDecimal value) {
            addCriterion("STARTBMJIANFY >", value, "startbmjianfy");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMJIANFY >=", value, "startbmjianfy");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfyLessThan(BigDecimal value) {
            addCriterion("STARTBMJIANFY <", value, "startbmjianfy");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMJIANFY <=", value, "startbmjianfy");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfyIn(List<BigDecimal> values) {
            addCriterion("STARTBMJIANFY in", values, "startbmjianfy");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfyNotIn(List<BigDecimal> values) {
            addCriterion("STARTBMJIANFY not in", values, "startbmjianfy");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMJIANFY between", value1, value2, "startbmjianfy");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMJIANFY not between", value1, value2, "startbmjianfy");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzwIsNull() {
            addCriterion("STARTBMJIANZW is null");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzwIsNotNull() {
            addCriterion("STARTBMJIANZW is not null");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzwEqualTo(BigDecimal value) {
            addCriterion("STARTBMJIANZW =", value, "startbmjianzw");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzwNotEqualTo(BigDecimal value) {
            addCriterion("STARTBMJIANZW <>", value, "startbmjianzw");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzwGreaterThan(BigDecimal value) {
            addCriterion("STARTBMJIANZW >", value, "startbmjianzw");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMJIANZW >=", value, "startbmjianzw");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzwLessThan(BigDecimal value) {
            addCriterion("STARTBMJIANZW <", value, "startbmjianzw");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMJIANZW <=", value, "startbmjianzw");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzwIn(List<BigDecimal> values) {
            addCriterion("STARTBMJIANZW in", values, "startbmjianzw");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzwNotIn(List<BigDecimal> values) {
            addCriterion("STARTBMJIANZW not in", values, "startbmjianzw");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMJIANZW between", value1, value2, "startbmjianzw");
            return (Criteria) this;
        }

        public Criteria andStartbmjianzwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMJIANZW not between", value1, value2, "startbmjianzw");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfwIsNull() {
            addCriterion("STARTBMJIANFW is null");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfwIsNotNull() {
            addCriterion("STARTBMJIANFW is not null");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfwEqualTo(BigDecimal value) {
            addCriterion("STARTBMJIANFW =", value, "startbmjianfw");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfwNotEqualTo(BigDecimal value) {
            addCriterion("STARTBMJIANFW <>", value, "startbmjianfw");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfwGreaterThan(BigDecimal value) {
            addCriterion("STARTBMJIANFW >", value, "startbmjianfw");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMJIANFW >=", value, "startbmjianfw");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfwLessThan(BigDecimal value) {
            addCriterion("STARTBMJIANFW <", value, "startbmjianfw");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMJIANFW <=", value, "startbmjianfw");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfwIn(List<BigDecimal> values) {
            addCriterion("STARTBMJIANFW in", values, "startbmjianfw");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfwNotIn(List<BigDecimal> values) {
            addCriterion("STARTBMJIANFW not in", values, "startbmjianfw");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMJIANFW between", value1, value2, "startbmjianfw");
            return (Criteria) this;
        }

        public Criteria andStartbmjianfwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMJIANFW not between", value1, value2, "startbmjianfw");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzyIsNull() {
            addCriterion("STARTBMFENGZY is null");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzyIsNotNull() {
            addCriterion("STARTBMFENGZY is not null");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzyEqualTo(BigDecimal value) {
            addCriterion("STARTBMFENGZY =", value, "startbmfengzy");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzyNotEqualTo(BigDecimal value) {
            addCriterion("STARTBMFENGZY <>", value, "startbmfengzy");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzyGreaterThan(BigDecimal value) {
            addCriterion("STARTBMFENGZY >", value, "startbmfengzy");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMFENGZY >=", value, "startbmfengzy");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzyLessThan(BigDecimal value) {
            addCriterion("STARTBMFENGZY <", value, "startbmfengzy");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMFENGZY <=", value, "startbmfengzy");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzyIn(List<BigDecimal> values) {
            addCriterion("STARTBMFENGZY in", values, "startbmfengzy");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzyNotIn(List<BigDecimal> values) {
            addCriterion("STARTBMFENGZY not in", values, "startbmfengzy");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMFENGZY between", value1, value2, "startbmfengzy");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMFENGZY not between", value1, value2, "startbmfengzy");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfyIsNull() {
            addCriterion("STARTBMFENGFY is null");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfyIsNotNull() {
            addCriterion("STARTBMFENGFY is not null");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfyEqualTo(BigDecimal value) {
            addCriterion("STARTBMFENGFY =", value, "startbmfengfy");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfyNotEqualTo(BigDecimal value) {
            addCriterion("STARTBMFENGFY <>", value, "startbmfengfy");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfyGreaterThan(BigDecimal value) {
            addCriterion("STARTBMFENGFY >", value, "startbmfengfy");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMFENGFY >=", value, "startbmfengfy");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfyLessThan(BigDecimal value) {
            addCriterion("STARTBMFENGFY <", value, "startbmfengfy");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMFENGFY <=", value, "startbmfengfy");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfyIn(List<BigDecimal> values) {
            addCriterion("STARTBMFENGFY in", values, "startbmfengfy");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfyNotIn(List<BigDecimal> values) {
            addCriterion("STARTBMFENGFY not in", values, "startbmfengfy");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMFENGFY between", value1, value2, "startbmfengfy");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMFENGFY not between", value1, value2, "startbmfengfy");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzwIsNull() {
            addCriterion("STARTBMFENGZW is null");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzwIsNotNull() {
            addCriterion("STARTBMFENGZW is not null");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzwEqualTo(BigDecimal value) {
            addCriterion("STARTBMFENGZW =", value, "startbmfengzw");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzwNotEqualTo(BigDecimal value) {
            addCriterion("STARTBMFENGZW <>", value, "startbmfengzw");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzwGreaterThan(BigDecimal value) {
            addCriterion("STARTBMFENGZW >", value, "startbmfengzw");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMFENGZW >=", value, "startbmfengzw");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzwLessThan(BigDecimal value) {
            addCriterion("STARTBMFENGZW <", value, "startbmfengzw");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMFENGZW <=", value, "startbmfengzw");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzwIn(List<BigDecimal> values) {
            addCriterion("STARTBMFENGZW in", values, "startbmfengzw");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzwNotIn(List<BigDecimal> values) {
            addCriterion("STARTBMFENGZW not in", values, "startbmfengzw");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMFENGZW between", value1, value2, "startbmfengzw");
            return (Criteria) this;
        }

        public Criteria andStartbmfengzwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMFENGZW not between", value1, value2, "startbmfengzw");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfwIsNull() {
            addCriterion("STARTBMFENGFW is null");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfwIsNotNull() {
            addCriterion("STARTBMFENGFW is not null");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfwEqualTo(BigDecimal value) {
            addCriterion("STARTBMFENGFW =", value, "startbmfengfw");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfwNotEqualTo(BigDecimal value) {
            addCriterion("STARTBMFENGFW <>", value, "startbmfengfw");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfwGreaterThan(BigDecimal value) {
            addCriterion("STARTBMFENGFW >", value, "startbmfengfw");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMFENGFW >=", value, "startbmfengfw");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfwLessThan(BigDecimal value) {
            addCriterion("STARTBMFENGFW <", value, "startbmfengfw");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMFENGFW <=", value, "startbmfengfw");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfwIn(List<BigDecimal> values) {
            addCriterion("STARTBMFENGFW in", values, "startbmfengfw");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfwNotIn(List<BigDecimal> values) {
            addCriterion("STARTBMFENGFW not in", values, "startbmfengfw");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMFENGFW between", value1, value2, "startbmfengfw");
            return (Criteria) this;
        }

        public Criteria andStartbmfengfwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMFENGFW not between", value1, value2, "startbmfengfw");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzyIsNull() {
            addCriterion("STARTBMPINGZY is null");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzyIsNotNull() {
            addCriterion("STARTBMPINGZY is not null");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzyEqualTo(BigDecimal value) {
            addCriterion("STARTBMPINGZY =", value, "startbmpingzy");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzyNotEqualTo(BigDecimal value) {
            addCriterion("STARTBMPINGZY <>", value, "startbmpingzy");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzyGreaterThan(BigDecimal value) {
            addCriterion("STARTBMPINGZY >", value, "startbmpingzy");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMPINGZY >=", value, "startbmpingzy");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzyLessThan(BigDecimal value) {
            addCriterion("STARTBMPINGZY <", value, "startbmpingzy");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMPINGZY <=", value, "startbmpingzy");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzyIn(List<BigDecimal> values) {
            addCriterion("STARTBMPINGZY in", values, "startbmpingzy");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzyNotIn(List<BigDecimal> values) {
            addCriterion("STARTBMPINGZY not in", values, "startbmpingzy");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMPINGZY between", value1, value2, "startbmpingzy");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMPINGZY not between", value1, value2, "startbmpingzy");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfyIsNull() {
            addCriterion("STARTBMPINGFY is null");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfyIsNotNull() {
            addCriterion("STARTBMPINGFY is not null");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfyEqualTo(BigDecimal value) {
            addCriterion("STARTBMPINGFY =", value, "startbmpingfy");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfyNotEqualTo(BigDecimal value) {
            addCriterion("STARTBMPINGFY <>", value, "startbmpingfy");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfyGreaterThan(BigDecimal value) {
            addCriterion("STARTBMPINGFY >", value, "startbmpingfy");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMPINGFY >=", value, "startbmpingfy");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfyLessThan(BigDecimal value) {
            addCriterion("STARTBMPINGFY <", value, "startbmpingfy");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMPINGFY <=", value, "startbmpingfy");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfyIn(List<BigDecimal> values) {
            addCriterion("STARTBMPINGFY in", values, "startbmpingfy");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfyNotIn(List<BigDecimal> values) {
            addCriterion("STARTBMPINGFY not in", values, "startbmpingfy");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMPINGFY between", value1, value2, "startbmpingfy");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMPINGFY not between", value1, value2, "startbmpingfy");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzwIsNull() {
            addCriterion("STARTBMPINGZW is null");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzwIsNotNull() {
            addCriterion("STARTBMPINGZW is not null");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzwEqualTo(BigDecimal value) {
            addCriterion("STARTBMPINGZW =", value, "startbmpingzw");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzwNotEqualTo(BigDecimal value) {
            addCriterion("STARTBMPINGZW <>", value, "startbmpingzw");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzwGreaterThan(BigDecimal value) {
            addCriterion("STARTBMPINGZW >", value, "startbmpingzw");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMPINGZW >=", value, "startbmpingzw");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzwLessThan(BigDecimal value) {
            addCriterion("STARTBMPINGZW <", value, "startbmpingzw");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMPINGZW <=", value, "startbmpingzw");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzwIn(List<BigDecimal> values) {
            addCriterion("STARTBMPINGZW in", values, "startbmpingzw");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzwNotIn(List<BigDecimal> values) {
            addCriterion("STARTBMPINGZW not in", values, "startbmpingzw");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMPINGZW between", value1, value2, "startbmpingzw");
            return (Criteria) this;
        }

        public Criteria andStartbmpingzwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMPINGZW not between", value1, value2, "startbmpingzw");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfwIsNull() {
            addCriterion("STARTBMPINGFW is null");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfwIsNotNull() {
            addCriterion("STARTBMPINGFW is not null");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfwEqualTo(BigDecimal value) {
            addCriterion("STARTBMPINGFW =", value, "startbmpingfw");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfwNotEqualTo(BigDecimal value) {
            addCriterion("STARTBMPINGFW <>", value, "startbmpingfw");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfwGreaterThan(BigDecimal value) {
            addCriterion("STARTBMPINGFW >", value, "startbmpingfw");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMPINGFW >=", value, "startbmpingfw");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfwLessThan(BigDecimal value) {
            addCriterion("STARTBMPINGFW <", value, "startbmpingfw");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMPINGFW <=", value, "startbmpingfw");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfwIn(List<BigDecimal> values) {
            addCriterion("STARTBMPINGFW in", values, "startbmpingfw");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfwNotIn(List<BigDecimal> values) {
            addCriterion("STARTBMPINGFW not in", values, "startbmpingfw");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMPINGFW between", value1, value2, "startbmpingfw");
            return (Criteria) this;
        }

        public Criteria andStartbmpingfwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMPINGFW not between", value1, value2, "startbmpingfw");
            return (Criteria) this;
        }

        public Criteria andStartbmguzyIsNull() {
            addCriterion("STARTBMGUZY is null");
            return (Criteria) this;
        }

        public Criteria andStartbmguzyIsNotNull() {
            addCriterion("STARTBMGUZY is not null");
            return (Criteria) this;
        }

        public Criteria andStartbmguzyEqualTo(BigDecimal value) {
            addCriterion("STARTBMGUZY =", value, "startbmguzy");
            return (Criteria) this;
        }

        public Criteria andStartbmguzyNotEqualTo(BigDecimal value) {
            addCriterion("STARTBMGUZY <>", value, "startbmguzy");
            return (Criteria) this;
        }

        public Criteria andStartbmguzyGreaterThan(BigDecimal value) {
            addCriterion("STARTBMGUZY >", value, "startbmguzy");
            return (Criteria) this;
        }

        public Criteria andStartbmguzyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMGUZY >=", value, "startbmguzy");
            return (Criteria) this;
        }

        public Criteria andStartbmguzyLessThan(BigDecimal value) {
            addCriterion("STARTBMGUZY <", value, "startbmguzy");
            return (Criteria) this;
        }

        public Criteria andStartbmguzyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMGUZY <=", value, "startbmguzy");
            return (Criteria) this;
        }

        public Criteria andStartbmguzyIn(List<BigDecimal> values) {
            addCriterion("STARTBMGUZY in", values, "startbmguzy");
            return (Criteria) this;
        }

        public Criteria andStartbmguzyNotIn(List<BigDecimal> values) {
            addCriterion("STARTBMGUZY not in", values, "startbmguzy");
            return (Criteria) this;
        }

        public Criteria andStartbmguzyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMGUZY between", value1, value2, "startbmguzy");
            return (Criteria) this;
        }

        public Criteria andStartbmguzyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMGUZY not between", value1, value2, "startbmguzy");
            return (Criteria) this;
        }

        public Criteria andStartbmgufyIsNull() {
            addCriterion("STARTBMGUFY is null");
            return (Criteria) this;
        }

        public Criteria andStartbmgufyIsNotNull() {
            addCriterion("STARTBMGUFY is not null");
            return (Criteria) this;
        }

        public Criteria andStartbmgufyEqualTo(BigDecimal value) {
            addCriterion("STARTBMGUFY =", value, "startbmgufy");
            return (Criteria) this;
        }

        public Criteria andStartbmgufyNotEqualTo(BigDecimal value) {
            addCriterion("STARTBMGUFY <>", value, "startbmgufy");
            return (Criteria) this;
        }

        public Criteria andStartbmgufyGreaterThan(BigDecimal value) {
            addCriterion("STARTBMGUFY >", value, "startbmgufy");
            return (Criteria) this;
        }

        public Criteria andStartbmgufyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMGUFY >=", value, "startbmgufy");
            return (Criteria) this;
        }

        public Criteria andStartbmgufyLessThan(BigDecimal value) {
            addCriterion("STARTBMGUFY <", value, "startbmgufy");
            return (Criteria) this;
        }

        public Criteria andStartbmgufyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMGUFY <=", value, "startbmgufy");
            return (Criteria) this;
        }

        public Criteria andStartbmgufyIn(List<BigDecimal> values) {
            addCriterion("STARTBMGUFY in", values, "startbmgufy");
            return (Criteria) this;
        }

        public Criteria andStartbmgufyNotIn(List<BigDecimal> values) {
            addCriterion("STARTBMGUFY not in", values, "startbmgufy");
            return (Criteria) this;
        }

        public Criteria andStartbmgufyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMGUFY between", value1, value2, "startbmgufy");
            return (Criteria) this;
        }

        public Criteria andStartbmgufyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMGUFY not between", value1, value2, "startbmgufy");
            return (Criteria) this;
        }

        public Criteria andStartbmguzwIsNull() {
            addCriterion("STARTBMGUZW is null");
            return (Criteria) this;
        }

        public Criteria andStartbmguzwIsNotNull() {
            addCriterion("STARTBMGUZW is not null");
            return (Criteria) this;
        }

        public Criteria andStartbmguzwEqualTo(BigDecimal value) {
            addCriterion("STARTBMGUZW =", value, "startbmguzw");
            return (Criteria) this;
        }

        public Criteria andStartbmguzwNotEqualTo(BigDecimal value) {
            addCriterion("STARTBMGUZW <>", value, "startbmguzw");
            return (Criteria) this;
        }

        public Criteria andStartbmguzwGreaterThan(BigDecimal value) {
            addCriterion("STARTBMGUZW >", value, "startbmguzw");
            return (Criteria) this;
        }

        public Criteria andStartbmguzwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMGUZW >=", value, "startbmguzw");
            return (Criteria) this;
        }

        public Criteria andStartbmguzwLessThan(BigDecimal value) {
            addCriterion("STARTBMGUZW <", value, "startbmguzw");
            return (Criteria) this;
        }

        public Criteria andStartbmguzwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMGUZW <=", value, "startbmguzw");
            return (Criteria) this;
        }

        public Criteria andStartbmguzwIn(List<BigDecimal> values) {
            addCriterion("STARTBMGUZW in", values, "startbmguzw");
            return (Criteria) this;
        }

        public Criteria andStartbmguzwNotIn(List<BigDecimal> values) {
            addCriterion("STARTBMGUZW not in", values, "startbmguzw");
            return (Criteria) this;
        }

        public Criteria andStartbmguzwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMGUZW between", value1, value2, "startbmguzw");
            return (Criteria) this;
        }

        public Criteria andStartbmguzwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMGUZW not between", value1, value2, "startbmguzw");
            return (Criteria) this;
        }

        public Criteria andStartbmgufwIsNull() {
            addCriterion("STARTBMGUFW is null");
            return (Criteria) this;
        }

        public Criteria andStartbmgufwIsNotNull() {
            addCriterion("STARTBMGUFW is not null");
            return (Criteria) this;
        }

        public Criteria andStartbmgufwEqualTo(BigDecimal value) {
            addCriterion("STARTBMGUFW =", value, "startbmgufw");
            return (Criteria) this;
        }

        public Criteria andStartbmgufwNotEqualTo(BigDecimal value) {
            addCriterion("STARTBMGUFW <>", value, "startbmgufw");
            return (Criteria) this;
        }

        public Criteria andStartbmgufwGreaterThan(BigDecimal value) {
            addCriterion("STARTBMGUFW >", value, "startbmgufw");
            return (Criteria) this;
        }

        public Criteria andStartbmgufwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMGUFW >=", value, "startbmgufw");
            return (Criteria) this;
        }

        public Criteria andStartbmgufwLessThan(BigDecimal value) {
            addCriterion("STARTBMGUFW <", value, "startbmgufw");
            return (Criteria) this;
        }

        public Criteria andStartbmgufwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STARTBMGUFW <=", value, "startbmgufw");
            return (Criteria) this;
        }

        public Criteria andStartbmgufwIn(List<BigDecimal> values) {
            addCriterion("STARTBMGUFW in", values, "startbmgufw");
            return (Criteria) this;
        }

        public Criteria andStartbmgufwNotIn(List<BigDecimal> values) {
            addCriterion("STARTBMGUFW not in", values, "startbmgufw");
            return (Criteria) this;
        }

        public Criteria andStartbmgufwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMGUFW between", value1, value2, "startbmgufw");
            return (Criteria) this;
        }

        public Criteria andStartbmgufwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STARTBMGUFW not between", value1, value2, "startbmgufw");
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

        public Criteria andEndbmzongzyIsNull() {
            addCriterion("ENDBMZONGZY is null");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzyIsNotNull() {
            addCriterion("ENDBMZONGZY is not null");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzyEqualTo(BigDecimal value) {
            addCriterion("ENDBMZONGZY =", value, "endbmzongzy");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzyNotEqualTo(BigDecimal value) {
            addCriterion("ENDBMZONGZY <>", value, "endbmzongzy");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzyGreaterThan(BigDecimal value) {
            addCriterion("ENDBMZONGZY >", value, "endbmzongzy");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMZONGZY >=", value, "endbmzongzy");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzyLessThan(BigDecimal value) {
            addCriterion("ENDBMZONGZY <", value, "endbmzongzy");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMZONGZY <=", value, "endbmzongzy");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzyIn(List<BigDecimal> values) {
            addCriterion("ENDBMZONGZY in", values, "endbmzongzy");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzyNotIn(List<BigDecimal> values) {
            addCriterion("ENDBMZONGZY not in", values, "endbmzongzy");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMZONGZY between", value1, value2, "endbmzongzy");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMZONGZY not between", value1, value2, "endbmzongzy");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfyIsNull() {
            addCriterion("ENDBMZONGFY is null");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfyIsNotNull() {
            addCriterion("ENDBMZONGFY is not null");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfyEqualTo(BigDecimal value) {
            addCriterion("ENDBMZONGFY =", value, "endbmzongfy");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfyNotEqualTo(BigDecimal value) {
            addCriterion("ENDBMZONGFY <>", value, "endbmzongfy");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfyGreaterThan(BigDecimal value) {
            addCriterion("ENDBMZONGFY >", value, "endbmzongfy");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMZONGFY >=", value, "endbmzongfy");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfyLessThan(BigDecimal value) {
            addCriterion("ENDBMZONGFY <", value, "endbmzongfy");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMZONGFY <=", value, "endbmzongfy");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfyIn(List<BigDecimal> values) {
            addCriterion("ENDBMZONGFY in", values, "endbmzongfy");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfyNotIn(List<BigDecimal> values) {
            addCriterion("ENDBMZONGFY not in", values, "endbmzongfy");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMZONGFY between", value1, value2, "endbmzongfy");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMZONGFY not between", value1, value2, "endbmzongfy");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzwIsNull() {
            addCriterion("ENDBMZONGZW is null");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzwIsNotNull() {
            addCriterion("ENDBMZONGZW is not null");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzwEqualTo(BigDecimal value) {
            addCriterion("ENDBMZONGZW =", value, "endbmzongzw");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzwNotEqualTo(BigDecimal value) {
            addCriterion("ENDBMZONGZW <>", value, "endbmzongzw");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzwGreaterThan(BigDecimal value) {
            addCriterion("ENDBMZONGZW >", value, "endbmzongzw");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMZONGZW >=", value, "endbmzongzw");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzwLessThan(BigDecimal value) {
            addCriterion("ENDBMZONGZW <", value, "endbmzongzw");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMZONGZW <=", value, "endbmzongzw");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzwIn(List<BigDecimal> values) {
            addCriterion("ENDBMZONGZW in", values, "endbmzongzw");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzwNotIn(List<BigDecimal> values) {
            addCriterion("ENDBMZONGZW not in", values, "endbmzongzw");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMZONGZW between", value1, value2, "endbmzongzw");
            return (Criteria) this;
        }

        public Criteria andEndbmzongzwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMZONGZW not between", value1, value2, "endbmzongzw");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfwIsNull() {
            addCriterion("ENDBMZONGFW is null");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfwIsNotNull() {
            addCriterion("ENDBMZONGFW is not null");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfwEqualTo(BigDecimal value) {
            addCriterion("ENDBMZONGFW =", value, "endbmzongfw");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfwNotEqualTo(BigDecimal value) {
            addCriterion("ENDBMZONGFW <>", value, "endbmzongfw");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfwGreaterThan(BigDecimal value) {
            addCriterion("ENDBMZONGFW >", value, "endbmzongfw");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMZONGFW >=", value, "endbmzongfw");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfwLessThan(BigDecimal value) {
            addCriterion("ENDBMZONGFW <", value, "endbmzongfw");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMZONGFW <=", value, "endbmzongfw");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfwIn(List<BigDecimal> values) {
            addCriterion("ENDBMZONGFW in", values, "endbmzongfw");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfwNotIn(List<BigDecimal> values) {
            addCriterion("ENDBMZONGFW not in", values, "endbmzongfw");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMZONGFW between", value1, value2, "endbmzongfw");
            return (Criteria) this;
        }

        public Criteria andEndbmzongfwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMZONGFW not between", value1, value2, "endbmzongfw");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzyIsNull() {
            addCriterion("ENDBMJIANZY is null");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzyIsNotNull() {
            addCriterion("ENDBMJIANZY is not null");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzyEqualTo(BigDecimal value) {
            addCriterion("ENDBMJIANZY =", value, "endbmjianzy");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzyNotEqualTo(BigDecimal value) {
            addCriterion("ENDBMJIANZY <>", value, "endbmjianzy");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzyGreaterThan(BigDecimal value) {
            addCriterion("ENDBMJIANZY >", value, "endbmjianzy");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMJIANZY >=", value, "endbmjianzy");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzyLessThan(BigDecimal value) {
            addCriterion("ENDBMJIANZY <", value, "endbmjianzy");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMJIANZY <=", value, "endbmjianzy");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzyIn(List<BigDecimal> values) {
            addCriterion("ENDBMJIANZY in", values, "endbmjianzy");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzyNotIn(List<BigDecimal> values) {
            addCriterion("ENDBMJIANZY not in", values, "endbmjianzy");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMJIANZY between", value1, value2, "endbmjianzy");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMJIANZY not between", value1, value2, "endbmjianzy");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfyIsNull() {
            addCriterion("ENDBMJIANFY is null");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfyIsNotNull() {
            addCriterion("ENDBMJIANFY is not null");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfyEqualTo(BigDecimal value) {
            addCriterion("ENDBMJIANFY =", value, "endbmjianfy");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfyNotEqualTo(BigDecimal value) {
            addCriterion("ENDBMJIANFY <>", value, "endbmjianfy");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfyGreaterThan(BigDecimal value) {
            addCriterion("ENDBMJIANFY >", value, "endbmjianfy");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMJIANFY >=", value, "endbmjianfy");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfyLessThan(BigDecimal value) {
            addCriterion("ENDBMJIANFY <", value, "endbmjianfy");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMJIANFY <=", value, "endbmjianfy");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfyIn(List<BigDecimal> values) {
            addCriterion("ENDBMJIANFY in", values, "endbmjianfy");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfyNotIn(List<BigDecimal> values) {
            addCriterion("ENDBMJIANFY not in", values, "endbmjianfy");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMJIANFY between", value1, value2, "endbmjianfy");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMJIANFY not between", value1, value2, "endbmjianfy");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzwIsNull() {
            addCriterion("ENDBMJIANZW is null");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzwIsNotNull() {
            addCriterion("ENDBMJIANZW is not null");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzwEqualTo(BigDecimal value) {
            addCriterion("ENDBMJIANZW =", value, "endbmjianzw");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzwNotEqualTo(BigDecimal value) {
            addCriterion("ENDBMJIANZW <>", value, "endbmjianzw");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzwGreaterThan(BigDecimal value) {
            addCriterion("ENDBMJIANZW >", value, "endbmjianzw");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMJIANZW >=", value, "endbmjianzw");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzwLessThan(BigDecimal value) {
            addCriterion("ENDBMJIANZW <", value, "endbmjianzw");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMJIANZW <=", value, "endbmjianzw");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzwIn(List<BigDecimal> values) {
            addCriterion("ENDBMJIANZW in", values, "endbmjianzw");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzwNotIn(List<BigDecimal> values) {
            addCriterion("ENDBMJIANZW not in", values, "endbmjianzw");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMJIANZW between", value1, value2, "endbmjianzw");
            return (Criteria) this;
        }

        public Criteria andEndbmjianzwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMJIANZW not between", value1, value2, "endbmjianzw");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfwIsNull() {
            addCriterion("ENDBMJIANFW is null");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfwIsNotNull() {
            addCriterion("ENDBMJIANFW is not null");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfwEqualTo(BigDecimal value) {
            addCriterion("ENDBMJIANFW =", value, "endbmjianfw");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfwNotEqualTo(BigDecimal value) {
            addCriterion("ENDBMJIANFW <>", value, "endbmjianfw");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfwGreaterThan(BigDecimal value) {
            addCriterion("ENDBMJIANFW >", value, "endbmjianfw");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMJIANFW >=", value, "endbmjianfw");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfwLessThan(BigDecimal value) {
            addCriterion("ENDBMJIANFW <", value, "endbmjianfw");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMJIANFW <=", value, "endbmjianfw");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfwIn(List<BigDecimal> values) {
            addCriterion("ENDBMJIANFW in", values, "endbmjianfw");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfwNotIn(List<BigDecimal> values) {
            addCriterion("ENDBMJIANFW not in", values, "endbmjianfw");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMJIANFW between", value1, value2, "endbmjianfw");
            return (Criteria) this;
        }

        public Criteria andEndbmjianfwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMJIANFW not between", value1, value2, "endbmjianfw");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzyIsNull() {
            addCriterion("ENDBMFENGZY is null");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzyIsNotNull() {
            addCriterion("ENDBMFENGZY is not null");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzyEqualTo(BigDecimal value) {
            addCriterion("ENDBMFENGZY =", value, "endbmfengzy");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzyNotEqualTo(BigDecimal value) {
            addCriterion("ENDBMFENGZY <>", value, "endbmfengzy");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzyGreaterThan(BigDecimal value) {
            addCriterion("ENDBMFENGZY >", value, "endbmfengzy");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMFENGZY >=", value, "endbmfengzy");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzyLessThan(BigDecimal value) {
            addCriterion("ENDBMFENGZY <", value, "endbmfengzy");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMFENGZY <=", value, "endbmfengzy");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzyIn(List<BigDecimal> values) {
            addCriterion("ENDBMFENGZY in", values, "endbmfengzy");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzyNotIn(List<BigDecimal> values) {
            addCriterion("ENDBMFENGZY not in", values, "endbmfengzy");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMFENGZY between", value1, value2, "endbmfengzy");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMFENGZY not between", value1, value2, "endbmfengzy");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfyIsNull() {
            addCriterion("ENDBMFENGFY is null");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfyIsNotNull() {
            addCriterion("ENDBMFENGFY is not null");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfyEqualTo(BigDecimal value) {
            addCriterion("ENDBMFENGFY =", value, "endbmfengfy");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfyNotEqualTo(BigDecimal value) {
            addCriterion("ENDBMFENGFY <>", value, "endbmfengfy");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfyGreaterThan(BigDecimal value) {
            addCriterion("ENDBMFENGFY >", value, "endbmfengfy");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMFENGFY >=", value, "endbmfengfy");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfyLessThan(BigDecimal value) {
            addCriterion("ENDBMFENGFY <", value, "endbmfengfy");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMFENGFY <=", value, "endbmfengfy");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfyIn(List<BigDecimal> values) {
            addCriterion("ENDBMFENGFY in", values, "endbmfengfy");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfyNotIn(List<BigDecimal> values) {
            addCriterion("ENDBMFENGFY not in", values, "endbmfengfy");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMFENGFY between", value1, value2, "endbmfengfy");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMFENGFY not between", value1, value2, "endbmfengfy");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzwIsNull() {
            addCriterion("ENDBMFENGZW is null");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzwIsNotNull() {
            addCriterion("ENDBMFENGZW is not null");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzwEqualTo(BigDecimal value) {
            addCriterion("ENDBMFENGZW =", value, "endbmfengzw");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzwNotEqualTo(BigDecimal value) {
            addCriterion("ENDBMFENGZW <>", value, "endbmfengzw");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzwGreaterThan(BigDecimal value) {
            addCriterion("ENDBMFENGZW >", value, "endbmfengzw");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMFENGZW >=", value, "endbmfengzw");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzwLessThan(BigDecimal value) {
            addCriterion("ENDBMFENGZW <", value, "endbmfengzw");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMFENGZW <=", value, "endbmfengzw");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzwIn(List<BigDecimal> values) {
            addCriterion("ENDBMFENGZW in", values, "endbmfengzw");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzwNotIn(List<BigDecimal> values) {
            addCriterion("ENDBMFENGZW not in", values, "endbmfengzw");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMFENGZW between", value1, value2, "endbmfengzw");
            return (Criteria) this;
        }

        public Criteria andEndbmfengzwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMFENGZW not between", value1, value2, "endbmfengzw");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfwIsNull() {
            addCriterion("ENDBMFENGFW is null");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfwIsNotNull() {
            addCriterion("ENDBMFENGFW is not null");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfwEqualTo(BigDecimal value) {
            addCriterion("ENDBMFENGFW =", value, "endbmfengfw");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfwNotEqualTo(BigDecimal value) {
            addCriterion("ENDBMFENGFW <>", value, "endbmfengfw");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfwGreaterThan(BigDecimal value) {
            addCriterion("ENDBMFENGFW >", value, "endbmfengfw");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMFENGFW >=", value, "endbmfengfw");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfwLessThan(BigDecimal value) {
            addCriterion("ENDBMFENGFW <", value, "endbmfengfw");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMFENGFW <=", value, "endbmfengfw");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfwIn(List<BigDecimal> values) {
            addCriterion("ENDBMFENGFW in", values, "endbmfengfw");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfwNotIn(List<BigDecimal> values) {
            addCriterion("ENDBMFENGFW not in", values, "endbmfengfw");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMFENGFW between", value1, value2, "endbmfengfw");
            return (Criteria) this;
        }

        public Criteria andEndbmfengfwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMFENGFW not between", value1, value2, "endbmfengfw");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzyIsNull() {
            addCriterion("ENDBMPINGZY is null");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzyIsNotNull() {
            addCriterion("ENDBMPINGZY is not null");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzyEqualTo(BigDecimal value) {
            addCriterion("ENDBMPINGZY =", value, "endbmpingzy");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzyNotEqualTo(BigDecimal value) {
            addCriterion("ENDBMPINGZY <>", value, "endbmpingzy");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzyGreaterThan(BigDecimal value) {
            addCriterion("ENDBMPINGZY >", value, "endbmpingzy");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMPINGZY >=", value, "endbmpingzy");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzyLessThan(BigDecimal value) {
            addCriterion("ENDBMPINGZY <", value, "endbmpingzy");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMPINGZY <=", value, "endbmpingzy");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzyIn(List<BigDecimal> values) {
            addCriterion("ENDBMPINGZY in", values, "endbmpingzy");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzyNotIn(List<BigDecimal> values) {
            addCriterion("ENDBMPINGZY not in", values, "endbmpingzy");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMPINGZY between", value1, value2, "endbmpingzy");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMPINGZY not between", value1, value2, "endbmpingzy");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfyIsNull() {
            addCriterion("ENDBMPINGFY is null");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfyIsNotNull() {
            addCriterion("ENDBMPINGFY is not null");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfyEqualTo(BigDecimal value) {
            addCriterion("ENDBMPINGFY =", value, "endbmpingfy");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfyNotEqualTo(BigDecimal value) {
            addCriterion("ENDBMPINGFY <>", value, "endbmpingfy");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfyGreaterThan(BigDecimal value) {
            addCriterion("ENDBMPINGFY >", value, "endbmpingfy");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMPINGFY >=", value, "endbmpingfy");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfyLessThan(BigDecimal value) {
            addCriterion("ENDBMPINGFY <", value, "endbmpingfy");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMPINGFY <=", value, "endbmpingfy");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfyIn(List<BigDecimal> values) {
            addCriterion("ENDBMPINGFY in", values, "endbmpingfy");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfyNotIn(List<BigDecimal> values) {
            addCriterion("ENDBMPINGFY not in", values, "endbmpingfy");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMPINGFY between", value1, value2, "endbmpingfy");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMPINGFY not between", value1, value2, "endbmpingfy");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzwIsNull() {
            addCriterion("ENDBMPINGZW is null");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzwIsNotNull() {
            addCriterion("ENDBMPINGZW is not null");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzwEqualTo(BigDecimal value) {
            addCriterion("ENDBMPINGZW =", value, "endbmpingzw");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzwNotEqualTo(BigDecimal value) {
            addCriterion("ENDBMPINGZW <>", value, "endbmpingzw");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzwGreaterThan(BigDecimal value) {
            addCriterion("ENDBMPINGZW >", value, "endbmpingzw");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMPINGZW >=", value, "endbmpingzw");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzwLessThan(BigDecimal value) {
            addCriterion("ENDBMPINGZW <", value, "endbmpingzw");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMPINGZW <=", value, "endbmpingzw");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzwIn(List<BigDecimal> values) {
            addCriterion("ENDBMPINGZW in", values, "endbmpingzw");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzwNotIn(List<BigDecimal> values) {
            addCriterion("ENDBMPINGZW not in", values, "endbmpingzw");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMPINGZW between", value1, value2, "endbmpingzw");
            return (Criteria) this;
        }

        public Criteria andEndbmpingzwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMPINGZW not between", value1, value2, "endbmpingzw");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfwIsNull() {
            addCriterion("ENDBMPINGFW is null");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfwIsNotNull() {
            addCriterion("ENDBMPINGFW is not null");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfwEqualTo(BigDecimal value) {
            addCriterion("ENDBMPINGFW =", value, "endbmpingfw");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfwNotEqualTo(BigDecimal value) {
            addCriterion("ENDBMPINGFW <>", value, "endbmpingfw");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfwGreaterThan(BigDecimal value) {
            addCriterion("ENDBMPINGFW >", value, "endbmpingfw");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMPINGFW >=", value, "endbmpingfw");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfwLessThan(BigDecimal value) {
            addCriterion("ENDBMPINGFW <", value, "endbmpingfw");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMPINGFW <=", value, "endbmpingfw");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfwIn(List<BigDecimal> values) {
            addCriterion("ENDBMPINGFW in", values, "endbmpingfw");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfwNotIn(List<BigDecimal> values) {
            addCriterion("ENDBMPINGFW not in", values, "endbmpingfw");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMPINGFW between", value1, value2, "endbmpingfw");
            return (Criteria) this;
        }

        public Criteria andEndbmpingfwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMPINGFW not between", value1, value2, "endbmpingfw");
            return (Criteria) this;
        }

        public Criteria andEndbmguzyIsNull() {
            addCriterion("ENDBMGUZY is null");
            return (Criteria) this;
        }

        public Criteria andEndbmguzyIsNotNull() {
            addCriterion("ENDBMGUZY is not null");
            return (Criteria) this;
        }

        public Criteria andEndbmguzyEqualTo(BigDecimal value) {
            addCriterion("ENDBMGUZY =", value, "endbmguzy");
            return (Criteria) this;
        }

        public Criteria andEndbmguzyNotEqualTo(BigDecimal value) {
            addCriterion("ENDBMGUZY <>", value, "endbmguzy");
            return (Criteria) this;
        }

        public Criteria andEndbmguzyGreaterThan(BigDecimal value) {
            addCriterion("ENDBMGUZY >", value, "endbmguzy");
            return (Criteria) this;
        }

        public Criteria andEndbmguzyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMGUZY >=", value, "endbmguzy");
            return (Criteria) this;
        }

        public Criteria andEndbmguzyLessThan(BigDecimal value) {
            addCriterion("ENDBMGUZY <", value, "endbmguzy");
            return (Criteria) this;
        }

        public Criteria andEndbmguzyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMGUZY <=", value, "endbmguzy");
            return (Criteria) this;
        }

        public Criteria andEndbmguzyIn(List<BigDecimal> values) {
            addCriterion("ENDBMGUZY in", values, "endbmguzy");
            return (Criteria) this;
        }

        public Criteria andEndbmguzyNotIn(List<BigDecimal> values) {
            addCriterion("ENDBMGUZY not in", values, "endbmguzy");
            return (Criteria) this;
        }

        public Criteria andEndbmguzyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMGUZY between", value1, value2, "endbmguzy");
            return (Criteria) this;
        }

        public Criteria andEndbmguzyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMGUZY not between", value1, value2, "endbmguzy");
            return (Criteria) this;
        }

        public Criteria andEndbmgufyIsNull() {
            addCriterion("ENDBMGUFY is null");
            return (Criteria) this;
        }

        public Criteria andEndbmgufyIsNotNull() {
            addCriterion("ENDBMGUFY is not null");
            return (Criteria) this;
        }

        public Criteria andEndbmgufyEqualTo(BigDecimal value) {
            addCriterion("ENDBMGUFY =", value, "endbmgufy");
            return (Criteria) this;
        }

        public Criteria andEndbmgufyNotEqualTo(BigDecimal value) {
            addCriterion("ENDBMGUFY <>", value, "endbmgufy");
            return (Criteria) this;
        }

        public Criteria andEndbmgufyGreaterThan(BigDecimal value) {
            addCriterion("ENDBMGUFY >", value, "endbmgufy");
            return (Criteria) this;
        }

        public Criteria andEndbmgufyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMGUFY >=", value, "endbmgufy");
            return (Criteria) this;
        }

        public Criteria andEndbmgufyLessThan(BigDecimal value) {
            addCriterion("ENDBMGUFY <", value, "endbmgufy");
            return (Criteria) this;
        }

        public Criteria andEndbmgufyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMGUFY <=", value, "endbmgufy");
            return (Criteria) this;
        }

        public Criteria andEndbmgufyIn(List<BigDecimal> values) {
            addCriterion("ENDBMGUFY in", values, "endbmgufy");
            return (Criteria) this;
        }

        public Criteria andEndbmgufyNotIn(List<BigDecimal> values) {
            addCriterion("ENDBMGUFY not in", values, "endbmgufy");
            return (Criteria) this;
        }

        public Criteria andEndbmgufyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMGUFY between", value1, value2, "endbmgufy");
            return (Criteria) this;
        }

        public Criteria andEndbmgufyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMGUFY not between", value1, value2, "endbmgufy");
            return (Criteria) this;
        }

        public Criteria andEndbmguzwIsNull() {
            addCriterion("ENDBMGUZW is null");
            return (Criteria) this;
        }

        public Criteria andEndbmguzwIsNotNull() {
            addCriterion("ENDBMGUZW is not null");
            return (Criteria) this;
        }

        public Criteria andEndbmguzwEqualTo(BigDecimal value) {
            addCriterion("ENDBMGUZW =", value, "endbmguzw");
            return (Criteria) this;
        }

        public Criteria andEndbmguzwNotEqualTo(BigDecimal value) {
            addCriterion("ENDBMGUZW <>", value, "endbmguzw");
            return (Criteria) this;
        }

        public Criteria andEndbmguzwGreaterThan(BigDecimal value) {
            addCriterion("ENDBMGUZW >", value, "endbmguzw");
            return (Criteria) this;
        }

        public Criteria andEndbmguzwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMGUZW >=", value, "endbmguzw");
            return (Criteria) this;
        }

        public Criteria andEndbmguzwLessThan(BigDecimal value) {
            addCriterion("ENDBMGUZW <", value, "endbmguzw");
            return (Criteria) this;
        }

        public Criteria andEndbmguzwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMGUZW <=", value, "endbmguzw");
            return (Criteria) this;
        }

        public Criteria andEndbmguzwIn(List<BigDecimal> values) {
            addCriterion("ENDBMGUZW in", values, "endbmguzw");
            return (Criteria) this;
        }

        public Criteria andEndbmguzwNotIn(List<BigDecimal> values) {
            addCriterion("ENDBMGUZW not in", values, "endbmguzw");
            return (Criteria) this;
        }

        public Criteria andEndbmguzwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMGUZW between", value1, value2, "endbmguzw");
            return (Criteria) this;
        }

        public Criteria andEndbmguzwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMGUZW not between", value1, value2, "endbmguzw");
            return (Criteria) this;
        }

        public Criteria andEndbmgufwIsNull() {
            addCriterion("ENDBMGUFW is null");
            return (Criteria) this;
        }

        public Criteria andEndbmgufwIsNotNull() {
            addCriterion("ENDBMGUFW is not null");
            return (Criteria) this;
        }

        public Criteria andEndbmgufwEqualTo(BigDecimal value) {
            addCriterion("ENDBMGUFW =", value, "endbmgufw");
            return (Criteria) this;
        }

        public Criteria andEndbmgufwNotEqualTo(BigDecimal value) {
            addCriterion("ENDBMGUFW <>", value, "endbmgufw");
            return (Criteria) this;
        }

        public Criteria andEndbmgufwGreaterThan(BigDecimal value) {
            addCriterion("ENDBMGUFW >", value, "endbmgufw");
            return (Criteria) this;
        }

        public Criteria andEndbmgufwGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMGUFW >=", value, "endbmgufw");
            return (Criteria) this;
        }

        public Criteria andEndbmgufwLessThan(BigDecimal value) {
            addCriterion("ENDBMGUFW <", value, "endbmgufw");
            return (Criteria) this;
        }

        public Criteria andEndbmgufwLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENDBMGUFW <=", value, "endbmgufw");
            return (Criteria) this;
        }

        public Criteria andEndbmgufwIn(List<BigDecimal> values) {
            addCriterion("ENDBMGUFW in", values, "endbmgufw");
            return (Criteria) this;
        }

        public Criteria andEndbmgufwNotIn(List<BigDecimal> values) {
            addCriterion("ENDBMGUFW not in", values, "endbmgufw");
            return (Criteria) this;
        }

        public Criteria andEndbmgufwBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMGUFW between", value1, value2, "endbmgufw");
            return (Criteria) this;
        }

        public Criteria andEndbmgufwNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENDBMGUFW not between", value1, value2, "endbmgufw");
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