package com.atguigu.yuntai.statistics.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @program: gmall
 * @description:最近30天发布的活动的补贴率实体类
 */
@Data
@NoArgsConstructor
public class AdsActivityStats {

    /**
     * 统计日期
     */
    private String dt;

    /**
     * 活动ID
     */
    private String activity_id;

    /**
     * 活动名称
     */
    private String activity_name;

    /**
     * 活动开始日期
     */
    private String start_date;

    /**
     * 补贴率
     */
    private BigDecimal reduce_rate;

}
