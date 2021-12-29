package com.atguigu.yuntai.statistics.controller;

import com.atguigu.yuntai.statistics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: gmall
 * @description:用户主题
 * @author: Zhao Yi
 * @create: 2021-12-10 17:06
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    /**
     *用户行为分析
     * @param recentDays
     * @param curDate
     * @return
     */
    @RequestMapping(value ="getUserActionConvert",method = {RequestMethod.GET})
    @CrossOrigin
    public String getUserActionConvert(@RequestParam int recentDays, @RequestParam String curDate){
       return  userService.getUserActionConvert(recentDays,curDate);
    }

    /**
     *用户留存率
     * @param dt
     * @return
     */
    @RequestMapping("getUserRetention")
    @CrossOrigin
    public String  getUserRetention(@RequestParam("dt") String dt){
        return userService.getUseRetention(dt);
    }

    /**
     *用户新增活跃以及变动统计
     * @param dt
     * @param days
     * @return
     */
    @RequestMapping("getUserTotal")
    @CrossOrigin
    public String getUserTotal(@RequestParam("dt") String dt, @RequestParam("days") int days ) {
       String userTotal = userService.getUserTotal( dt,days);
        return userTotal;
    }
}
