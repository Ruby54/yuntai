package com.atguigu.yuntai.statistics.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.yuntai.common.utils.EchartsConverter;
import com.atguigu.yuntai.common.utils.NameValueData;
import com.atguigu.yuntai.statistics.bean.AdsTradeStatsByCate;
import com.atguigu.yuntai.statistics.bean.AdsTradeStatsByTm;
import com.atguigu.yuntai.statistics.mapper.RepeatPurchaseMapper;
import com.atguigu.yuntai.statistics.mapper.SkuCartNumTop3;
import com.atguigu.yuntai.statistics.mapper.TradeStatsCateMapper;
import com.atguigu.yuntai.statistics.mapper.TradeStatsTmMapper;
import com.atguigu.yuntai.statistics.service.GoodsService;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: gmall
 * @description: 商品统计实现类
 */
@DS("mysql")
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private RepeatPurchaseMapper repeatPurchaseMapper;

    @Autowired
    private TradeStatsTmMapper tradeStatsTmMapper;

    @Autowired
    private TradeStatsCateMapper tradeStatsCateMapper;

    @Autowired
    private SkuCartNumTop3 skuCartNumTop3;

    /**
     * 最近7/30日各品牌复购率
     * @param recentDays
     * @param curDate
     * @param showNum
     * @return
     */
    @Override
    public String getTmRepeat(int recentDays, String curDate, int showNum) {
        List<NameValueData> tmRepeatList = repeatPurchaseMapper.getTmRepeat(recentDays, curDate, showNum);
        if(CollectionUtils.isEmpty(tmRepeatList)){
            tmRepeatList = new ArrayList<>();
        }
        return EchartsConverter.converterFromNameValue(tmRepeatList, false).toJSONString();

    }

    /**
     * 各品牌商品交易统计
     * @param recentDays
     * @param curDate
     * @return
     */
    @Override
    public List<AdsTradeStatsByTm> getTmTradeStats(int recentDays, String curDate) {
        List<AdsTradeStatsByTm> tradeStatsByTmList = tradeStatsTmMapper.getTmTradeStats(recentDays,curDate);
        if(CollectionUtils.isNotEmpty(tradeStatsByTmList)){
            return tradeStatsByTmList;
        }
        return new ArrayList<AdsTradeStatsByTm>();
    }

    /**
     * 各品类商品交易统计
     *{
     * 	"children": [{
     * 		"children": [{
     * 			"name": "米面杂粮",
     * 			"value": 53
     *                }],
     * 		"name": "粮油调味",
     * 		"value": 53* 	}],
     * 	"name": "食品饮料、保健食品"
     * }
     * @param recentDays
     * @param curDate
     * @return
     */
    @Override
    public List<JSONObject> getCateTradeStats(int recentDays, String curDate){
        List<JSONObject> childrenList = new ArrayList<>();
        List<AdsTradeStatsByCate> category1List = tradeStatsCateMapper.getCategory1List(recentDays, curDate);
        if(CollectionUtils.isNotEmpty(category1List)){
            for(AdsTradeStatsByCate adsTradeStatsByCate : category1List){
               JSONObject children1 = new JSONObject();
               JSONArray children2Array = new JSONArray();
               children1.put("name",adsTradeStatsByCate.getCategory1_name());
               List<AdsTradeStatsByCate> category2List = tradeStatsCateMapper.getCategory2List(recentDays, curDate, adsTradeStatsByCate.getCategory1_id());
               for(AdsTradeStatsByCate categroy2 : category2List){
                    JSONObject children2 = new JSONObject();
                    children2.put("name",categroy2.getCategory2_name());
                    children2.put("value",categroy2.getOrderCountTotal());
                    List<NameValueData> category3List = tradeStatsCateMapper.getCategory3List(recentDays, curDate, adsTradeStatsByCate.getCategory1_id(), categroy2.getCategory2_id());
                    children2.put("children",category3List);
                    children2Array.add(children2);
                }
                children1.put("children",children2Array);
                childrenList.add(children1);
            }
        }
        return childrenList;
    }

    /**
     *查询各分类商品购物车存量中一级分类
     * @param curDate
     * @return
     */
    @Override
    public List<NameValueData> getCategory1( String curDate) {
        List<NameValueData> category1 = skuCartNumTop3.getCategory1(curDate);
        if(CollectionUtils.isNotEmpty(category1)){
            return category1;
        }
        return new ArrayList<>();
    }

    /**
     * 查询各分类商品购物车存量中二级分类
     * @param curDate
     * @param category1_id
     * @return
     */
    @Override
    public List<NameValueData> getCategory2(String curDate, String category1_id) {
        List<NameValueData> category2 = skuCartNumTop3.getCategory2(curDate, category1_id);
        if(CollectionUtils.isNotEmpty(category2)){
            return category2;
        }
        return new ArrayList<>();
    }


    /**
     * 查询各分类商品购物车存量中三级分类
     * @param curDate
     * @param category1_id
     * @param category2_id
     * @return
     */
    @Override
    public List<NameValueData> getCategory3(String curDate, String category1_id, String category2_id) {
        List<NameValueData> category3 = skuCartNumTop3.getCategory3(curDate, category1_id, category2_id);
        if(CollectionUtils.isNotEmpty(category3)){
            return category3;
        }
        return new ArrayList<>();
    }

    /**
     * 查询各分类商品购物车存量Top3
     * @param curDate
     * @param category1_id
     * @param category2_id
     * @param category3_id
     * @return
     */
    @Override
    public String getTmTopNData(String curDate, String category1_id, String category2_id, String category3_id) {
        List<NameValueData> tmTopNData = skuCartNumTop3.getTmTopNData(curDate, category1_id, category2_id, category3_id);
        if(CollectionUtils.isEmpty(tmTopNData)){
            tmTopNData = new ArrayList<>();
        }
        return EchartsConverter.converterFromNameValue(tmTopNData, false).toJSONString();
    }


}
