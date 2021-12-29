package com.atguigu.yuntai.statistics.service;

import com.atguigu.yuntai.statistics.bean.ProductStats;
import com.atguigu.yuntai.statistics.bean.ProvinceStats;
import com.atguigu.yuntai.statistics.bean.ReturnVisitorStats;
import com.atguigu.yuntai.statistics.bean.VisitorStats;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface RealTimeService {

    public BigDecimal getGMV(int date);

    public List<ProductStats> getProductStatsGroupBySpu(int date, int limit);

    public String getProductStatsGroupByCategory3(int date,int limit);

    public String getProductStatsByTrademark(int date,int limit);

    public List<Map> getProvinceStats(int date);

    List<ReturnVisitorStats> getVisitorStatsByNewFlag(int date);

    public String getVisitorStatsByHour(int date);

    public Long getPv(int date);

    public Long getUv(int date);


}
