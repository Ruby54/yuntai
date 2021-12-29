package com.atguigu.yuntai.statistics.mapper;

import com.atguigu.yuntai.common.utils.NameValueData;
import com.atguigu.yuntai.statistics.bean.ProductStats;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品统计Mapper
 */
public interface ProductStatsMapper {

    //获取商品交易额
    @Select("select sum(order_amount) order_amount  " +
            "from product_stats_2021 where toYYYYMMDD(stt)=#{date}")
    public BigDecimal getGMV(int date);

    //统计某天不同SPU商品交易额排名
    @Select("select spu_id,spu_name,sum(order_amount) order_amount," +
            "sum(product_stats_2021.order_ct) order_ct from product_stats_2021 " +
            "where toYYYYMMDD(stt)=#{date} group by spu_id,spu_name " +
            "having order_amount>0 order by order_amount desc limit #{limit} ")
    public List<ProductStats> getProductStatsGroupBySpu(@Param("date") int date, @Param("limit") int limit);

    //统计某天不同类别商品交易额排名
    @Select("select category3_id,category3_name,sum(order_amount) order_amount " +
            "from product_stats_2021 " +
            "where toYYYYMMDD(stt)=#{date} group by category3_id,category3_name " +
            "having order_amount>0  order by  order_amount desc limit #{limit}")
    public List<ProductStats> getProductStatsGroupByCategory3(@Param("date")int date , @Param("limit") int limit);

    //统计某天不同品牌商品交易额排名
    @Select("select tm_name name,sum(order_amount) value " +
            "from product_stats_2021 " +
            "where toYYYYMMDD(stt)=#{date} group by tm_id,tm_name " +
            "having value>0  order by  value  desc limit #{limit} ")
    public List<NameValueData> getProductStatsByTrademark(@Param("date")int date, @Param("limit") int limit);


}
