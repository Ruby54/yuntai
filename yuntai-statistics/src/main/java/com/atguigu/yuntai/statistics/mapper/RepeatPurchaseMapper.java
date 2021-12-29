package com.atguigu.yuntai.statistics.mapper;

import com.atguigu.yuntai.common.utils.NameValueData;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: yuntai
 * @description: 品牌复购率
 */
public interface RepeatPurchaseMapper {
    @Select("  SELECT   tm_name name,order_repeat_rate value   " +
            "  FROM    ads_repeat_purchase_by_tm  " +
            "  WHERE    recent_days= #{recentDays}  and dt= #{curDate} limit #{showNum}"  )
    List<NameValueData> getTmRepeat(int recentDays, String curDate, int showNum);
}
