package com.atguigu.yuntai.statistics.service;

/**
 * @program: gmall
 * @description:
 */
public interface UserService {

    String getUserActionConvert(int recentDays, String curDate);

    String getUseRetention(String dt);

    String getUserTotal(String dt, int days);

}
