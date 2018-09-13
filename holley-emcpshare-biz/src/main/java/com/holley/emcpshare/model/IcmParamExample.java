package com.holley.emcpshare.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IcmParamExample {

    protected String         orderByClause;

    protected boolean        distinct;

    protected List<Criteria> oredCriteria;

    public IcmParamExample() {
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

        public Criteria andMeterNoIsNull() {
            addCriterion("METER_NO is null");
            return (Criteria) this;
        }

        public Criteria andMeterNoIsNotNull() {
            addCriterion("METER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMeterNoEqualTo(String value) {
            addCriterion("METER_NO =", value, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoNotEqualTo(String value) {
            addCriterion("METER_NO <>", value, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoGreaterThan(String value) {
            addCriterion("METER_NO >", value, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoGreaterThanOrEqualTo(String value) {
            addCriterion("METER_NO >=", value, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoLessThan(String value) {
            addCriterion("METER_NO <", value, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoLessThanOrEqualTo(String value) {
            addCriterion("METER_NO <=", value, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoLike(String value) {
            addCriterion("METER_NO like", value, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoNotLike(String value) {
            addCriterion("METER_NO not like", value, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoIn(List<String> values) {
            addCriterion("METER_NO in", values, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoNotIn(List<String> values) {
            addCriterion("METER_NO not in", values, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoBetween(String value1, String value2) {
            addCriterion("METER_NO between", value1, value2, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoNotBetween(String value1, String value2) {
            addCriterion("METER_NO not between", value1, value2, "meterNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoIsNull() {
            addCriterion("FACTORY_NO is null");
            return (Criteria) this;
        }

        public Criteria andFactoryNoIsNotNull() {
            addCriterion("FACTORY_NO is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryNoEqualTo(String value) {
            addCriterion("FACTORY_NO =", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoNotEqualTo(String value) {
            addCriterion("FACTORY_NO <>", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoGreaterThan(String value) {
            addCriterion("FACTORY_NO >", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoGreaterThanOrEqualTo(String value) {
            addCriterion("FACTORY_NO >=", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoLessThan(String value) {
            addCriterion("FACTORY_NO <", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoLessThanOrEqualTo(String value) {
            addCriterion("FACTORY_NO <=", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoLike(String value) {
            addCriterion("FACTORY_NO like", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoNotLike(String value) {
            addCriterion("FACTORY_NO not like", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoIn(List<String> values) {
            addCriterion("FACTORY_NO in", values, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoNotIn(List<String> values) {
            addCriterion("FACTORY_NO not in", values, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoBetween(String value1, String value2) {
            addCriterion("FACTORY_NO between", value1, value2, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoNotBetween(String value1, String value2) {
            addCriterion("FACTORY_NO not between", value1, value2, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyLimitIsNull() {
            addCriterion("ALARM_ENERGY_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyLimitIsNotNull() {
            addCriterion("ALARM_ENERGY_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyLimitEqualTo(BigDecimal value) {
            addCriterion("ALARM_ENERGY_LIMIT =", value, "alarmEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyLimitNotEqualTo(BigDecimal value) {
            addCriterion("ALARM_ENERGY_LIMIT <>", value, "alarmEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyLimitGreaterThan(BigDecimal value) {
            addCriterion("ALARM_ENERGY_LIMIT >", value, "alarmEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ALARM_ENERGY_LIMIT >=", value, "alarmEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyLimitLessThan(BigDecimal value) {
            addCriterion("ALARM_ENERGY_LIMIT <", value, "alarmEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ALARM_ENERGY_LIMIT <=", value, "alarmEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyLimitIn(List<BigDecimal> values) {
            addCriterion("ALARM_ENERGY_LIMIT in", values, "alarmEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyLimitNotIn(List<BigDecimal> values) {
            addCriterion("ALARM_ENERGY_LIMIT not in", values, "alarmEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ALARM_ENERGY_LIMIT between", value1, value2, "alarmEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andAlarmEnergyLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ALARM_ENERGY_LIMIT not between", value1, value2, "alarmEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andHoardEnergyLimitIsNull() {
            addCriterion("HOARD_ENERGY_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andHoardEnergyLimitIsNotNull() {
            addCriterion("HOARD_ENERGY_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andHoardEnergyLimitEqualTo(BigDecimal value) {
            addCriterion("HOARD_ENERGY_LIMIT =", value, "hoardEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andHoardEnergyLimitNotEqualTo(BigDecimal value) {
            addCriterion("HOARD_ENERGY_LIMIT <>", value, "hoardEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andHoardEnergyLimitGreaterThan(BigDecimal value) {
            addCriterion("HOARD_ENERGY_LIMIT >", value, "hoardEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andHoardEnergyLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HOARD_ENERGY_LIMIT >=", value, "hoardEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andHoardEnergyLimitLessThan(BigDecimal value) {
            addCriterion("HOARD_ENERGY_LIMIT <", value, "hoardEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andHoardEnergyLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HOARD_ENERGY_LIMIT <=", value, "hoardEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andHoardEnergyLimitIn(List<BigDecimal> values) {
            addCriterion("HOARD_ENERGY_LIMIT in", values, "hoardEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andHoardEnergyLimitNotIn(List<BigDecimal> values) {
            addCriterion("HOARD_ENERGY_LIMIT not in", values, "hoardEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andHoardEnergyLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOARD_ENERGY_LIMIT between", value1, value2, "hoardEnergyLimit");
            return (Criteria) this;
        }

        public Criteria andHoardEnergyLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOARD_ENERGY_LIMIT not between", value1, value2, "hoardEnergyLimit");
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

        public Criteria andPLimitIsNull() {
            addCriterion("P_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andPLimitIsNotNull() {
            addCriterion("P_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andPLimitEqualTo(BigDecimal value) {
            addCriterion("P_LIMIT =", value, "pLimit");
            return (Criteria) this;
        }

        public Criteria andPLimitNotEqualTo(BigDecimal value) {
            addCriterion("P_LIMIT <>", value, "pLimit");
            return (Criteria) this;
        }

        public Criteria andPLimitGreaterThan(BigDecimal value) {
            addCriterion("P_LIMIT >", value, "pLimit");
            return (Criteria) this;
        }

        public Criteria andPLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("P_LIMIT >=", value, "pLimit");
            return (Criteria) this;
        }

        public Criteria andPLimitLessThan(BigDecimal value) {
            addCriterion("P_LIMIT <", value, "pLimit");
            return (Criteria) this;
        }

        public Criteria andPLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("P_LIMIT <=", value, "pLimit");
            return (Criteria) this;
        }

        public Criteria andPLimitIn(List<BigDecimal> values) {
            addCriterion("P_LIMIT in", values, "pLimit");
            return (Criteria) this;
        }

        public Criteria andPLimitNotIn(List<BigDecimal> values) {
            addCriterion("P_LIMIT not in", values, "pLimit");
            return (Criteria) this;
        }

        public Criteria andPLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("P_LIMIT between", value1, value2, "pLimit");
            return (Criteria) this;
        }

        public Criteria andPLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("P_LIMIT not between", value1, value2, "pLimit");
            return (Criteria) this;
        }

        public Criteria andRegisterNoIsNull() {
            addCriterion("REGISTER_NO is null");
            return (Criteria) this;
        }

        public Criteria andRegisterNoIsNotNull() {
            addCriterion("REGISTER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterNoEqualTo(String value) {
            addCriterion("REGISTER_NO =", value, "registerNo");
            return (Criteria) this;
        }

        public Criteria andRegisterNoNotEqualTo(String value) {
            addCriterion("REGISTER_NO <>", value, "registerNo");
            return (Criteria) this;
        }

        public Criteria andRegisterNoGreaterThan(String value) {
            addCriterion("REGISTER_NO >", value, "registerNo");
            return (Criteria) this;
        }

        public Criteria andRegisterNoGreaterThanOrEqualTo(String value) {
            addCriterion("REGISTER_NO >=", value, "registerNo");
            return (Criteria) this;
        }

        public Criteria andRegisterNoLessThan(String value) {
            addCriterion("REGISTER_NO <", value, "registerNo");
            return (Criteria) this;
        }

        public Criteria andRegisterNoLessThanOrEqualTo(String value) {
            addCriterion("REGISTER_NO <=", value, "registerNo");
            return (Criteria) this;
        }

        public Criteria andRegisterNoLike(String value) {
            addCriterion("REGISTER_NO like", value, "registerNo");
            return (Criteria) this;
        }

        public Criteria andRegisterNoNotLike(String value) {
            addCriterion("REGISTER_NO not like", value, "registerNo");
            return (Criteria) this;
        }

        public Criteria andRegisterNoIn(List<String> values) {
            addCriterion("REGISTER_NO in", values, "registerNo");
            return (Criteria) this;
        }

        public Criteria andRegisterNoNotIn(List<String> values) {
            addCriterion("REGISTER_NO not in", values, "registerNo");
            return (Criteria) this;
        }

        public Criteria andRegisterNoBetween(String value1, String value2) {
            addCriterion("REGISTER_NO between", value1, value2, "registerNo");
            return (Criteria) this;
        }

        public Criteria andRegisterNoNotBetween(String value1, String value2) {
            addCriterion("REGISTER_NO not between", value1, value2, "registerNo");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNull() {
            addCriterion("CUSTOMER_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("CUSTOMER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Integer value) {
            addCriterion("CUSTOMER_ID =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Integer value) {
            addCriterion("CUSTOMER_ID <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Integer value) {
            addCriterion("CUSTOMER_ID >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CUSTOMER_ID >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Integer value) {
            addCriterion("CUSTOMER_ID <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("CUSTOMER_ID <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Integer> values) {
            addCriterion("CUSTOMER_ID in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Integer> values) {
            addCriterion("CUSTOMER_ID not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("CUSTOMER_ID between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CUSTOMER_ID not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerNoIsNull() {
            addCriterion("CUSTOMER_NO is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNoIsNotNull() {
            addCriterion("CUSTOMER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNoEqualTo(String value) {
            addCriterion("CUSTOMER_NO =", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoNotEqualTo(String value) {
            addCriterion("CUSTOMER_NO <>", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoGreaterThan(String value) {
            addCriterion("CUSTOMER_NO >", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOMER_NO >=", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoLessThan(String value) {
            addCriterion("CUSTOMER_NO <", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoLessThanOrEqualTo(String value) {
            addCriterion("CUSTOMER_NO <=", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoLike(String value) {
            addCriterion("CUSTOMER_NO like", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoNotLike(String value) {
            addCriterion("CUSTOMER_NO not like", value, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoIn(List<String> values) {
            addCriterion("CUSTOMER_NO in", values, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoNotIn(List<String> values) {
            addCriterion("CUSTOMER_NO not in", values, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoBetween(String value1, String value2) {
            addCriterion("CUSTOMER_NO between", value1, value2, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCustomerNoNotBetween(String value1, String value2) {
            addCriterion("CUSTOMER_NO not between", value1, value2, "customerNo");
            return (Criteria) this;
        }

        public Criteria andCardCountIsNull() {
            addCriterion("CARD_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andCardCountIsNotNull() {
            addCriterion("CARD_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCardCountEqualTo(Integer value) {
            addCriterion("CARD_COUNT =", value, "cardCount");
            return (Criteria) this;
        }

        public Criteria andCardCountNotEqualTo(Integer value) {
            addCriterion("CARD_COUNT <>", value, "cardCount");
            return (Criteria) this;
        }

        public Criteria andCardCountGreaterThan(Integer value) {
            addCriterion("CARD_COUNT >", value, "cardCount");
            return (Criteria) this;
        }

        public Criteria andCardCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("CARD_COUNT >=", value, "cardCount");
            return (Criteria) this;
        }

        public Criteria andCardCountLessThan(Integer value) {
            addCriterion("CARD_COUNT <", value, "cardCount");
            return (Criteria) this;
        }

        public Criteria andCardCountLessThanOrEqualTo(Integer value) {
            addCriterion("CARD_COUNT <=", value, "cardCount");
            return (Criteria) this;
        }

        public Criteria andCardCountIn(List<Integer> values) {
            addCriterion("CARD_COUNT in", values, "cardCount");
            return (Criteria) this;
        }

        public Criteria andCardCountNotIn(List<Integer> values) {
            addCriterion("CARD_COUNT not in", values, "cardCount");
            return (Criteria) this;
        }

        public Criteria andCardCountBetween(Integer value1, Integer value2) {
            addCriterion("CARD_COUNT between", value1, value2, "cardCount");
            return (Criteria) this;
        }

        public Criteria andCardCountNotBetween(Integer value1, Integer value2) {
            addCriterion("CARD_COUNT not between", value1, value2, "cardCount");
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

        private String  condition;

        private Object  value;

        private Object  secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String  typeHandler;

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
