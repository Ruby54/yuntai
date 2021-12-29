package com.atguigu.yuntai.statistics.mapper;

import com.atguigu.yuntai.common.utils.NameValueData;
import com.atguigu.yuntai.statistics.bean.AdsTradeStatsByCate;
import com.atguigu.yuntai.statistics.bean.AdsTradeStatsByTm;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: gmall
 * @description:各品类商品购物车存量
 */
public interface SkuCartNumTop3 {

    @Select("  SELECT   category1_id lable, category1_name name" +
            "  FROM    ads_sku_cart_num_top3_by_cate  " +
            "  WHERE   dt= #{curDate} group by category1_id" )
    List<NameValueData> getCategory1(String curDate);


    @Select("  SELECT   category2_id lable, category2_name name" +
            "  FROM    ads_sku_cart_num_top3_by_cate  " +
            "  WHERE   dt= #{curDate} and category1_id = #{category1_id} group by category2_id" )
    List<NameValueData> getCategory2(String curDate, String category1_id);

    @Select("  SELECT   category3_id lable, category3_name name" +
            "  FROM    ads_sku_cart_num_top3_by_cate  " +
            "  WHERE   dt= #{curDate} and category1_id = #{category1_id} and category2_id=#{category2_id}" +
            " group by category3_id" )
    List<NameValueData> getCategory3(String curDate, String category1_id, String category2_id);

    @Select("  SELECT   sku_name name, cart_num value" +
            "  FROM    ads_sku_cart_num_top3_by_cate  " +
            "  WHERE   dt= #{curDate} and category1_id = #{category1_id} and category2_id=#{category2_id} " +
            "and category3_id=#{category3_id} order by rk asc" )
    List<NameValueData>  getTmTopNData(String curDate, String category1_id, String category2_id, String category3_id);
}
