package com.holley.emcpshare.model;

import java.util.ArrayList;
import java.util.List;

public class ObjPointCommparamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ObjPointCommparamExample() {
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

        public Criteria andRtuidIsNull() {
            addCriterion("RTUID is null");
            return (Criteria) this;
        }

        public Criteria andRtuidIsNotNull() {
            addCriterion("RTUID is not null");
            return (Criteria) this;
        }

        public Criteria andRtuidEqualTo(Integer value) {
            addCriterion("RTUID =", value, "rtuid");
            return (Criteria) this;
        }

        public Criteria andRtuidNotEqualTo(Integer value) {
            addCriterion("RTUID <>", value, "rtuid");
            return (Criteria) this;
        }

        public Criteria andRtuidGreaterThan(Integer value) {
            addCriterion("RTUID >", value, "rtuid");
            return (Criteria) this;
        }

        public Criteria andRtuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("RTUID >=", value, "rtuid");
            return (Criteria) this;
        }

        public Criteria andRtuidLessThan(Integer value) {
            addCriterion("RTUID <", value, "rtuid");
            return (Criteria) this;
        }

        public Criteria andRtuidLessThanOrEqualTo(Integer value) {
            addCriterion("RTUID <=", value, "rtuid");
            return (Criteria) this;
        }

        public Criteria andRtuidIn(List<Integer> values) {
            addCriterion("RTUID in", values, "rtuid");
            return (Criteria) this;
        }

        public Criteria andRtuidNotIn(List<Integer> values) {
            addCriterion("RTUID not in", values, "rtuid");
            return (Criteria) this;
        }

        public Criteria andRtuidBetween(Integer value1, Integer value2) {
            addCriterion("RTUID between", value1, value2, "rtuid");
            return (Criteria) this;
        }

        public Criteria andRtuidNotBetween(Integer value1, Integer value2) {
            addCriterion("RTUID not between", value1, value2, "rtuid");
            return (Criteria) this;
        }

        public Criteria andCommaddrIsNull() {
            addCriterion("COMMADDR is null");
            return (Criteria) this;
        }

        public Criteria andCommaddrIsNotNull() {
            addCriterion("COMMADDR is not null");
            return (Criteria) this;
        }

        public Criteria andCommaddrEqualTo(String value) {
            addCriterion("COMMADDR =", value, "commaddr");
            return (Criteria) this;
        }

        public Criteria andCommaddrNotEqualTo(String value) {
            addCriterion("COMMADDR <>", value, "commaddr");
            return (Criteria) this;
        }

        public Criteria andCommaddrGreaterThan(String value) {
            addCriterion("COMMADDR >", value, "commaddr");
            return (Criteria) this;
        }

        public Criteria andCommaddrGreaterThanOrEqualTo(String value) {
            addCriterion("COMMADDR >=", value, "commaddr");
            return (Criteria) this;
        }

        public Criteria andCommaddrLessThan(String value) {
            addCriterion("COMMADDR <", value, "commaddr");
            return (Criteria) this;
        }

        public Criteria andCommaddrLessThanOrEqualTo(String value) {
            addCriterion("COMMADDR <=", value, "commaddr");
            return (Criteria) this;
        }

        public Criteria andCommaddrLike(String value) {
            addCriterion("COMMADDR like", value, "commaddr");
            return (Criteria) this;
        }

        public Criteria andCommaddrNotLike(String value) {
            addCriterion("COMMADDR not like", value, "commaddr");
            return (Criteria) this;
        }

        public Criteria andCommaddrIn(List<String> values) {
            addCriterion("COMMADDR in", values, "commaddr");
            return (Criteria) this;
        }

        public Criteria andCommaddrNotIn(List<String> values) {
            addCriterion("COMMADDR not in", values, "commaddr");
            return (Criteria) this;
        }

        public Criteria andCommaddrBetween(String value1, String value2) {
            addCriterion("COMMADDR between", value1, value2, "commaddr");
            return (Criteria) this;
        }

        public Criteria andCommaddrNotBetween(String value1, String value2) {
            addCriterion("COMMADDR not between", value1, value2, "commaddr");
            return (Criteria) this;
        }

        public Criteria andProtocolidIsNull() {
            addCriterion("PROTOCOLID is null");
            return (Criteria) this;
        }

        public Criteria andProtocolidIsNotNull() {
            addCriterion("PROTOCOLID is not null");
            return (Criteria) this;
        }

        public Criteria andProtocolidEqualTo(Short value) {
            addCriterion("PROTOCOLID =", value, "protocolid");
            return (Criteria) this;
        }

        public Criteria andProtocolidNotEqualTo(Short value) {
            addCriterion("PROTOCOLID <>", value, "protocolid");
            return (Criteria) this;
        }

        public Criteria andProtocolidGreaterThan(Short value) {
            addCriterion("PROTOCOLID >", value, "protocolid");
            return (Criteria) this;
        }

        public Criteria andProtocolidGreaterThanOrEqualTo(Short value) {
            addCriterion("PROTOCOLID >=", value, "protocolid");
            return (Criteria) this;
        }

        public Criteria andProtocolidLessThan(Short value) {
            addCriterion("PROTOCOLID <", value, "protocolid");
            return (Criteria) this;
        }

        public Criteria andProtocolidLessThanOrEqualTo(Short value) {
            addCriterion("PROTOCOLID <=", value, "protocolid");
            return (Criteria) this;
        }

        public Criteria andProtocolidIn(List<Short> values) {
            addCriterion("PROTOCOLID in", values, "protocolid");
            return (Criteria) this;
        }

        public Criteria andProtocolidNotIn(List<Short> values) {
            addCriterion("PROTOCOLID not in", values, "protocolid");
            return (Criteria) this;
        }

        public Criteria andProtocolidBetween(Short value1, Short value2) {
            addCriterion("PROTOCOLID between", value1, value2, "protocolid");
            return (Criteria) this;
        }

        public Criteria andProtocolidNotBetween(Short value1, Short value2) {
            addCriterion("PROTOCOLID not between", value1, value2, "protocolid");
            return (Criteria) this;
        }

        public Criteria andPwdIsNull() {
            addCriterion("PWD is null");
            return (Criteria) this;
        }

        public Criteria andPwdIsNotNull() {
            addCriterion("PWD is not null");
            return (Criteria) this;
        }

        public Criteria andPwdEqualTo(String value) {
            addCriterion("PWD =", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotEqualTo(String value) {
            addCriterion("PWD <>", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThan(String value) {
            addCriterion("PWD >", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThanOrEqualTo(String value) {
            addCriterion("PWD >=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThan(String value) {
            addCriterion("PWD <", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThanOrEqualTo(String value) {
            addCriterion("PWD <=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLike(String value) {
            addCriterion("PWD like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotLike(String value) {
            addCriterion("PWD not like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdIn(List<String> values) {
            addCriterion("PWD in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotIn(List<String> values) {
            addCriterion("PWD not in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdBetween(String value1, String value2) {
            addCriterion("PWD between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotBetween(String value1, String value2) {
            addCriterion("PWD not between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andCommtypeidIsNull() {
            addCriterion("COMMTYPEID is null");
            return (Criteria) this;
        }

        public Criteria andCommtypeidIsNotNull() {
            addCriterion("COMMTYPEID is not null");
            return (Criteria) this;
        }

        public Criteria andCommtypeidEqualTo(Short value) {
            addCriterion("COMMTYPEID =", value, "commtypeid");
            return (Criteria) this;
        }

        public Criteria andCommtypeidNotEqualTo(Short value) {
            addCriterion("COMMTYPEID <>", value, "commtypeid");
            return (Criteria) this;
        }

        public Criteria andCommtypeidGreaterThan(Short value) {
            addCriterion("COMMTYPEID >", value, "commtypeid");
            return (Criteria) this;
        }

        public Criteria andCommtypeidGreaterThanOrEqualTo(Short value) {
            addCriterion("COMMTYPEID >=", value, "commtypeid");
            return (Criteria) this;
        }

        public Criteria andCommtypeidLessThan(Short value) {
            addCriterion("COMMTYPEID <", value, "commtypeid");
            return (Criteria) this;
        }

        public Criteria andCommtypeidLessThanOrEqualTo(Short value) {
            addCriterion("COMMTYPEID <=", value, "commtypeid");
            return (Criteria) this;
        }

        public Criteria andCommtypeidIn(List<Short> values) {
            addCriterion("COMMTYPEID in", values, "commtypeid");
            return (Criteria) this;
        }

        public Criteria andCommtypeidNotIn(List<Short> values) {
            addCriterion("COMMTYPEID not in", values, "commtypeid");
            return (Criteria) this;
        }

        public Criteria andCommtypeidBetween(Short value1, Short value2) {
            addCriterion("COMMTYPEID between", value1, value2, "commtypeid");
            return (Criteria) this;
        }

        public Criteria andCommtypeidNotBetween(Short value1, Short value2) {
            addCriterion("COMMTYPEID not between", value1, value2, "commtypeid");
            return (Criteria) this;
        }

        public Criteria andNumberidIsNull() {
            addCriterion("NUMBERID is null");
            return (Criteria) this;
        }

        public Criteria andNumberidIsNotNull() {
            addCriterion("NUMBERID is not null");
            return (Criteria) this;
        }

        public Criteria andNumberidEqualTo(Short value) {
            addCriterion("NUMBERID =", value, "numberid");
            return (Criteria) this;
        }

        public Criteria andNumberidNotEqualTo(Short value) {
            addCriterion("NUMBERID <>", value, "numberid");
            return (Criteria) this;
        }

        public Criteria andNumberidGreaterThan(Short value) {
            addCriterion("NUMBERID >", value, "numberid");
            return (Criteria) this;
        }

        public Criteria andNumberidGreaterThanOrEqualTo(Short value) {
            addCriterion("NUMBERID >=", value, "numberid");
            return (Criteria) this;
        }

        public Criteria andNumberidLessThan(Short value) {
            addCriterion("NUMBERID <", value, "numberid");
            return (Criteria) this;
        }

        public Criteria andNumberidLessThanOrEqualTo(Short value) {
            addCriterion("NUMBERID <=", value, "numberid");
            return (Criteria) this;
        }

        public Criteria andNumberidIn(List<Short> values) {
            addCriterion("NUMBERID in", values, "numberid");
            return (Criteria) this;
        }

        public Criteria andNumberidNotIn(List<Short> values) {
            addCriterion("NUMBERID not in", values, "numberid");
            return (Criteria) this;
        }

        public Criteria andNumberidBetween(Short value1, Short value2) {
            addCriterion("NUMBERID between", value1, value2, "numberid");
            return (Criteria) this;
        }

        public Criteria andNumberidNotBetween(Short value1, Short value2) {
            addCriterion("NUMBERID not between", value1, value2, "numberid");
            return (Criteria) this;
        }

        public Criteria andSampleintervalIsNull() {
            addCriterion("SAMPLEINTERVAL is null");
            return (Criteria) this;
        }

        public Criteria andSampleintervalIsNotNull() {
            addCriterion("SAMPLEINTERVAL is not null");
            return (Criteria) this;
        }

        public Criteria andSampleintervalEqualTo(String value) {
            addCriterion("SAMPLEINTERVAL =", value, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andSampleintervalNotEqualTo(String value) {
            addCriterion("SAMPLEINTERVAL <>", value, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andSampleintervalGreaterThan(String value) {
            addCriterion("SAMPLEINTERVAL >", value, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andSampleintervalGreaterThanOrEqualTo(String value) {
            addCriterion("SAMPLEINTERVAL >=", value, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andSampleintervalLessThan(String value) {
            addCriterion("SAMPLEINTERVAL <", value, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andSampleintervalLessThanOrEqualTo(String value) {
            addCriterion("SAMPLEINTERVAL <=", value, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andSampleintervalLike(String value) {
            addCriterion("SAMPLEINTERVAL like", value, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andSampleintervalNotLike(String value) {
            addCriterion("SAMPLEINTERVAL not like", value, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andSampleintervalIn(List<String> values) {
            addCriterion("SAMPLEINTERVAL in", values, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andSampleintervalNotIn(List<String> values) {
            addCriterion("SAMPLEINTERVAL not in", values, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andSampleintervalBetween(String value1, String value2) {
            addCriterion("SAMPLEINTERVAL between", value1, value2, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andSampleintervalNotBetween(String value1, String value2) {
            addCriterion("SAMPLEINTERVAL not between", value1, value2, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andDisconnectmodeIsNull() {
            addCriterion("DISCONNECTMODE is null");
            return (Criteria) this;
        }

        public Criteria andDisconnectmodeIsNotNull() {
            addCriterion("DISCONNECTMODE is not null");
            return (Criteria) this;
        }

        public Criteria andDisconnectmodeEqualTo(Short value) {
            addCriterion("DISCONNECTMODE =", value, "disconnectmode");
            return (Criteria) this;
        }

        public Criteria andDisconnectmodeNotEqualTo(Short value) {
            addCriterion("DISCONNECTMODE <>", value, "disconnectmode");
            return (Criteria) this;
        }

        public Criteria andDisconnectmodeGreaterThan(Short value) {
            addCriterion("DISCONNECTMODE >", value, "disconnectmode");
            return (Criteria) this;
        }

        public Criteria andDisconnectmodeGreaterThanOrEqualTo(Short value) {
            addCriterion("DISCONNECTMODE >=", value, "disconnectmode");
            return (Criteria) this;
        }

        public Criteria andDisconnectmodeLessThan(Short value) {
            addCriterion("DISCONNECTMODE <", value, "disconnectmode");
            return (Criteria) this;
        }

        public Criteria andDisconnectmodeLessThanOrEqualTo(Short value) {
            addCriterion("DISCONNECTMODE <=", value, "disconnectmode");
            return (Criteria) this;
        }

        public Criteria andDisconnectmodeIn(List<Short> values) {
            addCriterion("DISCONNECTMODE in", values, "disconnectmode");
            return (Criteria) this;
        }

        public Criteria andDisconnectmodeNotIn(List<Short> values) {
            addCriterion("DISCONNECTMODE not in", values, "disconnectmode");
            return (Criteria) this;
        }

        public Criteria andDisconnectmodeBetween(Short value1, Short value2) {
            addCriterion("DISCONNECTMODE between", value1, value2, "disconnectmode");
            return (Criteria) this;
        }

        public Criteria andDisconnectmodeNotBetween(Short value1, Short value2) {
            addCriterion("DISCONNECTMODE not between", value1, value2, "disconnectmode");
            return (Criteria) this;
        }

        public Criteria andSafetylevelIsNull() {
            addCriterion("SAFETYLEVEL is null");
            return (Criteria) this;
        }

        public Criteria andSafetylevelIsNotNull() {
            addCriterion("SAFETYLEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andSafetylevelEqualTo(String value) {
            addCriterion("SAFETYLEVEL =", value, "safetylevel");
            return (Criteria) this;
        }

        public Criteria andSafetylevelNotEqualTo(String value) {
            addCriterion("SAFETYLEVEL <>", value, "safetylevel");
            return (Criteria) this;
        }

        public Criteria andSafetylevelGreaterThan(String value) {
            addCriterion("SAFETYLEVEL >", value, "safetylevel");
            return (Criteria) this;
        }

        public Criteria andSafetylevelGreaterThanOrEqualTo(String value) {
            addCriterion("SAFETYLEVEL >=", value, "safetylevel");
            return (Criteria) this;
        }

        public Criteria andSafetylevelLessThan(String value) {
            addCriterion("SAFETYLEVEL <", value, "safetylevel");
            return (Criteria) this;
        }

        public Criteria andSafetylevelLessThanOrEqualTo(String value) {
            addCriterion("SAFETYLEVEL <=", value, "safetylevel");
            return (Criteria) this;
        }

        public Criteria andSafetylevelLike(String value) {
            addCriterion("SAFETYLEVEL like", value, "safetylevel");
            return (Criteria) this;
        }

        public Criteria andSafetylevelNotLike(String value) {
            addCriterion("SAFETYLEVEL not like", value, "safetylevel");
            return (Criteria) this;
        }

        public Criteria andSafetylevelIn(List<String> values) {
            addCriterion("SAFETYLEVEL in", values, "safetylevel");
            return (Criteria) this;
        }

        public Criteria andSafetylevelNotIn(List<String> values) {
            addCriterion("SAFETYLEVEL not in", values, "safetylevel");
            return (Criteria) this;
        }

        public Criteria andSafetylevelBetween(String value1, String value2) {
            addCriterion("SAFETYLEVEL between", value1, value2, "safetylevel");
            return (Criteria) this;
        }

        public Criteria andSafetylevelNotBetween(String value1, String value2) {
            addCriterion("SAFETYLEVEL not between", value1, value2, "safetylevel");
            return (Criteria) this;
        }

        public Criteria andSafetypwdIsNull() {
            addCriterion("SAFETYPWD is null");
            return (Criteria) this;
        }

        public Criteria andSafetypwdIsNotNull() {
            addCriterion("SAFETYPWD is not null");
            return (Criteria) this;
        }

        public Criteria andSafetypwdEqualTo(String value) {
            addCriterion("SAFETYPWD =", value, "safetypwd");
            return (Criteria) this;
        }

        public Criteria andSafetypwdNotEqualTo(String value) {
            addCriterion("SAFETYPWD <>", value, "safetypwd");
            return (Criteria) this;
        }

        public Criteria andSafetypwdGreaterThan(String value) {
            addCriterion("SAFETYPWD >", value, "safetypwd");
            return (Criteria) this;
        }

        public Criteria andSafetypwdGreaterThanOrEqualTo(String value) {
            addCriterion("SAFETYPWD >=", value, "safetypwd");
            return (Criteria) this;
        }

        public Criteria andSafetypwdLessThan(String value) {
            addCriterion("SAFETYPWD <", value, "safetypwd");
            return (Criteria) this;
        }

        public Criteria andSafetypwdLessThanOrEqualTo(String value) {
            addCriterion("SAFETYPWD <=", value, "safetypwd");
            return (Criteria) this;
        }

        public Criteria andSafetypwdLike(String value) {
            addCriterion("SAFETYPWD like", value, "safetypwd");
            return (Criteria) this;
        }

        public Criteria andSafetypwdNotLike(String value) {
            addCriterion("SAFETYPWD not like", value, "safetypwd");
            return (Criteria) this;
        }

        public Criteria andSafetypwdIn(List<String> values) {
            addCriterion("SAFETYPWD in", values, "safetypwd");
            return (Criteria) this;
        }

        public Criteria andSafetypwdNotIn(List<String> values) {
            addCriterion("SAFETYPWD not in", values, "safetypwd");
            return (Criteria) this;
        }

        public Criteria andSafetypwdBetween(String value1, String value2) {
            addCriterion("SAFETYPWD between", value1, value2, "safetypwd");
            return (Criteria) this;
        }

        public Criteria andSafetypwdNotBetween(String value1, String value2) {
            addCriterion("SAFETYPWD not between", value1, value2, "safetypwd");
            return (Criteria) this;
        }

        public Criteria andPowerstatusIsNull() {
            addCriterion("POWERSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andPowerstatusIsNotNull() {
            addCriterion("POWERSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPowerstatusEqualTo(Short value) {
            addCriterion("POWERSTATUS =", value, "powerstatus");
            return (Criteria) this;
        }

        public Criteria andPowerstatusNotEqualTo(Short value) {
            addCriterion("POWERSTATUS <>", value, "powerstatus");
            return (Criteria) this;
        }

        public Criteria andPowerstatusGreaterThan(Short value) {
            addCriterion("POWERSTATUS >", value, "powerstatus");
            return (Criteria) this;
        }

        public Criteria andPowerstatusGreaterThanOrEqualTo(Short value) {
            addCriterion("POWERSTATUS >=", value, "powerstatus");
            return (Criteria) this;
        }

        public Criteria andPowerstatusLessThan(Short value) {
            addCriterion("POWERSTATUS <", value, "powerstatus");
            return (Criteria) this;
        }

        public Criteria andPowerstatusLessThanOrEqualTo(Short value) {
            addCriterion("POWERSTATUS <=", value, "powerstatus");
            return (Criteria) this;
        }

        public Criteria andPowerstatusIn(List<Short> values) {
            addCriterion("POWERSTATUS in", values, "powerstatus");
            return (Criteria) this;
        }

        public Criteria andPowerstatusNotIn(List<Short> values) {
            addCriterion("POWERSTATUS not in", values, "powerstatus");
            return (Criteria) this;
        }

        public Criteria andPowerstatusBetween(Short value1, Short value2) {
            addCriterion("POWERSTATUS between", value1, value2, "powerstatus");
            return (Criteria) this;
        }

        public Criteria andPowerstatusNotBetween(Short value1, Short value2) {
            addCriterion("POWERSTATUS not between", value1, value2, "powerstatus");
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