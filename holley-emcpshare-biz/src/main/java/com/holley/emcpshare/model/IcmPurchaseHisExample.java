package com.holley.emcpshare.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IcmPurchaseHisExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IcmPurchaseHisExample() {
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

        public Criteria andDataTimeIsNull() {
            addCriterion("DATA_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDataTimeIsNotNull() {
            addCriterion("DATA_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDataTimeEqualTo(Date value) {
            addCriterion("DATA_TIME =", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeNotEqualTo(Date value) {
            addCriterion("DATA_TIME <>", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeGreaterThan(Date value) {
            addCriterion("DATA_TIME >", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DATA_TIME >=", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeLessThan(Date value) {
            addCriterion("DATA_TIME <", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeLessThanOrEqualTo(Date value) {
            addCriterion("DATA_TIME <=", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeIn(List<Date> values) {
            addCriterion("DATA_TIME in", values, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeNotIn(List<Date> values) {
            addCriterion("DATA_TIME not in", values, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeBetween(Date value1, Date value2) {
            addCriterion("DATA_TIME between", value1, value2, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeNotBetween(Date value1, Date value2) {
            addCriterion("DATA_TIME not between", value1, value2, "dataTime");
            return (Criteria) this;
        }

        public Criteria andPointIdIsNull() {
            addCriterion("POINT_ID is null");
            return (Criteria) this;
        }

        public Criteria andPointIdIsNotNull() {
            addCriterion("POINT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPointIdEqualTo(Integer value) {
            addCriterion("POINT_ID =", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdNotEqualTo(Integer value) {
            addCriterion("POINT_ID <>", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdGreaterThan(Integer value) {
            addCriterion("POINT_ID >", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("POINT_ID >=", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdLessThan(Integer value) {
            addCriterion("POINT_ID <", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdLessThanOrEqualTo(Integer value) {
            addCriterion("POINT_ID <=", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdIn(List<Integer> values) {
            addCriterion("POINT_ID in", values, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdNotIn(List<Integer> values) {
            addCriterion("POINT_ID not in", values, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdBetween(Integer value1, Integer value2) {
            addCriterion("POINT_ID between", value1, value2, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdNotBetween(Integer value1, Integer value2) {
            addCriterion("POINT_ID not between", value1, value2, "pointId");
            return (Criteria) this;
        }

        public Criteria andBuyCountIsNull() {
            addCriterion("BUY_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andBuyCountIsNotNull() {
            addCriterion("BUY_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBuyCountEqualTo(Integer value) {
            addCriterion("BUY_COUNT =", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountNotEqualTo(Integer value) {
            addCriterion("BUY_COUNT <>", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountGreaterThan(Integer value) {
            addCriterion("BUY_COUNT >", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("BUY_COUNT >=", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountLessThan(Integer value) {
            addCriterion("BUY_COUNT <", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountLessThanOrEqualTo(Integer value) {
            addCriterion("BUY_COUNT <=", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountIn(List<Integer> values) {
            addCriterion("BUY_COUNT in", values, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountNotIn(List<Integer> values) {
            addCriterion("BUY_COUNT not in", values, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountBetween(Integer value1, Integer value2) {
            addCriterion("BUY_COUNT between", value1, value2, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("BUY_COUNT not between", value1, value2, "buyCount");
            return (Criteria) this;
        }

        public Criteria andSurplusMoneyIsNull() {
            addCriterion("SURPLUS_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andSurplusMoneyIsNotNull() {
            addCriterion("SURPLUS_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andSurplusMoneyEqualTo(BigDecimal value) {
            addCriterion("SURPLUS_MONEY =", value, "surplusMoney");
            return (Criteria) this;
        }

        public Criteria andSurplusMoneyNotEqualTo(BigDecimal value) {
            addCriterion("SURPLUS_MONEY <>", value, "surplusMoney");
            return (Criteria) this;
        }

        public Criteria andSurplusMoneyGreaterThan(BigDecimal value) {
            addCriterion("SURPLUS_MONEY >", value, "surplusMoney");
            return (Criteria) this;
        }

        public Criteria andSurplusMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SURPLUS_MONEY >=", value, "surplusMoney");
            return (Criteria) this;
        }

        public Criteria andSurplusMoneyLessThan(BigDecimal value) {
            addCriterion("SURPLUS_MONEY <", value, "surplusMoney");
            return (Criteria) this;
        }

        public Criteria andSurplusMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SURPLUS_MONEY <=", value, "surplusMoney");
            return (Criteria) this;
        }

        public Criteria andSurplusMoneyIn(List<BigDecimal> values) {
            addCriterion("SURPLUS_MONEY in", values, "surplusMoney");
            return (Criteria) this;
        }

        public Criteria andSurplusMoneyNotIn(List<BigDecimal> values) {
            addCriterion("SURPLUS_MONEY not in", values, "surplusMoney");
            return (Criteria) this;
        }

        public Criteria andSurplusMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SURPLUS_MONEY between", value1, value2, "surplusMoney");
            return (Criteria) this;
        }

        public Criteria andSurplusMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SURPLUS_MONEY not between", value1, value2, "surplusMoney");
            return (Criteria) this;
        }

        public Criteria andTotalBuyMoneyIsNull() {
            addCriterion("TOTAL_BUY_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andTotalBuyMoneyIsNotNull() {
            addCriterion("TOTAL_BUY_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andTotalBuyMoneyEqualTo(BigDecimal value) {
            addCriterion("TOTAL_BUY_MONEY =", value, "totalBuyMoney");
            return (Criteria) this;
        }

        public Criteria andTotalBuyMoneyNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_BUY_MONEY <>", value, "totalBuyMoney");
            return (Criteria) this;
        }

        public Criteria andTotalBuyMoneyGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_BUY_MONEY >", value, "totalBuyMoney");
            return (Criteria) this;
        }

        public Criteria andTotalBuyMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_BUY_MONEY >=", value, "totalBuyMoney");
            return (Criteria) this;
        }

        public Criteria andTotalBuyMoneyLessThan(BigDecimal value) {
            addCriterion("TOTAL_BUY_MONEY <", value, "totalBuyMoney");
            return (Criteria) this;
        }

        public Criteria andTotalBuyMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_BUY_MONEY <=", value, "totalBuyMoney");
            return (Criteria) this;
        }

        public Criteria andTotalBuyMoneyIn(List<BigDecimal> values) {
            addCriterion("TOTAL_BUY_MONEY in", values, "totalBuyMoney");
            return (Criteria) this;
        }

        public Criteria andTotalBuyMoneyNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_BUY_MONEY not in", values, "totalBuyMoney");
            return (Criteria) this;
        }

        public Criteria andTotalBuyMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_BUY_MONEY between", value1, value2, "totalBuyMoney");
            return (Criteria) this;
        }

        public Criteria andTotalBuyMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_BUY_MONEY not between", value1, value2, "totalBuyMoney");
            return (Criteria) this;
        }

        public Criteria andSurplusEnergyIsNull() {
            addCriterion("SURPLUS_ENERGY is null");
            return (Criteria) this;
        }

        public Criteria andSurplusEnergyIsNotNull() {
            addCriterion("SURPLUS_ENERGY is not null");
            return (Criteria) this;
        }

        public Criteria andSurplusEnergyEqualTo(BigDecimal value) {
            addCriterion("SURPLUS_ENERGY =", value, "surplusEnergy");
            return (Criteria) this;
        }

        public Criteria andSurplusEnergyNotEqualTo(BigDecimal value) {
            addCriterion("SURPLUS_ENERGY <>", value, "surplusEnergy");
            return (Criteria) this;
        }

        public Criteria andSurplusEnergyGreaterThan(BigDecimal value) {
            addCriterion("SURPLUS_ENERGY >", value, "surplusEnergy");
            return (Criteria) this;
        }

        public Criteria andSurplusEnergyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SURPLUS_ENERGY >=", value, "surplusEnergy");
            return (Criteria) this;
        }

        public Criteria andSurplusEnergyLessThan(BigDecimal value) {
            addCriterion("SURPLUS_ENERGY <", value, "surplusEnergy");
            return (Criteria) this;
        }

        public Criteria andSurplusEnergyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SURPLUS_ENERGY <=", value, "surplusEnergy");
            return (Criteria) this;
        }

        public Criteria andSurplusEnergyIn(List<BigDecimal> values) {
            addCriterion("SURPLUS_ENERGY in", values, "surplusEnergy");
            return (Criteria) this;
        }

        public Criteria andSurplusEnergyNotIn(List<BigDecimal> values) {
            addCriterion("SURPLUS_ENERGY not in", values, "surplusEnergy");
            return (Criteria) this;
        }

        public Criteria andSurplusEnergyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SURPLUS_ENERGY between", value1, value2, "surplusEnergy");
            return (Criteria) this;
        }

        public Criteria andSurplusEnergyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SURPLUS_ENERGY not between", value1, value2, "surplusEnergy");
            return (Criteria) this;
        }

        public Criteria andOverdrawEnergyIsNull() {
            addCriterion("OVERDRAW_ENERGY is null");
            return (Criteria) this;
        }

        public Criteria andOverdrawEnergyIsNotNull() {
            addCriterion("OVERDRAW_ENERGY is not null");
            return (Criteria) this;
        }

        public Criteria andOverdrawEnergyEqualTo(BigDecimal value) {
            addCriterion("OVERDRAW_ENERGY =", value, "overdrawEnergy");
            return (Criteria) this;
        }

        public Criteria andOverdrawEnergyNotEqualTo(BigDecimal value) {
            addCriterion("OVERDRAW_ENERGY <>", value, "overdrawEnergy");
            return (Criteria) this;
        }

        public Criteria andOverdrawEnergyGreaterThan(BigDecimal value) {
            addCriterion("OVERDRAW_ENERGY >", value, "overdrawEnergy");
            return (Criteria) this;
        }

        public Criteria andOverdrawEnergyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OVERDRAW_ENERGY >=", value, "overdrawEnergy");
            return (Criteria) this;
        }

        public Criteria andOverdrawEnergyLessThan(BigDecimal value) {
            addCriterion("OVERDRAW_ENERGY <", value, "overdrawEnergy");
            return (Criteria) this;
        }

        public Criteria andOverdrawEnergyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OVERDRAW_ENERGY <=", value, "overdrawEnergy");
            return (Criteria) this;
        }

        public Criteria andOverdrawEnergyIn(List<BigDecimal> values) {
            addCriterion("OVERDRAW_ENERGY in", values, "overdrawEnergy");
            return (Criteria) this;
        }

        public Criteria andOverdrawEnergyNotIn(List<BigDecimal> values) {
            addCriterion("OVERDRAW_ENERGY not in", values, "overdrawEnergy");
            return (Criteria) this;
        }

        public Criteria andOverdrawEnergyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OVERDRAW_ENERGY between", value1, value2, "overdrawEnergy");
            return (Criteria) this;
        }

        public Criteria andOverdrawEnergyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OVERDRAW_ENERGY not between", value1, value2, "overdrawEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalBuyEnergyIsNull() {
            addCriterion("TOTAL_BUY_ENERGY is null");
            return (Criteria) this;
        }

        public Criteria andTotalBuyEnergyIsNotNull() {
            addCriterion("TOTAL_BUY_ENERGY is not null");
            return (Criteria) this;
        }

        public Criteria andTotalBuyEnergyEqualTo(BigDecimal value) {
            addCriterion("TOTAL_BUY_ENERGY =", value, "totalBuyEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalBuyEnergyNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_BUY_ENERGY <>", value, "totalBuyEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalBuyEnergyGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_BUY_ENERGY >", value, "totalBuyEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalBuyEnergyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_BUY_ENERGY >=", value, "totalBuyEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalBuyEnergyLessThan(BigDecimal value) {
            addCriterion("TOTAL_BUY_ENERGY <", value, "totalBuyEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalBuyEnergyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_BUY_ENERGY <=", value, "totalBuyEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalBuyEnergyIn(List<BigDecimal> values) {
            addCriterion("TOTAL_BUY_ENERGY in", values, "totalBuyEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalBuyEnergyNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_BUY_ENERGY not in", values, "totalBuyEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalBuyEnergyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_BUY_ENERGY between", value1, value2, "totalBuyEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalBuyEnergyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_BUY_ENERGY not between", value1, value2, "totalBuyEnergy");
            return (Criteria) this;
        }

        public Criteria andCreditEnergyLimitIsNull() {
            addCriterion("CREDIT_ENERGY_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andCreditEnergyLimitIsNotNull() {
            addCriterion("CREDIT_ENERGY_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andCreditEnergyLimitEqualTo(BigDecimal value) {
            addCriterion("CREDIT_ENERGY_LIMIT =", value, "creditEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andCreditEnergyLimitNotEqualTo(BigDecimal value) {
            addCriterion("CREDIT_ENERGY_LIMIT <>", value, "creditEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andCreditEnergyLimitGreaterThan(BigDecimal value) {
            addCriterion("CREDIT_ENERGY_LIMIT >", value, "creditEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andCreditEnergyLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_ENERGY_LIMIT >=", value, "creditEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andCreditEnergyLimitLessThan(BigDecimal value) {
            addCriterion("CREDIT_ENERGY_LIMIT <", value, "creditEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andCreditEnergyLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_ENERGY_LIMIT <=", value, "creditEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andCreditEnergyLimitIn(List<BigDecimal> values) {
            addCriterion("CREDIT_ENERGY_LIMIT in", values, "creditEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andCreditEnergyLimitNotIn(List<BigDecimal> values) {
            addCriterion("CREDIT_ENERGY_LIMIT not in", values, "creditEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andCreditEnergyLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_ENERGY_LIMIT between", value1, value2, "creditEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andCreditEnergyLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_ENERGY_LIMIT not between", value1, value2, "creditEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyIsNull() {
            addCriterion("ALARM_ENERGY is null");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyIsNotNull() {
            addCriterion("ALARM_ENERGY is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyEqualTo(BigDecimal value) {
            addCriterion("ALARM_ENERGY =", value, "alarmEnergy");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyNotEqualTo(BigDecimal value) {
            addCriterion("ALARM_ENERGY <>", value, "alarmEnergy");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyGreaterThan(BigDecimal value) {
            addCriterion("ALARM_ENERGY >", value, "alarmEnergy");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ALARM_ENERGY >=", value, "alarmEnergy");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyLessThan(BigDecimal value) {
            addCriterion("ALARM_ENERGY <", value, "alarmEnergy");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ALARM_ENERGY <=", value, "alarmEnergy");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyIn(List<BigDecimal> values) {
            addCriterion("ALARM_ENERGY in", values, "alarmEnergy");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyNotIn(List<BigDecimal> values) {
            addCriterion("ALARM_ENERGY not in", values, "alarmEnergy");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ALARM_ENERGY between", value1, value2, "alarmEnergy");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ALARM_ENERGY not between", value1, value2, "alarmEnergy");
            return (Criteria) this;
        }

        public Criteria andFaultEnergyIsNull() {
            addCriterion("FAULT_ENERGY is null");
            return (Criteria) this;
        }

        public Criteria andFaultEnergyIsNotNull() {
            addCriterion("FAULT_ENERGY is not null");
            return (Criteria) this;
        }

        public Criteria andFaultEnergyEqualTo(BigDecimal value) {
            addCriterion("FAULT_ENERGY =", value, "faultEnergy");
            return (Criteria) this;
        }

        public Criteria andFaultEnergyNotEqualTo(BigDecimal value) {
            addCriterion("FAULT_ENERGY <>", value, "faultEnergy");
            return (Criteria) this;
        }

        public Criteria andFaultEnergyGreaterThan(BigDecimal value) {
            addCriterion("FAULT_ENERGY >", value, "faultEnergy");
            return (Criteria) this;
        }

        public Criteria andFaultEnergyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FAULT_ENERGY >=", value, "faultEnergy");
            return (Criteria) this;
        }

        public Criteria andFaultEnergyLessThan(BigDecimal value) {
            addCriterion("FAULT_ENERGY <", value, "faultEnergy");
            return (Criteria) this;
        }

        public Criteria andFaultEnergyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FAULT_ENERGY <=", value, "faultEnergy");
            return (Criteria) this;
        }

        public Criteria andFaultEnergyIn(List<BigDecimal> values) {
            addCriterion("FAULT_ENERGY in", values, "faultEnergy");
            return (Criteria) this;
        }

        public Criteria andFaultEnergyNotIn(List<BigDecimal> values) {
            addCriterion("FAULT_ENERGY not in", values, "faultEnergy");
            return (Criteria) this;
        }

        public Criteria andFaultEnergyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAULT_ENERGY between", value1, value2, "faultEnergy");
            return (Criteria) this;
        }

        public Criteria andFaultEnergyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAULT_ENERGY not between", value1, value2, "faultEnergy");
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

        public Criteria andDataSourceIsNull() {
            addCriterion("DATA_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceIsNotNull() {
            addCriterion("DATA_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceEqualTo(Short value) {
            addCriterion("DATA_SOURCE =", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotEqualTo(Short value) {
            addCriterion("DATA_SOURCE <>", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThan(Short value) {
            addCriterion("DATA_SOURCE >", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThanOrEqualTo(Short value) {
            addCriterion("DATA_SOURCE >=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThan(Short value) {
            addCriterion("DATA_SOURCE <", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThanOrEqualTo(Short value) {
            addCriterion("DATA_SOURCE <=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceIn(List<Short> values) {
            addCriterion("DATA_SOURCE in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotIn(List<Short> values) {
            addCriterion("DATA_SOURCE not in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceBetween(Short value1, Short value2) {
            addCriterion("DATA_SOURCE between", value1, value2, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotBetween(Short value1, Short value2) {
            addCriterion("DATA_SOURCE not between", value1, value2, "dataSource");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("ADD_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("ADD_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("ADD_TIME =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("ADD_TIME <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("ADD_TIME >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ADD_TIME >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("ADD_TIME <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("ADD_TIME <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("ADD_TIME in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("ADD_TIME not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("ADD_TIME between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("ADD_TIME not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
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