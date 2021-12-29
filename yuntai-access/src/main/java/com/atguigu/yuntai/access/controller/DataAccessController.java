package com.atguigu.yuntai.access.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.yuntai.access.bean.ConnectorBean;
import com.atguigu.yuntai.access.service.DataAccessService;
import com.atguigu.yuntai.common.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DataAccessController {

    @Autowired
    private DataAccessService dataAccessService;

    //新增Connector Post
    @RequestMapping(value = "registerConnector", method = RequestMethod.POST)
    @CrossOrigin
    public Response registerConnector(@RequestBody ConnectorBean connector) {
        return dataAccessService.registerConnector(connector);
    }

    //删除Connector
    @RequestMapping(value = "deleteConnector", method = RequestMethod.GET)
    @CrossOrigin
    public Response deleteConnector(@RequestParam String name) {
        return dataAccessService.deleteConnector(name);
    }

    //暂停Connector
    @RequestMapping(value = "pauseConnector", method = RequestMethod.GET)
    @CrossOrigin
    public Response pauseConnector(@RequestParam String name) {
        return dataAccessService.pauseConnector(name);
    }

    //恢复Connector
    @RequestMapping(value = "resumeConnector", method = RequestMethod.GET)
    @CrossOrigin
    public Response resumeConnector(@RequestParam String name) {
        return dataAccessService.resumeConnector(name);
    }

    //查询所有Connector
    @RequestMapping(value = "getConnectorList", method = RequestMethod.GET)
    @CrossOrigin
    public List<ConnectorBean> getConnectorList(@RequestParam String category) {
        return dataAccessService.getConnectorList(category);
    }

    //查询Connector详情
    @RequestMapping(value = "getStatus", method = RequestMethod.GET)
    @CrossOrigin
    public ConnectorBean getStatus(@RequestParam String name) {
        return dataAccessService.getStatus(name);
    }

    //更新Connector配置 Post
    @RequestMapping(value = "updateConnector", method = RequestMethod.POST)
    @CrossOrigin
    public Response updateConnector(@RequestBody ConnectorBean connector) {
        return dataAccessService.updateConnector(connector);
    }

    //获取Connector所有Task

    //获取指定Task状态

    //重启Connector

    //重启Task

    //获取Connector的Topic

    //清空指定Topic
}
