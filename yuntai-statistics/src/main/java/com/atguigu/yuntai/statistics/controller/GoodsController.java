package com.atguigu.yuntai.statistics.controller;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.yuntai.common.utils.NameValueData;
import com.atguigu.yuntai.statistics.bean.AdsTradeStatsByTm;
import com.atguigu.yuntai.statistics.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: gmall
 * @description:商品统计
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 最近7/30日各品牌复购率
     * @param recentDays
     * @param curDate
     * @param showNum
     * @return
     */
    @RequestMapping(value ="getTmRepeat",method = {RequestMethod.GET})
    @CrossOrigin
    public String getTmRepeat(@RequestParam int recentDays, @RequestParam String curDate, @RequestParam int showNum){
        return goodsService.getTmRepeat(recentDays,curDate,showNum);
    }


    /**
     *各品牌商品交易统计
     * @param recentDays
     * @param curDate
     * @return
     */
    @RequestMapping(value ="getTmTradeStats",method = {RequestMethod.GET})
    @CrossOrigin
    public List<AdsTradeStatsByTm> getTmTradeStats(@RequestParam int recentDays, @RequestParam String curDate){
        return goodsService.getTmTradeStats(recentDays,curDate);
    }

    /**
     * 各品类商品交易统计
     * @param recentDays
     * @param curDate
     * @return
     */
    @RequestMapping(value ="getCateTradeStats",method = {RequestMethod.GET})
    @CrossOrigin
    public List<JSONObject> getCateTradeStats(@RequestParam int recentDays, @RequestParam String curDate){
        return goodsService.getCateTradeStats(recentDays,curDate);
    }
    /**
     * 各分类商品购物车存量Top10:查询一级分类
     * @param curDate
     * @return
     */
    @RequestMapping(value ="getCategory1",method = {RequestMethod.GET})
    @CrossOrigin
    public List<NameValueData> getCategory1(@RequestParam String curDate){
        return goodsService.getCategory1(curDate);
    }

    /**
     * 各分类商品购物车存量Top10:查询二级分类
     * @param curDate
     * @param category1_id
     * @return
     */
    @RequestMapping(value ="getCategory2",method = {RequestMethod.GET})
    @CrossOrigin
    public List<NameValueData> getCategory2(@RequestParam String curDate, @RequestParam String category1_id){
        return goodsService.getCategory2(curDate,category1_id);
    }

    /**
     * 各分类商品购物车存量Top10:查询三级分类
     * @param curDate
     * @param category1_id
     * @param category2_id
     * @return
     */
    @RequestMapping(value ="getCategory3",method = {RequestMethod.GET})
    @CrossOrigin
    public List<NameValueData> getCategory3(@RequestParam String curDate, @RequestParam String category1_id, @RequestParam String category2_id){
        return goodsService.getCategory3(curDate,category1_id,category2_id);
    }

    @RequestMapping(value ="getTmTopNData",method = {RequestMethod.GET})
    @CrossOrigin
    public String getTmTopNData(@RequestParam String curDate, @RequestParam String category1_id, @RequestParam String category2_id, @RequestParam String category3_id){
        return goodsService.getTmTopNData(curDate,category1_id,category2_id,category3_id);
    }

}
