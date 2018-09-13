package com.holley.emcpshare.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IcmOperateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IcmOperateExample() {
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

        public Criteria andOperateTimeIsNull() {
            addCriterion("OPERATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIsNotNull() {
            addCriterion("OPERATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOperateTimeEqualTo(Date value) {
            addCriterion("OPERATE_TIME =", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotEqualTo(Date value) {
            addCriterion("OPERATE_TIME <>", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeGreaterThan(Date value) {
            addCriterion("OPERATE_TIME >", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OPERATE_TIME >=", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeLessThan(Date value) {
            addCriterion("OPERATE_TIME <", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeLessThanOrEqualTo(Date value) {
            addCriterion("OPERATE_TIME <=", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIn(List<Date> values) {
            addCriterion("OPERATE_TIME in", values, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotIn(List<Date> values) {
            addCriterion("OPERATE_TIME not in", values, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeBetween(Date value1, Date value2) {
            addCriterion("OPERATE_TIME between", value1, value2, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotBetween(Date value1, Date value2) {
            addCriterion("OPERATE_TIME not between", value1, value2, "operateTime");
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

        public Criteria andOperateTypeIsNull() {
            addCriterion("OPERATE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIsNotNull() {
            addCriterion("OPERATE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOperateTypeEqualTo(Short value) {
            addCriterion("OPERATE_TYPE =", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotEqualTo(Short value) {
            addCriterion("OPERATE_TYPE <>", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeGreaterThan(Short value) {
            addCriterion("OPERATE_TYPE >", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("OPERATE_TYPE >=", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeLessThan(Short value) {
            addCriterion("OPERATE_TYPE <", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeLessThanOrEqualTo(Short value) {
            addCriterion("OPERATE_TYPE <=", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIn(List<Short> values) {
            addCriterion("OPERATE_TYPE in", values, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotIn(List<Short> values) {
            addCriterion("OPERATE_TYPE not in", values, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeBetween(Short value1, Short value2) {
            addCriterion("OPERATE_TYPE between", value1, value2, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotBetween(Short value1, Short value2) {
            addCriterion("OPERATE_TYPE not between", value1, value2, "operateType");
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

        public Criteria andBuyMoneyIsNull() {
            addCriterion("BUY_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyIsNotNull() {
            addCriterion("BUY_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyEqualTo(BigDecimal value) {
            addCriterion("BUY_MONEY =", value, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyNotEqualTo(BigDecimal value) {
            addCriterion("BUY_MONEY <>", value, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyGreaterThan(BigDecimal value) {
            addCriterion("BUY_MONEY >", value, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BUY_MONEY >=", value, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyLessThan(BigDecimal value) {
            addCriterion("BUY_MONEY <", value, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BUY_MONEY <=", value, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyIn(List<BigDecimal> values) {
            addCriterion("BUY_MONEY in", values, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyNotIn(List<BigDecimal> values) {
            addCriterion("BUY_MONEY not in", values, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUY_MONEY between", value1, value2, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUY_MONEY not between", value1, value2, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyEnergyIsNull() {
            addCriterion("BUY_ENERGY is null");
            return (Criteria) this;
        }

        public Criteria andBuyEnergyIsNotNull() {
            addCriterion("BUY_ENERGY is not null");
            return (Criteria) this;
        }

        public Criteria andBuyEnergyEqualTo(BigDecimal value) {
            addCriterion("BUY_ENERGY =", value, "buyEnergy");
            return (Criteria) this;
        }

        public Criteria andBuyEnergyNotEqualTo(BigDecimal value) {
            addCriterion("BUY_ENERGY <>", value, "buyEnergy");
            return (Criteria) this;
        }

        public Criteria andBuyEnergyGreaterThan(BigDecimal value) {
            addCriterion("BUY_ENERGY >", value, "buyEnergy");
            return (Criteria) this;
        }

        public Criteria andBuyEnergyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BUY_ENERGY >=", value, "buyEnergy");
            return (Criteria) this;
        }

        public Criteria andBuyEnergyLessThan(BigDecimal value) {
            addCriterion("BUY_ENERGY <", value, "buyEnergy");
            return (Criteria) this;
        }

        public Criteria andBuyEnergyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BUY_ENERGY <=", value, "buyEnergy");
            return (Criteria) this;
        }

        public Criteria andBuyEnergyIn(List<BigDecimal> values) {
            addCriterion("BUY_ENERGY in", values, "buyEnergy");
            return (Criteria) this;
        }

        public Criteria andBuyEnergyNotIn(List<BigDecimal> values) {
            addCriterion("BUY_ENERGY not in", values, "buyEnergy");
            return (Criteria) this;
        }

        public Criteria andBuyEnergyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUY_ENERGY between", value1, value2, "buyEnergy");
            return (Criteria) this;
        }

        public Criteria andBuyEnergyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUY_ENERGY not between", value1, value2, "buyEnergy");
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

        public Criteria andOperatorNoIsNull() {
            addCriterion("OPERATOR_NO is null");
            return (Criteria) this;
        }

        public Criteria andOperatorNoIsNotNull() {
            addCriterion("OPERATOR_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorNoEqualTo(String value) {
            addCriterion("OPERATOR_NO =", value, "operatorNo");
            return (Criteria) this;
        }

        public Criteria andOperatorNoNotEqualTo(String value) {
            addCriterion("OPERATOR_NO <>", value, "operatorNo");
            return (Criteria) this;
        }

        public Criteria andOperatorNoGreaterThan(String value) {
            addCriterion("OPERATOR_NO >", value, "operatorNo");
            return (Criteria) this;
        }

        public Criteria andOperatorNoGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATOR_NO >=", value, "operatorNo");
            return (Criteria) this;
        }

        public Criteria andOperatorNoLessThan(String value) {
            addCriterion("OPERATOR_NO <", value, "operatorNo");
            return (Criteria) this;
        }

        public Criteria andOperatorNoLessThanOrEqualTo(String value) {
            addCriterion("OPERATOR_NO <=", value, "operatorNo");
            return (Criteria) this;
        }

        public Criteria andOperatorNoLike(String value) {
            addCriterion("OPERATOR_NO like", value, "operatorNo");
            return (Criteria) this;
        }

        public Criteria andOperatorNoNotLike(String value) {
            addCriterion("OPERATOR_NO not like", value, "operatorNo");
            return (Criteria) this;
        }

        public Criteria andOperatorNoIn(List<String> values) {
            addCriterion("OPERATOR_NO in", values, "operatorNo");
            return (Criteria) this;
        }

        public Criteria andOperatorNoNotIn(List<String> values) {
            addCriterion("OPERATOR_NO not in", values, "operatorNo");
            return (Criteria) this;
        }

        public Criteria andOperatorNoBetween(String value1, String value2) {
            addCriterion("OPERATOR_NO between", value1, value2, "operatorNo");
            return (Criteria) this;
        }

        public Criteria andOperatorNoNotBetween(String value1, String value2) {
            addCriterion("OPERATOR_NO not between", value1, value2, "operatorNo");
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

        public Criteria andOperateModeIsNull() {
            addCriterion("OPERATE_MODE is null");
            return (Criteria) this;
        }

        public Criteria andOperateModeIsNotNull() {
            addCriterion("OPERATE_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andOperateModeEqualTo(Short value) {
            addCriterion("OPERATE_MODE =", value, "operateMode");
            return (Criteria) this;
        }

        public Criteria andOperateModeNotEqualTo(Short value) {
            addCriterion("OPERATE_MODE <>", value, "operateMode");
            return (Criteria) this;
        }

        public Criteria andOperateModeGreaterThan(Short value) {
            addCriterion("OPERATE_MODE >", value, "operateMode");
            return (Criteria) this;
        }

        public Criteria andOperateModeGreaterThanOrEqualTo(Short value) {
            addCriterion("OPERATE_MODE >=", value, "operateMode");
            return (Criteria) this;
        }

        public Criteria andOperateModeLessThan(Short value) {
            addCriterion("OPERATE_MODE <", value, "operateMode");
            return (Criteria) this;
        }

        public Criteria andOperateModeLessThanOrEqualTo(Short value) {
            addCriterion("OPERATE_MODE <=", value, "operateMode");
            return (Criteria) this;
        }

        public Criteria andOperateModeIn(List<Short> values) {
            addCriterion("OPERATE_MODE in", values, "operateMode");
            return (Criteria) this;
        }

        public Criteria andOperateModeNotIn(List<Short> values) {
            addCriterion("OPERATE_MODE not in", values, "operateMode");
            return (Criteria) this;
        }

        public Criteria andOperateModeBetween(Short value1, Short value2) {
            addCriterion("OPERATE_MODE between", value1, value2, "operateMode");
            return (Criteria) this;
        }

        public Criteria andOperateModeNotBetween(Short value1, Short value2) {
            addCriterion("OPERATE_MODE not between", value1, value2, "operateMode");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("ACCOUNT =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("ACCOUNT <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("ACCOUNT >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("ACCOUNT <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("ACCOUNT like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("ACCOUNT not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("ACCOUNT in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("ACCOUNT not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("ACCOUNT between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT not between", value1, value2, "account");
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

        public Criteria andErrorCodeIsNull() {
            addCriterion("ERROR_CODE is null");
            return (Criteria) this;
        }

        public Criteria andErrorCodeIsNotNull() {
            addCriterion("ERROR_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andErrorCodeEqualTo(String value) {
            addCriterion("ERROR_CODE =", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeNotEqualTo(String value) {
            addCriterion("ERROR_CODE <>", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeGreaterThan(String value) {
            addCriterion("ERROR_CODE >", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ERROR_CODE >=", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeLessThan(String value) {
            addCriterion("ERROR_CODE <", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeLessThanOrEqualTo(String value) {
            addCriterion("ERROR_CODE <=", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeLike(String value) {
            addCriterion("ERROR_CODE like", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeNotLike(String value) {
            addCriterion("ERROR_CODE not like", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeIn(List<String> values) {
            addCriterion("ERROR_CODE in", values, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeNotIn(List<String> values) {
            addCriterion("ERROR_CODE not in", values, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeBetween(String value1, String value2) {
            addCriterion("ERROR_CODE between", value1, value2, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeNotBetween(String value1, String value2) {
            addCriterion("ERROR_CODE not between", value1, value2, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorMsgIsNull() {
            addCriterion("ERROR_MSG is null");
            return (Criteria) this;
        }

        public Criteria andErrorMsgIsNotNull() {
            addCriterion("ERROR_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andErrorMsgEqualTo(String value) {
            addCriterion("ERROR_MSG =", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgNotEqualTo(String value) {
            addCriterion("ERROR_MSG <>", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgGreaterThan(String value) {
            addCriterion("ERROR_MSG >", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgGreaterThanOrEqualTo(String value) {
            addCriterion("ERROR_MSG >=", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgLessThan(String value) {
            addCriterion("ERROR_MSG <", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgLessThanOrEqualTo(String value) {
            addCriterion("ERROR_MSG <=", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgLike(String value) {
            addCriterion("ERROR_MSG like", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgNotLike(String value) {
            addCriterion("ERROR_MSG not like", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgIn(List<String> values) {
            addCriterion("ERROR_MSG in", values, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgNotIn(List<String> values) {
            addCriterion("ERROR_MSG not in", values, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgBetween(String value1, String value2) {
            addCriterion("ERROR_MSG between", value1, value2, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgNotBetween(String value1, String value2) {
            addCriterion("ERROR_MSG not between", value1, value2, "errorMsg");
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