package com.atguigu.yuntai.common.utils;

/**
 * @description:针对vue的select下拉框
 */
public class Dictionary {
    private String label;
    private Object value;

    public Dictionary() {
    }

    public Dictionary(String label, Object value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
