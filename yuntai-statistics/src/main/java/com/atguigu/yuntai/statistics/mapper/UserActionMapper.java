package com.atguigu.yuntai.statistics.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @program: gmall
 * @description:
 */
public interface UserActionMapper {

    @Select(" select   home_count,  good_detail_count , cart_count, order_count,  payment_count " +
            " from   ads_user_action " +
            "  WHERE        dt =#{dt} and recent_days= #{days}   ")
    Map<String, Long> getUserAction(@Param("days") int days, @Param("dt") String dt);


}
