package com.atguigu.yuntai.statistics.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @program: gmall
 * @description:各地区订单统计实体类
 * @author: Zhao Yi
 * @create: 2021-12-07 17:20
 */
@Data
@NoArgsConstructor
public class AdsOrderByProvince {

    /**
     *统计日期
     */
    private String dt;

    /**
     *最近天数,1:最近1天,7:最近7天,30:最近30天
     */
    private int recent_days;

    /**
     *省份ID
     */
    private String province_id;

    /**
     *省份名称
     */
    private String province_name;

    /**
     *地区编码
     */
    private String area_code;

    /**
     *国际标准地区编码
     */
    private String iso_code;

    /**
     *国际标准地区编码
     */
    private String iso_code_3166_2;

    /**
     *订单数
     */
    private int order_count;

    /**
     *订单金额
     */
    private BigDecimal order_total_amount;

}
