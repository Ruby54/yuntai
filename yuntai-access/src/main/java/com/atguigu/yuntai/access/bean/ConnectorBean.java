package com.atguigu.yuntai.access.bean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConnectorBean {

    private String name;
    private ConfigBean config;
    private List<TaskBean> tasks;
    private ConnectorStatusBean connectorStatus;
    private String type;

    public ConnectorBean() {
        name = "";
        config = new ConfigBean();
        tasks = new ArrayList<>();
        connectorStatus = new ConnectorStatusBean();
        type = "";
    }

    public void readConfig(JSONObject config) {
        name = config.getString("name");
        this.config.readConfig(config.getJSONObject("config"));
        type = config.getString("type");
    }

    public void readState(JSONObject state) {
        name = state.getString("name");
        this.connectorStatus.readState(state.getJSONObject("connector"));
        tasks.clear();
        JSONArray tasks = JSON.parseArray(state.getString("tasks"));
        for (Object task : tasks) {
            TaskBean taskBean = new TaskBean();
            taskBean.readState(JSON.parseObject(task.toString()));
            this.tasks.add(taskBean);
        }

    }

    public JSONObject dumpConfig() {
        return new JSONObject()
                .fluentPut("name", name)
                .fluentPut("config", config.dump());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConfigBean getConfig() {
        return config;
    }

    public void setConfig(ConfigBean config) {
        this.config = config;
    }

    public List<TaskBean> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskBean> tasks) {
        this.tasks = tasks;
    }

    public ConnectorStatusBean getConnectorStatus() {
        return connectorStatus;
    }

    public void setConnectorStatus(ConnectorStatusBean connectorStatus) {
        this.connectorStatus = connectorStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
