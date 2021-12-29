package com.atguigu.yuntai.common.utils;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Echart坐标图表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EchartData {

    JSON xData;
    JSON yData;
    public String toString(){
        return JSON.toJSONString(this);
    }
}
