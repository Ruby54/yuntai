package com.atguigu.yuntai.access.bean;

import com.alibaba.fastjson.JSONObject;

public class TaskBean {
    private String id;
    private String state;
    private String workerId;

    public TaskBean() {
        id = "";
        state = "";
        workerId = "";
    }

    public void readState(JSONObject task) {
        id = task.getString("id");
        state = task.getString("state");
        workerId = task.getString("worker_id");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
