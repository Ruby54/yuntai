package com.atguigu.yuntai.statistics.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Desc: 访客流量统计返回值实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnVisitorStats {

    private String type;

    private Long newCount;

    private Long oldCount;
}
