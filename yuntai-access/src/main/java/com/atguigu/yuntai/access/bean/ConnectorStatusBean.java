package com.atguigu.yuntai.access.bean;

import com.alibaba.fastjson.JSONObject;

public class ConnectorStatusBean {
    private String state;
    private String workerId;

    public ConnectorStatusBean() {
        state = "";
        workerId = "";
    }

    public void readState(JSONObject connectorStatus) {
        state = connectorStatus.getString("state");
        workerId = connectorStatus.getString("worker_id");
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }
}
