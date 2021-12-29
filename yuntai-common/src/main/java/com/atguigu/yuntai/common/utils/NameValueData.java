package com.atguigu.yuntai.common.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 返回值
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NameValueData {
    String name;
    BigDecimal value;
}
