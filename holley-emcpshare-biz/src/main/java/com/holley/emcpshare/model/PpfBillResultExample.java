package com.holley.emcpshare.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PpfBillResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PpfBillResultExample() {
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

        public Criteria andEnergyTypeIsNull() {
            addCriterion("ENERGY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeIsNotNull() {
            addCriterion("ENERGY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeEqualTo(Short value) {
            addCriterion("ENERGY_TYPE =", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeNotEqualTo(Short value) {
            addCriterion("ENERGY_TYPE <>", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeGreaterThan(Short value) {
            addCriterion("ENERGY_TYPE >", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("ENERGY_TYPE >=", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeLessThan(Short value) {
            addCriterion("ENERGY_TYPE <", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeLessThanOrEqualTo(Short value) {
            addCriterion("ENERGY_TYPE <=", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeIn(List<Short> values) {
            addCriterion("ENERGY_TYPE in", values, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeNotIn(List<Short> values) {
            addCriterion("ENERGY_TYPE not in", values, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeBetween(Short value1, Short value2) {
            addCriterion("ENERGY_TYPE between", value1, value2, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeNotBetween(Short value1, Short value2) {
            addCriterion("ENERGY_TYPE not between", value1, value2, "energyType");
            return (Criteria) this;
        }

        public Criteria andCutCountIsNull() {
            addCriterion("CUT_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andCutCountIsNotNull() {
            addCriterion("CUT_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCutCountEqualTo(Short value) {
            addCriterion("CUT_COUNT =", value, "cutCount");
            return (Criteria) this;
        }

        public Criteria andCutCountNotEqualTo(Short value) {
            addCriterion("CUT_COUNT <>", value, "cutCount");
            return (Criteria) this;
        }

        public Criteria andCutCountGreaterThan(Short value) {
            addCriterion("CUT_COUNT >", value, "cutCount");
            return (Criteria) this;
        }

        public Criteria andCutCountGreaterThanOrEqualTo(Short value) {
            addCriterion("CUT_COUNT >=", value, "cutCount");
            return (Criteria) this;
        }

        public Criteria andCutCountLessThan(Short value) {
            addCriterion("CUT_COUNT <", value, "cutCount");
            return (Criteria) this;
        }

        public Criteria andCutCountLessThanOrEqualTo(Short value) {
            addCriterion("CUT_COUNT <=", value, "cutCount");
            return (Criteria) this;
        }

        public Criteria andCutCountIn(List<Short> values) {
            addCriterion("CUT_COUNT in", values, "cutCount");
            return (Criteria) this;
        }

        public Criteria andCutCountNotIn(List<Short> values) {
            addCriterion("CUT_COUNT not in", values, "cutCount");
            return (Criteria) this;
        }

        public Criteria andCutCountBetween(Short value1, Short value2) {
            addCriterion("CUT_COUNT between", value1, value2, "cutCount");
            return (Criteria) this;
        }

        public Criteria andCutCountNotBetween(Short value1, Short value2) {
            addCriterion("CUT_COUNT not between", value1, value2, "cutCount");
            return (Criteria) this;
        }

        public Criteria andReturnInfoIsNull() {
            addCriterion("RETURN_INFO is null");
            return (Criteria) this;
        }

        public Criteria andReturnInfoIsNotNull() {
            addCriterion("RETURN_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andReturnInfoEqualTo(String value) {
            addCriterion("RETURN_INFO =", value, "returnInfo");
            return (Criteria) this;
        }

        public Criteria andReturnInfoNotEqualTo(String value) {
            addCriterion("RETURN_INFO <>", value, "returnInfo");
            return (Criteria) this;
        }

        public Criteria andReturnInfoGreaterThan(String value) {
            addCriterion("RETURN_INFO >", value, "returnInfo");
            return (Criteria) this;
        }

        public Criteria andReturnInfoGreaterThanOrEqualTo(String value) {
            addCriterion("RETURN_INFO >=", value, "returnInfo");
            return (Criteria) this;
        }

        public Criteria andReturnInfoLessThan(String value) {
            addCriterion("RETURN_INFO <", value, "returnInfo");
            return (Criteria) this;
        }

        public Criteria andReturnInfoLessThanOrEqualTo(String value) {
            addCriterion("RETURN_INFO <=", value, "returnInfo");
            return (Criteria) this;
        }

        public Criteria andReturnInfoLike(String value) {
            addCriterion("RETURN_INFO like", value, "returnInfo");
            return (Criteria) this;
        }

        public Criteria andReturnInfoNotLike(String value) {
            addCriterion("RETURN_INFO not like", value, "returnInfo");
            return (Criteria) this;
        }

        public Criteria andReturnInfoIn(List<String> values) {
            addCriterion("RETURN_INFO in", values, "returnInfo");
            return (Criteria) this;
        }

        public Criteria andReturnInfoNotIn(List<String> values) {
            addCriterion("RETURN_INFO not in", values, "returnInfo");
            return (Criteria) this;
        }

        public Criteria andReturnInfoBetween(String value1, String value2) {
            addCriterion("RETURN_INFO between", value1, value2, "returnInfo");
            return (Criteria) this;
        }

        public Criteria andReturnInfoNotBetween(String value1, String value2) {
            addCriterion("RETURN_INFO not between", value1, value2, "returnInfo");
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