package com.example.redisasyncmassage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author lanjiao.luo
 * @date 2019/5/5 14:25
 **/
@RestController
@RequestMapping("status/")
public class StatusController {
    @RequestMapping("ps")
    public String getPsStatus(long pid){
        ThreadMXBean tmx = ManagementFactory.getThreadMXBean();
        ThreadInfo info = tmx.getThreadInfo(pid);
       return "线程状态为："+ info.getThreadState()+"阻塞时间："
               +info.getBlockedTime()+"等待时间："+info.getWaitedTime()
               ;
    }
}
