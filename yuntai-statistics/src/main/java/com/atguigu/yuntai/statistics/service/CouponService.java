package com.atguigu.yuntai.statistics.service;

import com.atguigu.yuntai.statistics.bean.AdsCouponStats;
import com.atguigu.yuntai.statistics.bean.QCoupon;

import java.util.List;

/**
 * @program: gmall
 * @description:
 */
public interface CouponService {

    List<String> getCouponNameByStartDate(QCoupon qCoupon);

    List<AdsCouponStats> getCouponList(QCoupon qCoupon);
}
