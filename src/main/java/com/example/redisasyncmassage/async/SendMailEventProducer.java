package com.example.redisasyncmassage.async;

import com.alibaba.fastjson.JSONObject;
import com.example.redisasyncmassage.utils.JedisAdapter;
import com.example.redisasyncmassage.utils.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author lanjiao.luo
 * @date 2019/4/26 10:07
 **/
@Service
public class SendMailEventProducer {
    @Autowired
    private JedisAdapter jedisAdapter;

    public void fireEvent(Event event) {
        //将事件保存在redis中
        String key = RedisKeyUtil.getEventQueueKey();
        String eventStr = JSONObject.toJSONString(event);
        jedisAdapter.lpush(key, eventStr);
        System.out.println("生产者线程："+Thread.currentThread().getId());
    }
}
