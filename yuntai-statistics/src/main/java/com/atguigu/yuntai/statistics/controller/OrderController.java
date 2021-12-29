package com.atguigu.yuntai.statistics.controller;

import com.atguigu.yuntai.statistics.bean.AdsTradeStats;
import com.atguigu.yuntai.statistics.bean.QOrder;
import com.atguigu.yuntai.statistics.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @program: gmall
 * @description: 订单统计
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    /**
     *订单统计
     * @param days
     * @param dt
     * @return
     */
    @RequestMapping(value ="getTradeByDaysAndDt",method = {RequestMethod.GET})
    @CrossOrigin
    public AdsTradeStats getTradeByDaysAndDt(@RequestParam int days, @RequestParam String dt){
        return orderService.getTradeByDaysAndDt(days,dt);
    }


    /**
     *各省份交易统计
     * @param days
     * @param dt
     * @param orderSelect
     * @return
     */
    @RequestMapping(value ="getOrderProvinceData",method = {RequestMethod.GET})
    @CrossOrigin
    public List<Map> getOrderProvinceData(@RequestParam int days, @RequestParam String dt, @RequestParam String orderSelect){
        return orderService.getOrderProvinceData(days,dt,orderSelect);
    }
}
