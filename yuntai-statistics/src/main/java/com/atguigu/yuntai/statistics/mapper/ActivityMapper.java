package com.atguigu.yuntai.statistics.mapper;

import com.atguigu.yuntai.statistics.bean.AdsActivityStats;
import com.atguigu.yuntai.statistics.bean.QActivity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: gmall
 * @description:
 */
public interface ActivityMapper {

    /**
     *根据开始时间查询所有活动
     */
    @Select("  SELECT  activity_name from ads_activity_stats where start_date=#{startDate} group by activity_id"  )
    List<String> getActivityNameByStartDate(@Param("startDate") String startDate);

    /**
     *根据开始时间和活动名称查询指标
     */
    @Select("  SELECT  * from ads_activity_stats where start_date=#{startDate} and activity_name=#{activityName}"  )
    List<AdsActivityStats> getActivityList(QActivity qActivity);
}
