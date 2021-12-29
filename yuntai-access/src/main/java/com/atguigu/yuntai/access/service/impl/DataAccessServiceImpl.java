package com.atguigu.yuntai.access.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.yuntai.access.bean.ConfigBean;
import com.atguigu.yuntai.access.bean.ConnectorBean;
import com.atguigu.yuntai.access.bean.ConnectorCache;
import com.atguigu.yuntai.access.service.DataAccessService;
import com.atguigu.yuntai.common.utils.Response;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DataAccessServiceImpl implements DataAccessService {

    private final String url = "http://hadoop102:8083";
    private final HttpClient client = new HttpClient();
    private final ConnectorCache connectorCache = new ConnectorCache();


    @Override
    public Response registerConnector(ConnectorBean connector) {
        Response response = new Response();
        try {
            PostMethod postMethod = new PostMethod(url + "/connectors/");
            String s = connector.dumpConfig().toJSONString();
            StringRequestEntity request = new StringRequestEntity(
                    connector.dumpConfig().toJSONString(),
                    "application/json",
                    "UTF-8"
            );
            postMethod.setRequestHeader("Accept", "application/json");
            postMethod.setRequestEntity(request);
            client.executeMethod(postMethod);
            if (postMethod.getStatusLine().getStatusCode() == 201) {
                updateCache();
                response.success(postMethod.getStatusLine().getReasonPhrase());
            } else {
                response.fail(postMethod.getStatusLine().getReasonPhrase());
            }
        } catch (IOException e) {
            e.printStackTrace();
            response.fail(e);
        }

        return response;
    }

    @Override
    public Response deleteConnector(String name) {
        Response response = new Response();
        try {
            DeleteMethod method = new DeleteMethod(url + "/connectors/" + name);
            client.executeMethod(method);
            updateCache();
            if (method.getStatusLine().getStatusCode() == 204) {
                response.success();
            } else {
                response.fail(method.getStatusLine().getReasonPhrase());
            }
        } catch (IOException e) {
            e.printStackTrace();
            response.fail(e);
        }
        return response;
    }

    @Override
    public Response pauseConnector(String name) {
        Response response = new Response();
        try {
            PutMethod method = new PutMethod(url + "/connectors/" + name + "/pause");
            client.executeMethod(method);
            updateCache();
            if (method.getStatusLine().getStatusCode() == 202) {
                response.success();
            } else {
                response.fail(method.getStatusLine().getReasonPhrase());
            }
        } catch (IOException e) {
            e.printStackTrace();
            response.fail(e);
        }

        return response;
    }

    @Override
    public Response resumeConnector(String name) {
        Response response = new Response();
        try {
            PutMethod method = new PutMethod(url + "/connectors/" + name + "/resume");
            client.executeMethod(method);
            updateCache();
            if (method.getStatusLine().getStatusCode() == 202) {
                response.success();
            } else {
                response.fail(method.getStatusLine().getReasonPhrase());
            }
        } catch (IOException e) {
            e.printStackTrace();
            response.fail(e);
        }
        return response;
    }

    @Override
    public List<ConnectorBean> getConnectorList(String category) {
        if (connectorCache.size() == 0) {
            updateCache();
        }

        return connectorCache.getConnectorList(category);
    }

    @Override
    public ConnectorBean getStatus(String name) {

        if (connectorCache.size() == 0) {
            updateCache();
        }
        return connectorCache.getConnector(name);
    }

    @Override
    public Response updateConnector(ConnectorBean connector) {
        Response response = new Response();
        try {
            String name = connector.getName();
            JSONObject rawConfig = connector.getConfig().dump();
            PutMethod method = new PutMethod(url + "/connectors/" + name + "/config");
            method.setRequestHeader("Accept", "application/json");
            StringRequestEntity request = new StringRequestEntity(
                    rawConfig.toJSONString(),
                    "application/json",
                    "UTF-8"
            );
            method.setRequestEntity(request);
            client.executeMethod(method);
            updateCache();
            if (method.getStatusLine().getStatusCode() == 200) {
                response.success(method.getStatusLine().getReasonPhrase());
            } else {
                response.fail(method.getStatusLine().getReasonPhrase());
            }
        } catch (IOException e) {
            e.printStackTrace();
            response.fail(e);
        }
        return response;
    }

    private void updateCache() {
        GetMethod getMethod = new GetMethod(url + "/connectors");
        connectorCache.clear();
        try {
            client.executeMethod(getMethod);
            JSONArray connectors = JSON.parseArray(getMethod.getResponseBodyAsString());
            for (Object connector : connectors) {
                //遍历所有名字, 获取已经存在的缓存
                String name = connector.toString();
                ConnectorBean connectorBean = new ConnectorBean();
//                ConnectorBean connectorBean = connectorCache.getConnector(name);

                //获取详情
                GetMethod config = new GetMethod(url + "/connectors/" + name);
                do {
                    Thread.sleep(100);
                    client.executeMethod(config);
                } while (config.getStatusLine().getStatusCode() != 200);
                JSONObject connectorConfig = JSON.parseObject(config.getResponseBodyAsString());
                connectorBean.readConfig(connectorConfig);

                //获取状态
                GetMethod status = new GetMethod(url + "/connectors/" + name + "/status");
                client.executeMethod(status);
                JSONObject connectorStatus = JSON.parseObject(status.getResponseBodyAsString());
                connectorBean.readState(connectorStatus);

                //更新cache
                connectorCache.addConnector(connectorBean);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
