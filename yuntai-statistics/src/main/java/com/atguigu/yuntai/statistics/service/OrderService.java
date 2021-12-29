package com.atguigu.yuntai.statistics.service;

import com.atguigu.yuntai.statistics.bean.AdsTradeStats;
import com.atguigu.yuntai.statistics.bean.QOrder;

import java.util.List;
import java.util.Map;

/**
 * @program: gmall
 * @description:
 */
public interface OrderService {


    AdsTradeStats getTradeByDaysAndDt(int days, String dt);

    List<Map> getOrderProvinceData(int days, String dt, String orderSelect);

}
