package com.atguigu.yuntai.statistics.service.impl;

import com.alibaba.fastjson.JSON;
import com.atguigu.yuntai.statistics.bean.AdsTrafficStats;
import com.atguigu.yuntai.statistics.mapper.PagePathMapper;
import com.atguigu.yuntai.statistics.mapper.VisitTrafficStatsMapper;
import com.atguigu.yuntai.statistics.service.VisitStatsService;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @program: gmall
 * @description: 流量统计实现类
 */
@DS("mysql")
@Service
public class VisitStatsServiceImpl implements VisitStatsService {

    @Autowired
    private PagePathMapper pagePathMapper;

    @Autowired
    private VisitTrafficStatsMapper visitTrafficStatsMapper;

    /**
     * 用户路径分析
     * @param days
     * @param dt
     * @return
     */
    @Override
    public String getPagePathCount(int days, String dt) {
        Map rsMap = new HashMap();
            List<Map> pagePathMapList = pagePathMapper.getPagePathCount(days, dt);
            if(CollectionUtils.isNotEmpty(pagePathMapList)){
                HashSet<String> nodeSet = new HashSet();
                List<Map> nodeMapList = new ArrayList<>();
                for (Map pagePathMap : pagePathMapList) {
                    String source = (String) pagePathMap.get("source");
                    String target = (String) pagePathMap.get("target");
                    nodeSet.add(source);
                    nodeSet.add(target);
                }
                for (String nodeName : nodeSet) {
                    Map<String, String> nodeMap = new HashMap<>();
                    nodeMap.put("name", nodeName);
                    nodeMapList.add(nodeMap);
                }
                rsMap.put("nodeData", nodeMapList);
                rsMap.put("linksData", pagePathMapList);
            }


            return JSON.toJSONString(rsMap);
    }

    /**
     *各渠道流量统计
     * @param days
     * @param dt
     * @return
     */
    @Override
    public List<AdsTrafficStats> getTrafficStats(int days, String dt) {

        return visitTrafficStatsMapper.getTrafficStats(days,dt);
    }
}

