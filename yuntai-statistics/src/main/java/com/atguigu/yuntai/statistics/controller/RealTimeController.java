package com.atguigu.yuntai.statistics.controller;

import com.atguigu.yuntai.statistics.bean.ProductStats;
import com.atguigu.yuntai.statistics.bean.ProvinceStats;
import com.atguigu.yuntai.statistics.bean.ReturnVisitorStats;
import com.atguigu.yuntai.statistics.bean.VisitorStats;
import com.atguigu.yuntai.statistics.service.RealTimeService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 实时统计
 */
@RestController
public class RealTimeController {

    @Autowired
    RealTimeService realTimeService;


    /**
     * 获取某一天的总交易额
     * @param date
     * @return
     */
    @RequestMapping("/gmv")
    @CrossOrigin
    public String getGMV(@RequestParam(value = "date",defaultValue = "0") Integer date) {
        if(date==0){
            date=now();
        }
        BigDecimal gmv = realTimeService.getGMV(date);
        String json = "{   \"status\": 0,  \"data\":" + gmv + "}";
        return  json;
    }


    /**
     * 统计某天不同SPU商品交易额排名
     * @param date
     * @param limit
     * @return
     */
    @RequestMapping("/spu")
    @CrossOrigin
    public List<ProductStats> getProductStatsGroupBySpu(
            @RequestParam(value = "date", defaultValue = "0") Integer date,
            @RequestParam(value = "limit", defaultValue = "10") int limit) {
        if (date == 0) date = now();
        List<ProductStats> statsList
                = realTimeService.getProductStatsGroupBySpu(date, limit);
        return statsList;
    }

    /**
     * 统计某天不同类别商品交易额排名
     * @param date
     * @param limit
     * @return
     */
    @RequestMapping(value ="/category3",method = {RequestMethod.GET})
    @CrossOrigin
    public String getProductStatsGroupByCategory3(
            @RequestParam(value = "date", defaultValue = "0") Integer date,
            @RequestParam(value = "limit", defaultValue = "4") int limit) {
        if (date == 0) {
            date = now();
        }
        return realTimeService.getProductStatsGroupByCategory3(date, limit);
    }


    /**
     * 统计某天不同品牌商品交易额排名
     * @param date
     * @param limit
     * @return
     */
    @RequestMapping("/trademark")
    @CrossOrigin
    public String getProductStatsByTrademark(
            @RequestParam(value = "date", defaultValue = "0") Integer date,
            @RequestParam(value = "limit", defaultValue = "20") int limit) {
        if (date == 0) {
            date = now();
        }
        String productStatsByTrademarkList
                = realTimeService.getProductStatsByTrademark(date, limit);
        return productStatsByTrademarkList;
    }

    /**
     * 地区
     * @param date
     * @return
     */
    @RequestMapping("/province")
    @CrossOrigin
    public List<Map> getProvinceStats(@RequestParam(value = "date", defaultValue = "0") Integer date) {
        if (date == 0) {
            date = now();
        }
        List<Map> provinceStatsList = realTimeService.getProvinceStats(date);
        return provinceStatsList;
    }


    /**
     * 新老用户对比
     * @param date
     * @return
     */
    @RequestMapping("/visitor")
    @CrossOrigin
    public List<ReturnVisitorStats> getVisitorStatsByNewFlag(@RequestParam(value = "date", defaultValue = "0") Integer date) {
        if (date == 0) date = now();
        List<ReturnVisitorStats> visitorStatsByNewFlag = realTimeService.getVisitorStatsByNewFlag(date);
        return visitorStatsByNewFlag;
    }


    /**
     * 用户访问分时
     * @param date
     * @return
     */
    @RequestMapping("/hr")
    @CrossOrigin
    public String getMidStatsGroupbyHourNewFlag(@RequestParam(value = "date",defaultValue = "0") Integer date ) {
        if(date==0)  date=now();
        String visitorStatsHrList
                = realTimeService.getVisitorStatsByHour(date);
        return  visitorStatsHrList;
    }

    private int now(){
        String yyyyMMdd = DateFormatUtils.format(new Date(), "yyyyMMdd");
        return   Integer.valueOf(yyyyMMdd);
    }
}
