package com.atguigu.yuntai.statistics.mapper;

import com.atguigu.yuntai.statistics.bean.AdsTradeStatsByTm;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: yuntai
 * @description: 品牌商品交易
 */
public interface TradeStatsTmMapper {
    @Select("  SELECT   *   " +
            "  FROM    ads_trade_stats_by_tm  " +
            "  WHERE    recent_days= #{recentDays}  and dt= #{curDate}"  )
    List<AdsTradeStatsByTm> getTmTradeStats(int recentDays, String curDate);
}
