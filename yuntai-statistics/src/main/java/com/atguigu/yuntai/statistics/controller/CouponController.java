package com.atguigu.yuntai.statistics.controller;


import com.atguigu.yuntai.statistics.bean.AdsCouponStats;
import com.atguigu.yuntai.statistics.bean.QCoupon;
import com.atguigu.yuntai.statistics.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: gmall
 * @description:最近30天发布的优惠券的补贴率
 */
@RestController
public class CouponController {

    @Autowired
    private CouponService couponService;

    /**
     * 根据开始时间查询优惠券名称
     * @param qCoupon
     * @return
     */
    @RequestMapping(value ="getCouponNameByStartDate",method = {RequestMethod.POST})
    @CrossOrigin
    public List<String> getCouponNameByStartDate(@RequestBody QCoupon qCoupon) {
        List<String> couponNameList = couponService.getCouponNameByStartDate(qCoupon);
        return couponNameList;
    }

    /**
     * 根据开始时间和优惠券名称查询优惠券统计
     * @param qCoupon
     * @return
     */
    @RequestMapping(value ="getCouponList",method = {RequestMethod.POST})
    @ResponseBody
    @CrossOrigin
    public List<AdsCouponStats> getCouponList(@RequestBody QCoupon qCoupon){
        return couponService.getCouponList(qCoupon);
    }

}
