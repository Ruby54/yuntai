package com.atguigu.yuntai.statistics.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @program: gmall
 * @description:
 */
public interface UserStatsMapper {

    @Select(" SELECT  new_user_count  userTotal,  active_user_count  activeUserTotal   FROM ads_user_stats  WHERE  recent_days=#{days} AND dt= #{date}  " )
    Map getUserStats(@Param("date") String dt, @Param("days") int days);
}
