package com.atguigu.yuntai.statistics.mapper;

import com.atguigu.yuntai.common.utils.NameValueData;
import com.atguigu.yuntai.statistics.bean.AdsTradeStatsByCate;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: yuntai
 * @description: 品类商品交易
 */
public interface TradeStatsCateMapper {
    @Select("  SELECT   *   " +
            "  FROM    ads_trade_stats_by_cate  " +
            "  WHERE    recent_days= #{recentDays}  and dt= #{curDate} group by category1_id"  )
    List<AdsTradeStatsByCate> getCategory1List(int recentDays, String curDate);


    @Select("  SELECT   category2_id,category2_name,sum(order_count) orderCountTotal   " +
            "  FROM    ads_trade_stats_by_cate  " +
            "  WHERE    recent_days= #{recentDays}  and dt= #{curDate} and category1_id =#{category1_id} group by category2_id"  )
    List<AdsTradeStatsByCate> getCategory2List(int recentDays, String curDate, String category1_id);

    @Select("  SELECT   category3_name name,order_count value" +
            "  FROM    ads_trade_stats_by_cate  " +
            "  WHERE    recent_days= #{recentDays}  and dt= #{curDate} " +
            "and category1_id =#{category1_id} and category2_id=#{category2_id}"  )
    List<NameValueData> getCategory3List(int recentDays, String curDate, String category1_id, String category2_id);
}
