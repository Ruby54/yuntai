package com.atguigu.yuntai.statistics.service.impl;


import com.atguigu.yuntai.common.utils.EchartsConverter;
import com.atguigu.yuntai.common.utils.NameValueData;
import com.atguigu.yuntai.statistics.bean.AdsOrderByProvince;
import com.atguigu.yuntai.statistics.bean.AdsTradeStats;
import com.atguigu.yuntai.statistics.bean.QOrder;
import com.atguigu.yuntai.statistics.mapper.OrderTotalMapper;
import com.atguigu.yuntai.statistics.service.OrderService;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: gmall
 * @description: 订单管理实现类
 */
@DS("mysql")
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderTotalMapper orderTotalMapper;


    /**
     * 获取订单的昨天、近7天以及近30天的订单数、GMV、下单人数
     * @param days
     * @param dt
     * @return
     */
    @Override
    public AdsTradeStats getTradeByDaysAndDt(int days, String dt) {

        return orderTotalMapper.getTradeByDaysAndDt(days,dt);
    }

    /**
     * 获取各省份的订单数交易统计
     * @param days
     * @param dt
     * @param orderSelect
     * @return
     */
    @Override
    public List<Map> getOrderProvinceData(int days, String dt,String orderSelect) {

        List<Map> orderProvinceList = new ArrayList<>();
        List<AdsOrderByProvince> orderProvinceDataList = new ArrayList<>();
        //TODO:是否要根据订单数和订单金额分别统计
//        if(orderSelect.equals("订单数")){
//            orderProvinceDataList = orderTotalMapper.getOrderProvinceCount(days, dt);
//        }else{
//            orderProvinceDataList = orderTotalMapper.getOrderProvinceTotalAmount(days, dt);
//        }
        if(CollectionUtils.isNotEmpty(orderProvinceDataList)){
            for(AdsOrderByProvince adsOrderByProvince : orderProvinceDataList){
                Map<String, String> orderProvinceMap = new HashMap<>();
                orderProvinceMap.put("name",adsOrderByProvince.getProvince_name());
                if(adsOrderByProvince.getOrder_count()!=0){
                    orderProvinceMap.put("value",Integer.toString(adsOrderByProvince.getOrder_count()));
                }else{
                    orderProvinceMap.put("value",adsOrderByProvince.getOrder_total_amount().toString());
                }
                orderProvinceList.add(orderProvinceMap);
            }
        }
        return orderProvinceList ;
    }

    /**
     * 通过当前日期获得统计日期
     * @param td
     * @return
     */
    private String getStatsDt(String td){
        String dateString = "";
        try{
            DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = format1.parse(td);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            dateString = formatter.format(parse);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dateString;
    }


}
