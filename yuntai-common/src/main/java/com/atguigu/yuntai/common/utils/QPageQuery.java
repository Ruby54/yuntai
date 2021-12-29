package com.atguigu.yuntai.common.utils;

/**
 * @program: yuntai
 * @description:
 * @author: Zhao Yi
 * @create: 2021-12-15 11:08
 */
public class QPageQuery<Q extends Query> implements Query {
    private Pagination pagination;
    private Q query;

    public QPageQuery() {
    }

    public QPageQuery(Pagination pagination, Q query) {
        this.pagination = pagination;
        this.query = query;
    }

    public Pagination getPagination() {
        return this.pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Q getQuery() {
        return this.query;
    }

    public void setQuery(Q query) {
        this.query = query;
    }
}
