package com.atguigu.yuntai.statistics.controller;

import com.atguigu.yuntai.statistics.bean.AdsActivityStats;
import com.atguigu.yuntai.statistics.bean.QActivity;
import com.atguigu.yuntai.statistics.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: gmall
 * @description: 最近30天发布的活动的补贴率
 */
@RestController
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    /**
     * 根据开始时间查询活动名称
     * @param qActivity
     * @return
     */
    @RequestMapping(value ="getActivityNameByStartDate",method = {RequestMethod.POST})
    @CrossOrigin
    public List<String> getActivityNameByStartDate(@RequestBody QActivity qActivity) {
        List<String> activityNameList = activityService.getActivityNameByStartDate(qActivity);
        return activityNameList;
    }

    /**
     * 根据开始时间和活动名称查询所有活动统计
     * @param qActivity
     * @return
     */
    @RequestMapping(value ="getActivityList",method = {RequestMethod.POST})
    @ResponseBody
    @CrossOrigin
    public List<AdsActivityStats> getActivityList(@RequestBody QActivity qActivity){
        return activityService.getActivityList(qActivity);
    }

}
