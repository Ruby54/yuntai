package com.atguigu.yuntai.common.utils;

import java.io.Serializable;
import java.util.List;

/**
 * @program: yuntai
 * @description:
 * @author: Zhao Yi
 * @create: 2021-12-15 11:19
 */
public class Page<M> implements Serializable {
    private Pagination pagination;
    private List<M> result;

    public Page() {
    }

    public Page(Pagination pagination, List<M> result) {
        this.pagination = pagination;
        this.result = result;
    }

    public Pagination getPagination() {
        return this.pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<M> getResult() {
        return this.result;
    }

    public void setResult(List<M> result) {
        this.result = result;
    }

    public boolean hasNext() {
        if (this.result != null && this.result.size() >= this.pagination.getPageSize()) {
            return this.pagination.getPageNo() < this.pagination.getTotalPage();
        } else {
            return false;
        }
    }
}
