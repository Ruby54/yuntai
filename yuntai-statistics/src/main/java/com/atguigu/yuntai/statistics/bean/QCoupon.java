package com.atguigu.yuntai.statistics.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: gmall
 * @description:优惠券查询条件实体类
 */
@Data
@NoArgsConstructor
public class QCoupon {

    private String startDate;

    private String couponName;
}
