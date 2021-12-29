package com.atguigu.yuntai.statistics.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: gmall
 * @description:交易统计实体类
 */
@Data
@NoArgsConstructor
public class AdsTradeStats {


    /**
     * 统计日期
     */
    private String dt;

    /**
     * 最近天数,1:最近1日,7:最近7天,30:最近30天
     */
    private int recent_days;
    /**
     * 订单总额,GMV
     */
    private String order_total_amount;

    /**
     * 订单数
     */
    private int order_count;

    /**
     * 下单人数
     */
    private int order_user_count;

    /**
     *退单数
     */
    private int order_refund_count;

    /**
     *退单人数
     */
    private int order_refund_user_count;
}
