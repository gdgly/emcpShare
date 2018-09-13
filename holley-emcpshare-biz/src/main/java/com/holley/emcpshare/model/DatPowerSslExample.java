package com.holley.emcpshare.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatPowerSslExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DatPowerSslExample() {
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

        public Criteria andPIsNull() {
            addCriterion("P is null");
            return (Criteria) this;
        }

        public Criteria andPIsNotNull() {
            addCriterion("P is not null");
            return (Criteria) this;
        }

        public Criteria andPEqualTo(BigDecimal value) {
            addCriterion("P =", value, "p");
            return (Criteria) this;
        }

        public Criteria andPNotEqualTo(BigDecimal value) {
            addCriterion("P <>", value, "p");
            return (Criteria) this;
        }

        public Criteria andPGreaterThan(BigDecimal value) {
            addCriterion("P >", value, "p");
            return (Criteria) this;
        }

        public Criteria andPGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("P >=", value, "p");
            return (Criteria) this;
        }

        public Criteria andPLessThan(BigDecimal value) {
            addCriterion("P <", value, "p");
            return (Criteria) this;
        }

        public Criteria andPLessThanOrEqualTo(BigDecimal value) {
            addCriterion("P <=", value, "p");
            return (Criteria) this;
        }

        public Criteria andPIn(List<BigDecimal> values) {
            addCriterion("P in", values, "p");
            return (Criteria) this;
        }

        public Criteria andPNotIn(List<BigDecimal> values) {
            addCriterion("P not in", values, "p");
            return (Criteria) this;
        }

        public Criteria andPBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("P between", value1, value2, "p");
            return (Criteria) this;
        }

        public Criteria andPNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("P not between", value1, value2, "p");
            return (Criteria) this;
        }

        public Criteria andPaIsNull() {
            addCriterion("PA is null");
            return (Criteria) this;
        }

        public Criteria andPaIsNotNull() {
            addCriterion("PA is not null");
            return (Criteria) this;
        }

        public Criteria andPaEqualTo(BigDecimal value) {
            addCriterion("PA =", value, "pa");
            return (Criteria) this;
        }

        public Criteria andPaNotEqualTo(BigDecimal value) {
            addCriterion("PA <>", value, "pa");
            return (Criteria) this;
        }

        public Criteria andPaGreaterThan(BigDecimal value) {
            addCriterion("PA >", value, "pa");
            return (Criteria) this;
        }

        public Criteria andPaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PA >=", value, "pa");
            return (Criteria) this;
        }

        public Criteria andPaLessThan(BigDecimal value) {
            addCriterion("PA <", value, "pa");
            return (Criteria) this;
        }

        public Criteria andPaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PA <=", value, "pa");
            return (Criteria) this;
        }

        public Criteria andPaIn(List<BigDecimal> values) {
            addCriterion("PA in", values, "pa");
            return (Criteria) this;
        }

        public Criteria andPaNotIn(List<BigDecimal> values) {
            addCriterion("PA not in", values, "pa");
            return (Criteria) this;
        }

        public Criteria andPaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PA between", value1, value2, "pa");
            return (Criteria) this;
        }

        public Criteria andPaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PA not between", value1, value2, "pa");
            return (Criteria) this;
        }

        public Criteria andPbIsNull() {
            addCriterion("PB is null");
            return (Criteria) this;
        }

        public Criteria andPbIsNotNull() {
            addCriterion("PB is not null");
            return (Criteria) this;
        }

        public Criteria andPbEqualTo(BigDecimal value) {
            addCriterion("PB =", value, "pb");
            return (Criteria) this;
        }

        public Criteria andPbNotEqualTo(BigDecimal value) {
            addCriterion("PB <>", value, "pb");
            return (Criteria) this;
        }

        public Criteria andPbGreaterThan(BigDecimal value) {
            addCriterion("PB >", value, "pb");
            return (Criteria) this;
        }

        public Criteria andPbGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PB >=", value, "pb");
            return (Criteria) this;
        }

        public Criteria andPbLessThan(BigDecimal value) {
            addCriterion("PB <", value, "pb");
            return (Criteria) this;
        }

        public Criteria andPbLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PB <=", value, "pb");
            return (Criteria) this;
        }

        public Criteria andPbIn(List<BigDecimal> values) {
            addCriterion("PB in", values, "pb");
            return (Criteria) this;
        }

        public Criteria andPbNotIn(List<BigDecimal> values) {
            addCriterion("PB not in", values, "pb");
            return (Criteria) this;
        }

        public Criteria andPbBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PB between", value1, value2, "pb");
            return (Criteria) this;
        }

        public Criteria andPbNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PB not between", value1, value2, "pb");
            return (Criteria) this;
        }

        public Criteria andPcIsNull() {
            addCriterion("PC is null");
            return (Criteria) this;
        }

        public Criteria andPcIsNotNull() {
            addCriterion("PC is not null");
            return (Criteria) this;
        }

        public Criteria andPcEqualTo(BigDecimal value) {
            addCriterion("PC =", value, "pc");
            return (Criteria) this;
        }

        public Criteria andPcNotEqualTo(BigDecimal value) {
            addCriterion("PC <>", value, "pc");
            return (Criteria) this;
        }

        public Criteria andPcGreaterThan(BigDecimal value) {
            addCriterion("PC >", value, "pc");
            return (Criteria) this;
        }

        public Criteria andPcGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PC >=", value, "pc");
            return (Criteria) this;
        }

        public Criteria andPcLessThan(BigDecimal value) {
            addCriterion("PC <", value, "pc");
            return (Criteria) this;
        }

        public Criteria andPcLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PC <=", value, "pc");
            return (Criteria) this;
        }

        public Criteria andPcIn(List<BigDecimal> values) {
            addCriterion("PC in", values, "pc");
            return (Criteria) this;
        }

        public Criteria andPcNotIn(List<BigDecimal> values) {
            addCriterion("PC not in", values, "pc");
            return (Criteria) this;
        }

        public Criteria andPcBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PC between", value1, value2, "pc");
            return (Criteria) this;
        }

        public Criteria andPcNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PC not between", value1, value2, "pc");
            return (Criteria) this;
        }

        public Criteria andQIsNull() {
            addCriterion("Q is null");
            return (Criteria) this;
        }

        public Criteria andQIsNotNull() {
            addCriterion("Q is not null");
            return (Criteria) this;
        }

        public Criteria andQEqualTo(BigDecimal value) {
            addCriterion("Q =", value, "q");
            return (Criteria) this;
        }

        public Criteria andQNotEqualTo(BigDecimal value) {
            addCriterion("Q <>", value, "q");
            return (Criteria) this;
        }

        public Criteria andQGreaterThan(BigDecimal value) {
            addCriterion("Q >", value, "q");
            return (Criteria) this;
        }

        public Criteria andQGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Q >=", value, "q");
            return (Criteria) this;
        }

        public Criteria andQLessThan(BigDecimal value) {
            addCriterion("Q <", value, "q");
            return (Criteria) this;
        }

        public Criteria andQLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Q <=", value, "q");
            return (Criteria) this;
        }

        public Criteria andQIn(List<BigDecimal> values) {
            addCriterion("Q in", values, "q");
            return (Criteria) this;
        }

        public Criteria andQNotIn(List<BigDecimal> values) {
            addCriterion("Q not in", values, "q");
            return (Criteria) this;
        }

        public Criteria andQBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Q between", value1, value2, "q");
            return (Criteria) this;
        }

        public Criteria andQNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Q not between", value1, value2, "q");
            return (Criteria) this;
        }

        public Criteria andQaIsNull() {
            addCriterion("QA is null");
            return (Criteria) this;
        }

        public Criteria andQaIsNotNull() {
            addCriterion("QA is not null");
            return (Criteria) this;
        }

        public Criteria andQaEqualTo(BigDecimal value) {
            addCriterion("QA =", value, "qa");
            return (Criteria) this;
        }

        public Criteria andQaNotEqualTo(BigDecimal value) {
            addCriterion("QA <>", value, "qa");
            return (Criteria) this;
        }

        public Criteria andQaGreaterThan(BigDecimal value) {
            addCriterion("QA >", value, "qa");
            return (Criteria) this;
        }

        public Criteria andQaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QA >=", value, "qa");
            return (Criteria) this;
        }

        public Criteria andQaLessThan(BigDecimal value) {
            addCriterion("QA <", value, "qa");
            return (Criteria) this;
        }

        public Criteria andQaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QA <=", value, "qa");
            return (Criteria) this;
        }

        public Criteria andQaIn(List<BigDecimal> values) {
            addCriterion("QA in", values, "qa");
            return (Criteria) this;
        }

        public Criteria andQaNotIn(List<BigDecimal> values) {
            addCriterion("QA not in", values, "qa");
            return (Criteria) this;
        }

        public Criteria andQaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QA between", value1, value2, "qa");
            return (Criteria) this;
        }

        public Criteria andQaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QA not between", value1, value2, "qa");
            return (Criteria) this;
        }

        public Criteria andQbIsNull() {
            addCriterion("QB is null");
            return (Criteria) this;
        }

        public Criteria andQbIsNotNull() {
            addCriterion("QB is not null");
            return (Criteria) this;
        }

        public Criteria andQbEqualTo(BigDecimal value) {
            addCriterion("QB =", value, "qb");
            return (Criteria) this;
        }

        public Criteria andQbNotEqualTo(BigDecimal value) {
            addCriterion("QB <>", value, "qb");
            return (Criteria) this;
        }

        public Criteria andQbGreaterThan(BigDecimal value) {
            addCriterion("QB >", value, "qb");
            return (Criteria) this;
        }

        public Criteria andQbGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QB >=", value, "qb");
            return (Criteria) this;
        }

        public Criteria andQbLessThan(BigDecimal value) {
            addCriterion("QB <", value, "qb");
            return (Criteria) this;
        }

        public Criteria andQbLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QB <=", value, "qb");
            return (Criteria) this;
        }

        public Criteria andQbIn(List<BigDecimal> values) {
            addCriterion("QB in", values, "qb");
            return (Criteria) this;
        }

        public Criteria andQbNotIn(List<BigDecimal> values) {
            addCriterion("QB not in", values, "qb");
            return (Criteria) this;
        }

        public Criteria andQbBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QB between", value1, value2, "qb");
            return (Criteria) this;
        }

        public Criteria andQbNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QB not between", value1, value2, "qb");
            return (Criteria) this;
        }

        public Criteria andQcIsNull() {
            addCriterion("QC is null");
            return (Criteria) this;
        }

        public Criteria andQcIsNotNull() {
            addCriterion("QC is not null");
            return (Criteria) this;
        }

        public Criteria andQcEqualTo(BigDecimal value) {
            addCriterion("QC =", value, "qc");
            return (Criteria) this;
        }

        public Criteria andQcNotEqualTo(BigDecimal value) {
            addCriterion("QC <>", value, "qc");
            return (Criteria) this;
        }

        public Criteria andQcGreaterThan(BigDecimal value) {
            addCriterion("QC >", value, "qc");
            return (Criteria) this;
        }

        public Criteria andQcGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QC >=", value, "qc");
            return (Criteria) this;
        }

        public Criteria andQcLessThan(BigDecimal value) {
            addCriterion("QC <", value, "qc");
            return (Criteria) this;
        }

        public Criteria andQcLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QC <=", value, "qc");
            return (Criteria) this;
        }

        public Criteria andQcIn(List<BigDecimal> values) {
            addCriterion("QC in", values, "qc");
            return (Criteria) this;
        }

        public Criteria andQcNotIn(List<BigDecimal> values) {
            addCriterion("QC not in", values, "qc");
            return (Criteria) this;
        }

        public Criteria andQcBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QC between", value1, value2, "qc");
            return (Criteria) this;
        }

        public Criteria andQcNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QC not between", value1, value2, "qc");
            return (Criteria) this;
        }

        public Criteria andIaIsNull() {
            addCriterion("IA is null");
            return (Criteria) this;
        }

        public Criteria andIaIsNotNull() {
            addCriterion("IA is not null");
            return (Criteria) this;
        }

        public Criteria andIaEqualTo(BigDecimal value) {
            addCriterion("IA =", value, "ia");
            return (Criteria) this;
        }

        public Criteria andIaNotEqualTo(BigDecimal value) {
            addCriterion("IA <>", value, "ia");
            return (Criteria) this;
        }

        public Criteria andIaGreaterThan(BigDecimal value) {
            addCriterion("IA >", value, "ia");
            return (Criteria) this;
        }

        public Criteria andIaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("IA >=", value, "ia");
            return (Criteria) this;
        }

        public Criteria andIaLessThan(BigDecimal value) {
            addCriterion("IA <", value, "ia");
            return (Criteria) this;
        }

        public Criteria andIaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("IA <=", value, "ia");
            return (Criteria) this;
        }

        public Criteria andIaIn(List<BigDecimal> values) {
            addCriterion("IA in", values, "ia");
            return (Criteria) this;
        }

        public Criteria andIaNotIn(List<BigDecimal> values) {
            addCriterion("IA not in", values, "ia");
            return (Criteria) this;
        }

        public Criteria andIaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IA between", value1, value2, "ia");
            return (Criteria) this;
        }

        public Criteria andIaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IA not between", value1, value2, "ia");
            return (Criteria) this;
        }

        public Criteria andIbIsNull() {
            addCriterion("IB is null");
            return (Criteria) this;
        }

        public Criteria andIbIsNotNull() {
            addCriterion("IB is not null");
            return (Criteria) this;
        }

        public Criteria andIbEqualTo(BigDecimal value) {
            addCriterion("IB =", value, "ib");
            return (Criteria) this;
        }

        public Criteria andIbNotEqualTo(BigDecimal value) {
            addCriterion("IB <>", value, "ib");
            return (Criteria) this;
        }

        public Criteria andIbGreaterThan(BigDecimal value) {
            addCriterion("IB >", value, "ib");
            return (Criteria) this;
        }

        public Criteria andIbGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("IB >=", value, "ib");
            return (Criteria) this;
        }

        public Criteria andIbLessThan(BigDecimal value) {
            addCriterion("IB <", value, "ib");
            return (Criteria) this;
        }

        public Criteria andIbLessThanOrEqualTo(BigDecimal value) {
            addCriterion("IB <=", value, "ib");
            return (Criteria) this;
        }

        public Criteria andIbIn(List<BigDecimal> values) {
            addCriterion("IB in", values, "ib");
            return (Criteria) this;
        }

        public Criteria andIbNotIn(List<BigDecimal> values) {
            addCriterion("IB not in", values, "ib");
            return (Criteria) this;
        }

        public Criteria andIbBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IB between", value1, value2, "ib");
            return (Criteria) this;
        }

        public Criteria andIbNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IB not between", value1, value2, "ib");
            return (Criteria) this;
        }

        public Criteria andIcIsNull() {
            addCriterion("IC is null");
            return (Criteria) this;
        }

        public Criteria andIcIsNotNull() {
            addCriterion("IC is not null");
            return (Criteria) this;
        }

        public Criteria andIcEqualTo(BigDecimal value) {
            addCriterion("IC =", value, "ic");
            return (Criteria) this;
        }

        public Criteria andIcNotEqualTo(BigDecimal value) {
            addCriterion("IC <>", value, "ic");
            return (Criteria) this;
        }

        public Criteria andIcGreaterThan(BigDecimal value) {
            addCriterion("IC >", value, "ic");
            return (Criteria) this;
        }

        public Criteria andIcGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("IC >=", value, "ic");
            return (Criteria) this;
        }

        public Criteria andIcLessThan(BigDecimal value) {
            addCriterion("IC <", value, "ic");
            return (Criteria) this;
        }

        public Criteria andIcLessThanOrEqualTo(BigDecimal value) {
            addCriterion("IC <=", value, "ic");
            return (Criteria) this;
        }

        public Criteria andIcIn(List<BigDecimal> values) {
            addCriterion("IC in", values, "ic");
            return (Criteria) this;
        }

        public Criteria andIcNotIn(List<BigDecimal> values) {
            addCriterion("IC not in", values, "ic");
            return (Criteria) this;
        }

        public Criteria andIcBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IC between", value1, value2, "ic");
            return (Criteria) this;
        }

        public Criteria andIcNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IC not between", value1, value2, "ic");
            return (Criteria) this;
        }

        public Criteria andIzIsNull() {
            addCriterion("IZ is null");
            return (Criteria) this;
        }

        public Criteria andIzIsNotNull() {
            addCriterion("IZ is not null");
            return (Criteria) this;
        }

        public Criteria andIzEqualTo(BigDecimal value) {
            addCriterion("IZ =", value, "iz");
            return (Criteria) this;
        }

        public Criteria andIzNotEqualTo(BigDecimal value) {
            addCriterion("IZ <>", value, "iz");
            return (Criteria) this;
        }

        public Criteria andIzGreaterThan(BigDecimal value) {
            addCriterion("IZ >", value, "iz");
            return (Criteria) this;
        }

        public Criteria andIzGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("IZ >=", value, "iz");
            return (Criteria) this;
        }

        public Criteria andIzLessThan(BigDecimal value) {
            addCriterion("IZ <", value, "iz");
            return (Criteria) this;
        }

        public Criteria andIzLessThanOrEqualTo(BigDecimal value) {
            addCriterion("IZ <=", value, "iz");
            return (Criteria) this;
        }

        public Criteria andIzIn(List<BigDecimal> values) {
            addCriterion("IZ in", values, "iz");
            return (Criteria) this;
        }

        public Criteria andIzNotIn(List<BigDecimal> values) {
            addCriterion("IZ not in", values, "iz");
            return (Criteria) this;
        }

        public Criteria andIzBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IZ between", value1, value2, "iz");
            return (Criteria) this;
        }

        public Criteria andIzNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IZ not between", value1, value2, "iz");
            return (Criteria) this;
        }

        public Criteria andUaIsNull() {
            addCriterion("UA is null");
            return (Criteria) this;
        }

        public Criteria andUaIsNotNull() {
            addCriterion("UA is not null");
            return (Criteria) this;
        }

        public Criteria andUaEqualTo(BigDecimal value) {
            addCriterion("UA =", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaNotEqualTo(BigDecimal value) {
            addCriterion("UA <>", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaGreaterThan(BigDecimal value) {
            addCriterion("UA >", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("UA >=", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaLessThan(BigDecimal value) {
            addCriterion("UA <", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("UA <=", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaIn(List<BigDecimal> values) {
            addCriterion("UA in", values, "ua");
            return (Criteria) this;
        }

        public Criteria andUaNotIn(List<BigDecimal> values) {
            addCriterion("UA not in", values, "ua");
            return (Criteria) this;
        }

        public Criteria andUaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UA between", value1, value2, "ua");
            return (Criteria) this;
        }

        public Criteria andUaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UA not between", value1, value2, "ua");
            return (Criteria) this;
        }

        public Criteria andUbIsNull() {
            addCriterion("UB is null");
            return (Criteria) this;
        }

        public Criteria andUbIsNotNull() {
            addCriterion("UB is not null");
            return (Criteria) this;
        }

        public Criteria andUbEqualTo(BigDecimal value) {
            addCriterion("UB =", value, "ub");
            return (Criteria) this;
        }

        public Criteria andUbNotEqualTo(BigDecimal value) {
            addCriterion("UB <>", value, "ub");
            return (Criteria) this;
        }

        public Criteria andUbGreaterThan(BigDecimal value) {
            addCriterion("UB >", value, "ub");
            return (Criteria) this;
        }

        public Criteria andUbGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("UB >=", value, "ub");
            return (Criteria) this;
        }

        public Criteria andUbLessThan(BigDecimal value) {
            addCriterion("UB <", value, "ub");
            return (Criteria) this;
        }

        public Criteria andUbLessThanOrEqualTo(BigDecimal value) {
            addCriterion("UB <=", value, "ub");
            return (Criteria) this;
        }

        public Criteria andUbIn(List<BigDecimal> values) {
            addCriterion("UB in", values, "ub");
            return (Criteria) this;
        }

        public Criteria andUbNotIn(List<BigDecimal> values) {
            addCriterion("UB not in", values, "ub");
            return (Criteria) this;
        }

        public Criteria andUbBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UB between", value1, value2, "ub");
            return (Criteria) this;
        }

        public Criteria andUbNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UB not between", value1, value2, "ub");
            return (Criteria) this;
        }

        public Criteria andUcIsNull() {
            addCriterion("UC is null");
            return (Criteria) this;
        }

        public Criteria andUcIsNotNull() {
            addCriterion("UC is not null");
            return (Criteria) this;
        }

        public Criteria andUcEqualTo(BigDecimal value) {
            addCriterion("UC =", value, "uc");
            return (Criteria) this;
        }

        public Criteria andUcNotEqualTo(BigDecimal value) {
            addCriterion("UC <>", value, "uc");
            return (Criteria) this;
        }

        public Criteria andUcGreaterThan(BigDecimal value) {
            addCriterion("UC >", value, "uc");
            return (Criteria) this;
        }

        public Criteria andUcGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("UC >=", value, "uc");
            return (Criteria) this;
        }

        public Criteria andUcLessThan(BigDecimal value) {
            addCriterion("UC <", value, "uc");
            return (Criteria) this;
        }

        public Criteria andUcLessThanOrEqualTo(BigDecimal value) {
            addCriterion("UC <=", value, "uc");
            return (Criteria) this;
        }

        public Criteria andUcIn(List<BigDecimal> values) {
            addCriterion("UC in", values, "uc");
            return (Criteria) this;
        }

        public Criteria andUcNotIn(List<BigDecimal> values) {
            addCriterion("UC not in", values, "uc");
            return (Criteria) this;
        }

        public Criteria andUcBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UC between", value1, value2, "uc");
            return (Criteria) this;
        }

        public Criteria andUcNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UC not between", value1, value2, "uc");
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

        public Criteria andPfaIsNull() {
            addCriterion("PFA is null");
            return (Criteria) this;
        }

        public Criteria andPfaIsNotNull() {
            addCriterion("PFA is not null");
            return (Criteria) this;
        }

        public Criteria andPfaEqualTo(BigDecimal value) {
            addCriterion("PFA =", value, "pfa");
            return (Criteria) this;
        }

        public Criteria andPfaNotEqualTo(BigDecimal value) {
            addCriterion("PFA <>", value, "pfa");
            return (Criteria) this;
        }

        public Criteria andPfaGreaterThan(BigDecimal value) {
            addCriterion("PFA >", value, "pfa");
            return (Criteria) this;
        }

        public Criteria andPfaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PFA >=", value, "pfa");
            return (Criteria) this;
        }

        public Criteria andPfaLessThan(BigDecimal value) {
            addCriterion("PFA <", value, "pfa");
            return (Criteria) this;
        }

        public Criteria andPfaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PFA <=", value, "pfa");
            return (Criteria) this;
        }

        public Criteria andPfaIn(List<BigDecimal> values) {
            addCriterion("PFA in", values, "pfa");
            return (Criteria) this;
        }

        public Criteria andPfaNotIn(List<BigDecimal> values) {
            addCriterion("PFA not in", values, "pfa");
            return (Criteria) this;
        }

        public Criteria andPfaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PFA between", value1, value2, "pfa");
            return (Criteria) this;
        }

        public Criteria andPfaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PFA not between", value1, value2, "pfa");
            return (Criteria) this;
        }

        public Criteria andPfbIsNull() {
            addCriterion("PFB is null");
            return (Criteria) this;
        }

        public Criteria andPfbIsNotNull() {
            addCriterion("PFB is not null");
            return (Criteria) this;
        }

        public Criteria andPfbEqualTo(BigDecimal value) {
            addCriterion("PFB =", value, "pfb");
            return (Criteria) this;
        }

        public Criteria andPfbNotEqualTo(BigDecimal value) {
            addCriterion("PFB <>", value, "pfb");
            return (Criteria) this;
        }

        public Criteria andPfbGreaterThan(BigDecimal value) {
            addCriterion("PFB >", value, "pfb");
            return (Criteria) this;
        }

        public Criteria andPfbGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PFB >=", value, "pfb");
            return (Criteria) this;
        }

        public Criteria andPfbLessThan(BigDecimal value) {
            addCriterion("PFB <", value, "pfb");
            return (Criteria) this;
        }

        public Criteria andPfbLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PFB <=", value, "pfb");
            return (Criteria) this;
        }

        public Criteria andPfbIn(List<BigDecimal> values) {
            addCriterion("PFB in", values, "pfb");
            return (Criteria) this;
        }

        public Criteria andPfbNotIn(List<BigDecimal> values) {
            addCriterion("PFB not in", values, "pfb");
            return (Criteria) this;
        }

        public Criteria andPfbBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PFB between", value1, value2, "pfb");
            return (Criteria) this;
        }

        public Criteria andPfbNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PFB not between", value1, value2, "pfb");
            return (Criteria) this;
        }

        public Criteria andPfcIsNull() {
            addCriterion("PFC is null");
            return (Criteria) this;
        }

        public Criteria andPfcIsNotNull() {
            addCriterion("PFC is not null");
            return (Criteria) this;
        }

        public Criteria andPfcEqualTo(BigDecimal value) {
            addCriterion("PFC =", value, "pfc");
            return (Criteria) this;
        }

        public Criteria andPfcNotEqualTo(BigDecimal value) {
            addCriterion("PFC <>", value, "pfc");
            return (Criteria) this;
        }

        public Criteria andPfcGreaterThan(BigDecimal value) {
            addCriterion("PFC >", value, "pfc");
            return (Criteria) this;
        }

        public Criteria andPfcGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PFC >=", value, "pfc");
            return (Criteria) this;
        }

        public Criteria andPfcLessThan(BigDecimal value) {
            addCriterion("PFC <", value, "pfc");
            return (Criteria) this;
        }

        public Criteria andPfcLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PFC <=", value, "pfc");
            return (Criteria) this;
        }

        public Criteria andPfcIn(List<BigDecimal> values) {
            addCriterion("PFC in", values, "pfc");
            return (Criteria) this;
        }

        public Criteria andPfcNotIn(List<BigDecimal> values) {
            addCriterion("PFC not in", values, "pfc");
            return (Criteria) this;
        }

        public Criteria andPfcBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PFC between", value1, value2, "pfc");
            return (Criteria) this;
        }

        public Criteria andPfcNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PFC not between", value1, value2, "pfc");
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