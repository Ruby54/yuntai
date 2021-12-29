package com.atguigu.yuntai.statistics.controller;

import com.atguigu.yuntai.statistics.bean.AdsTrafficStats;
import com.atguigu.yuntai.statistics.service.VisitStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: gmall
 * @description: 流量统计controller
 */
@RestController
public class VisitStatsController {

    @Autowired
    private VisitStatsService visitStatsService;


    /**
     *各渠道访问流量统计
     * @param days
     * @param dt
     * @return
     */
    @RequestMapping("getPagePath")
    @CrossOrigin
    public String getPagePath(@RequestParam("days") int days, @RequestParam("dt") String dt) {
        String pagePathString = visitStatsService.getPagePathCount(days, dt);

        return visitStatsService.getPagePathCount(days, dt);
    }

    /**
     *用户路径分析
     * @param days
     * @param dt
     * @return
     */
    @RequestMapping(value ="getTrafficStats",method = {RequestMethod.GET})
    @CrossOrigin
    public List<AdsTrafficStats> getTrafficStats(@RequestParam int days, @RequestParam String dt) {
        return visitStatsService.getTrafficStats(days, dt);
    }
}


