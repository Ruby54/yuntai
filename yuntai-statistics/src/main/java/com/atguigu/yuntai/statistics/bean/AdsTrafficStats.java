package com.atguigu.yuntai.statistics.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @program: gmall
 * @description: 各渠道流量统计实体类
 */
@Data
@NoArgsConstructor
public class AdsTrafficStats {
    /**
     * 统计日期
     */
    private String dt;

    /**
     * 最近天数,1:最近1天,7:最近7天,30:最近30天
     */
    private int recent_days;

    /**
     * 渠道
     */
    private String channel;

    /**
     * 访客人数
     */
    private int uv_count;

    /**
     * 会话平均停留时长，单位为秒
     */
    private int avg_duration_sec;


    /**
     * 会话平均浏览页面数
     */
    private int avg_page_count;

    /**
     * 会话数
     */
    private int sv_count;

    /**
     *跳出率
     */
    private BigDecimal bounce_rate;

}
