package com.atguigu.yuntai.statistics.mapper;

import com.atguigu.yuntai.common.utils.NameValueData;
import com.atguigu.yuntai.statistics.bean.AdsOrderByProvince;
import com.atguigu.yuntai.statistics.bean.AdsTradeStats;
import com.atguigu.yuntai.statistics.bean.QOrder;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderTotalMapper {


    @Select("select * from ads_trade_stats where dt = #{dt} and recent_days = #{days}")
    AdsTradeStats getTradeByDaysAndDt(int days, String dt);

    @Select("select province_name,order_count from ads_order_by_province where dt = #{dt} and recent_days = #{days} order by order_count ASC;")
    List<AdsOrderByProvince> getOrderProvinceCount(int days, String dt);

    @Select("select province_name,order_total_amount from ads_order_by_province where dt = #{dt} and recent_days = #{days} order by order_total_amount ASC;")
    List<AdsOrderByProvince> getOrderProvinceTotalAmount(int days, String dt);
}
