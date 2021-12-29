package com.atguigu.yuntai.statistics.service;

import com.atguigu.yuntai.statistics.bean.AdsTrafficStats;

import java.util.List;

/**
 * @program: gmall
 * @description: 流量统计service
 */
public interface VisitStatsService {

    String getPagePathCount(int days, String dt);

    List<AdsTrafficStats> getTrafficStats(int days, String dt);
}
