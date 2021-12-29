package com.atguigu.yuntai.statistics.service.impl;

import com.atguigu.yuntai.statistics.bean.AdsCouponStats;
import com.atguigu.yuntai.statistics.bean.QCoupon;
import com.atguigu.yuntai.statistics.mapper.CouponMapper;
import com.atguigu.yuntai.statistics.service.CouponService;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: gmall
 * @description:优惠券统计实现类
 */
@DS("mysql")
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponMapper couponMapper;


    /**
     * 根据开始时间查询优惠卷名称
     * @param qCoupon
     * @return
     */
    @Override
    public List<String> getCouponNameByStartDate(QCoupon qCoupon) {
        List<String> nameList = new ArrayList<String>();
        if(StringUtils.isNotEmpty(qCoupon.getStartDate())){
            nameList = couponMapper.getCouponNameByStartDate(qCoupon.getStartDate());
        }
        return nameList;
    }

    /**
     * 根据开始时间和优惠券名称查询优惠券统计
     * @param qCoupon
     * @return
     */
    @Override
    public List<AdsCouponStats> getCouponList(QCoupon qCoupon) {

        List<AdsCouponStats> activityList = new ArrayList<>();
        if(qCoupon!=null){
            activityList = couponMapper.getCouponList(qCoupon);
        }
        return activityList;
    }
}
