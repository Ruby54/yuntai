package com.atguigu.yuntai.statistics.bean;

import com.atguigu.yuntai.common.utils.Query;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: yuntai
 * @description:统一查询条件
 * @author: Zhao Yi
 * @create: 2021-12-15 11:13
 */
@Data
@NoArgsConstructor
public class QUnified implements Query {

    /**
     * 查询时间
     */
    private String curDate;

    /**
     * 查询天数
     */
    private int recentDays;

}
