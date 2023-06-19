package com.example.finaltest.utils;

import java.util.Collection;
import java.util.List;

public class SelectQueryBuilder {

    private String selectClause;
    private String fromClause;
    private ParamHolder paramHolder;

    private WhereClauseBuilder whereClauseBuilder;
    private StringBuilder havingClauseBuilder;
    private OrderClauseBuilder orderClauseBuilder;
    private StringBuilder limitClause;
    private StringBuilder groupByClauseBuilder;

    public SelectQueryBuilder(String fromClause) {
        this.selectClause = "*";
        this.fromClause = fromClause;
        this.paramHolder = new ParamHolder();
        this.whereClauseBuilder = new WhereClauseBuilder();
        this.havingClauseBuilder = new StringBuilder();
        this.orderClauseBuilder = new OrderClauseBuilder();
        this.limitClause = new StringBuilder();
        this.groupByClauseBuilder = new StringBuilder();
    }

    public void andClause(String clause){
        this.whereClauseBuilder.andClause(clause);
    }

    public void orClause(String clause){
        this.whereClauseBuilder.orClause(clause);
    }

    public void setSelectClause(String selectClause) {
        this.selectClause = selectClause;
    }

    public void setFromClause(String fromClause) {
        this.fromClause = fromClause;
    }

    public void addParams(Object param){
        this.paramHolder.add(param);
    }

    public void addParams(Collection<? extends Object> params) {
        paramHolder.addAll(params);
    }

    public List<Object> _getParams() {
        return paramHolder._getParams();
    }

    public String getQuery() {
        StringBuilder query = new StringBuilder();
        query.append(String.format(" SELECT %s", selectClause));
        query.append(String.format(" FROM %s", fromClause));

        if (!whereClauseBuilder.isEmpty()) {
            query.append(String.format(" WHERE %s", whereClauseBuilder.getClause()));
        }

        if (groupByClauseBuilder.length() > 0) {
            query.append(String.format(" GROUP BY %s", groupByClauseBuilder.toString()));
        }

        if (havingClauseBuilder.length() > 0) {
            query.append(String.format(" HAVING %s", havingClauseBuilder.toString()));
        }

        if (!orderClauseBuilder.isEmpty()) {
            query.append(String.format(" ORDER BY %s", orderClauseBuilder.getClause()));
        }

        if (limitClause.length() > 0) {
            query.append(String.format(" LIMIT %s", limitClause.toString()));
        }

        return query.toString();
    }
}
