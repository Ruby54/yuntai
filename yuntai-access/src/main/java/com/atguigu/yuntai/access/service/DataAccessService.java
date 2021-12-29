package com.atguigu.yuntai.access.service;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.yuntai.access.bean.ConnectorBean;
import com.atguigu.yuntai.common.utils.Response;

import java.util.List;

public interface DataAccessService {
    //新增Connector Post
    public Response registerConnector(ConnectorBean connector);

    //删除Connector
    public Response deleteConnector(String name);

    //暂停Connector
    public Response pauseConnector(String name);

    //恢复Connector
    public Response resumeConnector(String name);

    //查询所有Connector
    public List<ConnectorBean> getConnectorList(String category);

    //查询Connector详情
    public ConnectorBean getStatus(String name);

    //更新Connector配置 Post
    public Response updateConnector(ConnectorBean connector);

    //获取Connector所有Task

    //获取指定Task状态

    //重启Connector

    //重启Task

    //获取Connector的Topic

    //清空指定Topic
}
