package com.atguigu.yuntai.statistics.service;

import com.atguigu.yuntai.statistics.bean.AdsActivityStats;
import com.atguigu.yuntai.statistics.bean.QActivity;

import java.util.List;

/**
 * @program: gmall
 * @description: 活动统计
 */
public interface ActivityService {
    /**
     * 根据时间查询活动名称
     * @param qActivity
     * @return
     */
    List<String> getActivityNameByStartDate(QActivity qActivity);

    /**
     * 根据时间名称和dt查询所有
     * @param qActivity
     * @return
     */
    List<AdsActivityStats> getActivityList(QActivity qActivity);
}
