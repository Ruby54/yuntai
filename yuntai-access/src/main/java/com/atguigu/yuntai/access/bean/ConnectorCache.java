package com.atguigu.yuntai.access.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConnectorCache {
    private final Map<String, ConnectorBean> cache;
    private final Map<String, String> categoryMap;

    public int size() {
        return cache.size();
    }

    public ConnectorCache() {
        cache = new HashMap<>();
        categoryMap = new HashMap<>();
        categoryMap.put("mysql", "io.debezium.connector.mysql.MySqlConnector");
        categoryMap.put("postgresql", "io.debezium.connector.postgresql.PostgresConnector");
        categoryMap.put("sqlserver", "io.debezium.connector.sqlserver.SqlServerConnector");
        categoryMap.put("mongodb", "io.debezium.connector.mongodb.MongoDbConnector");
    }

    public void addConnector(ConnectorBean connector) {
        cache.put(connector.getName(), connector);
    }

    public void deleteConnector(String name) {
        cache.remove(name);
    }

    public void clear() {
        cache.clear();
    }

    public List<ConnectorBean> getConnectorList(String category) {
        return cache.values()
                .stream()
                .filter(o -> o.getConfig().getConnector_class().equals(categoryMap.get(category)))
                .collect(Collectors.toList());
    }

    public ConnectorBean getConnector(String name) {
        return cache.getOrDefault(name, new ConnectorBean());
    }
}
