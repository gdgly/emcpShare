package com.holley.emcpshare.model;

import java.util.ArrayList;
import java.util.List;

public class ViewPointExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ViewPointExample() {
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

        public Criteria andObjidIsNull() {
            addCriterion("objid is null");
            return (Criteria) this;
        }

        public Criteria andObjidIsNotNull() {
            addCriterion("objid is not null");
            return (Criteria) this;
        }

        public Criteria andObjidEqualTo(Integer value) {
            addCriterion("objid =", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidNotEqualTo(Integer value) {
            addCriterion("objid <>", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidGreaterThan(Integer value) {
            addCriterion("objid >", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidGreaterThanOrEqualTo(Integer value) {
            addCriterion("objid >=", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidLessThan(Integer value) {
            addCriterion("objid <", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidLessThanOrEqualTo(Integer value) {
            addCriterion("objid <=", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidIn(List<Integer> values) {
            addCriterion("objid in", values, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidNotIn(List<Integer> values) {
            addCriterion("objid not in", values, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidBetween(Integer value1, Integer value2) {
            addCriterion("objid between", value1, value2, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidNotBetween(Integer value1, Integer value2) {
            addCriterion("objid not between", value1, value2, "objid");
            return (Criteria) this;
        }

        public Criteria andObjtypeIsNull() {
            addCriterion("objtype is null");
            return (Criteria) this;
        }

        public Criteria andObjtypeIsNotNull() {
            addCriterion("objtype is not null");
            return (Criteria) this;
        }

        public Criteria andObjtypeEqualTo(Short value) {
            addCriterion("objtype =", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeNotEqualTo(Short value) {
            addCriterion("objtype <>", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeGreaterThan(Short value) {
            addCriterion("objtype >", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeGreaterThanOrEqualTo(Short value) {
            addCriterion("objtype >=", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeLessThan(Short value) {
            addCriterion("objtype <", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeLessThanOrEqualTo(Short value) {
            addCriterion("objtype <=", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeIn(List<Short> values) {
            addCriterion("objtype in", values, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeNotIn(List<Short> values) {
            addCriterion("objtype not in", values, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeBetween(Short value1, Short value2) {
            addCriterion("objtype between", value1, value2, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeNotBetween(Short value1, Short value2) {
            addCriterion("objtype not between", value1, value2, "objtype");
            return (Criteria) this;
        }

        public Criteria andPointidIsNull() {
            addCriterion("pointid is null");
            return (Criteria) this;
        }

        public Criteria andPointidIsNotNull() {
            addCriterion("pointid is not null");
            return (Criteria) this;
        }

        public Criteria andPointidEqualTo(Integer value) {
            addCriterion("pointid =", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidNotEqualTo(Integer value) {
            addCriterion("pointid <>", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidGreaterThan(Integer value) {
            addCriterion("pointid >", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pointid >=", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidLessThan(Integer value) {
            addCriterion("pointid <", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidLessThanOrEqualTo(Integer value) {
            addCriterion("pointid <=", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidIn(List<Integer> values) {
            addCriterion("pointid in", values, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidNotIn(List<Integer> values) {
            addCriterion("pointid not in", values, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidBetween(Integer value1, Integer value2) {
            addCriterion("pointid between", value1, value2, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidNotBetween(Integer value1, Integer value2) {
            addCriterion("pointid not between", value1, value2, "pointid");
            return (Criteria) this;
        }

        public Criteria andObjnameIsNull() {
            addCriterion("objname is null");
            return (Criteria) this;
        }

        public Criteria andObjnameIsNotNull() {
            addCriterion("objname is not null");
            return (Criteria) this;
        }

        public Criteria andObjnameEqualTo(String value) {
            addCriterion("objname =", value, "objname");
            return (Criteria) this;
        }

        public Criteria andObjnameNotEqualTo(String value) {
            addCriterion("objname <>", value, "objname");
            return (Criteria) this;
        }

        public Criteria andObjnameGreaterThan(String value) {
            addCriterion("objname >", value, "objname");
            return (Criteria) this;
        }

        public Criteria andObjnameGreaterThanOrEqualTo(String value) {
            addCriterion("objname >=", value, "objname");
            return (Criteria) this;
        }

        public Criteria andObjnameLessThan(String value) {
            addCriterion("objname <", value, "objname");
            return (Criteria) this;
        }

        public Criteria andObjnameLessThanOrEqualTo(String value) {
            addCriterion("objname <=", value, "objname");
            return (Criteria) this;
        }

        public Criteria andObjnameLike(String value) {
            addCriterion("objname like", value, "objname");
            return (Criteria) this;
        }

        public Criteria andObjnameNotLike(String value) {
            addCriterion("objname not like", value, "objname");
            return (Criteria) this;
        }

        public Criteria andObjnameIn(List<String> values) {
            addCriterion("objname in", values, "objname");
            return (Criteria) this;
        }

        public Criteria andObjnameNotIn(List<String> values) {
            addCriterion("objname not in", values, "objname");
            return (Criteria) this;
        }

        public Criteria andObjnameBetween(String value1, String value2) {
            addCriterion("objname between", value1, value2, "objname");
            return (Criteria) this;
        }

        public Criteria andObjnameNotBetween(String value1, String value2) {
            addCriterion("objname not between", value1, value2, "objname");
            return (Criteria) this;
        }

        public Criteria andOwnernameIsNull() {
            addCriterion("ownername is null");
            return (Criteria) this;
        }

        public Criteria andOwnernameIsNotNull() {
            addCriterion("ownername is not null");
            return (Criteria) this;
        }

        public Criteria andOwnernameEqualTo(String value) {
            addCriterion("ownername =", value, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnernameNotEqualTo(String value) {
            addCriterion("ownername <>", value, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnernameGreaterThan(String value) {
            addCriterion("ownername >", value, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnernameGreaterThanOrEqualTo(String value) {
            addCriterion("ownername >=", value, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnernameLessThan(String value) {
            addCriterion("ownername <", value, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnernameLessThanOrEqualTo(String value) {
            addCriterion("ownername <=", value, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnernameLike(String value) {
            addCriterion("ownername like", value, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnernameNotLike(String value) {
            addCriterion("ownername not like", value, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnernameIn(List<String> values) {
            addCriterion("ownername in", values, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnernameNotIn(List<String> values) {
            addCriterion("ownername not in", values, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnernameBetween(String value1, String value2) {
            addCriterion("ownername between", value1, value2, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnernameNotBetween(String value1, String value2) {
            addCriterion("ownername not between", value1, value2, "ownername");
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