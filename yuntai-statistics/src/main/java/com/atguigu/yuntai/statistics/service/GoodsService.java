package com.atguigu.yuntai.statistics.service;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.yuntai.common.utils.NameValueData;
import com.atguigu.yuntai.statistics.bean.AdsTradeStatsByTm;

import java.util.List;

/**
 * @program: gmall
 * @description: 商品统计service
 */
public interface GoodsService {

    String getTmRepeat(int recentDays, String curDate, int showNum);

    List<AdsTradeStatsByTm> getTmTradeStats(int recentDays, String curDate);

    List<JSONObject> getCateTradeStats(int recentDays, String curDate);

    List<NameValueData> getCategory1(String curDate);

    List<NameValueData> getCategory2(String curDate, String category1_id);

    List<NameValueData> getCategory3(String curDate, String category1_id, String category2_id);

    String getTmTopNData(String curDate, String category1_id, String category2_id, String category3_id);
}

