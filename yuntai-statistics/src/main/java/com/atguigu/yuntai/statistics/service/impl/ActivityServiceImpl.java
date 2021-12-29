package com.atguigu.yuntai.statistics.service.impl;

import com.atguigu.yuntai.statistics.bean.AdsActivityStats;
import com.atguigu.yuntai.statistics.bean.QActivity;
import com.atguigu.yuntai.statistics.mapper.ActivityMapper;
import com.atguigu.yuntai.statistics.service.ActivityService;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: gmall
 * @description:活动分析实现类
 *
 * @DS注解：为了实现动态选择数据源
 */

@DS("mysql")
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;


    /**
     * 根据开始时间查询活动名称
     * @param qActivity
     * @return
     */
    @Override
    public List<String> getActivityNameByStartDate(QActivity qActivity) {
        List<String> nameList = new ArrayList<String>();
        if(StringUtils.isNotEmpty(qActivity.getStartDate())){
            nameList = activityMapper.getActivityNameByStartDate(qActivity.getStartDate());
        }
        return nameList;
    }

    /**
     * 根据开始时间和活动名称查询所有活动统计
     * @param qActivity
     * @return
     */
    @Override
    public List<AdsActivityStats> getActivityList(QActivity qActivity) {
        List<AdsActivityStats> activityList = new ArrayList<>();
        if(qActivity!=null){
            activityList = activityMapper.getActivityList(qActivity);
        }
        return activityList;
    }
}
