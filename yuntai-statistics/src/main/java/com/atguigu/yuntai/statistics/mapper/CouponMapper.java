package com.atguigu.yuntai.statistics.mapper;

import com.atguigu.yuntai.statistics.bean.AdsCouponStats;
import com.atguigu.yuntai.statistics.bean.QCoupon;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: gmall
 * @description:
 */

public interface CouponMapper {

    @Select("  SELECT  coupon_name from ads_coupon_stats where start_date=#{startDate} group by coupon_id"  )
    List<String> getCouponNameByStartDate(@Param("startDate") String startDate);

    @Select("  SELECT  * from ads_coupon_stats where start_date=#{startDate} and coupon_name=#{couponName}"  )
    List<AdsCouponStats> getCouponList(QCoupon qCoupon);
}
