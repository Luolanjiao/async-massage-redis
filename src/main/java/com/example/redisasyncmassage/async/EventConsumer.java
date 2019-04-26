package com.example.redisasyncmassage.async;

import com.alibaba.fastjson.JSONObject;
import com.example.redisasyncmassage.utils.JedisAdapter;
import com.example.redisasyncmassage.utils.RedisKeyUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lanjiao.luo
 * @date 2019/4/26 10:08
 **/
@Component
public class EventConsumer implements InitializingBean , ApplicationContextAware {

    @Autowired
    private JedisAdapter jedisAdapter;

    private ApplicationContext applicationContext;

    private Map<EventType,List<EventHandler>> mapTypeHandlers=new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, EventHandler> beans = applicationContext.getBeansOfType(EventHandler.class);

        if (beans != null) {
            //遍历所有eventhandler，找出每个handler支持的type。
            for (Map.Entry<String, EventHandler> entry: beans.entrySet()) {
                List<EventType> eventTypes = entry.getValue().getHandleEventTypes();
                //根据type和handler形成映射表，完成map。
                for (EventType type : eventTypes) {
                    if (!mapTypeHandlers.containsKey(type)) {
                        mapTypeHandlers.put(type, new ArrayList<EventHandler>());
                        mapTypeHandlers.get(type).add(entry.getValue());
                    }else {
                        mapTypeHandlers.get(type).add(entry.getValue());
                    }
                }
            }
        }

        //持续轮询（监听）消息队列
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    String key = RedisKeyUtil.getEventQueueKey();
                    List<String> events = jedisAdapter.brpop(0, key);
                    if(events==null){
                        continue;
                    }
                    for (String msg : events) {
                        //redis自带消息key要过滤掉
                        if (msg.equals(key)) {
                            continue;
                        }
                        Event event = JSONObject.parseObject(msg,Event.class);
                        if (!mapTypeHandlers.containsKey(event.getEventType())) {
                            System.out.println(event.getEventType()+"此事件无法识别");
                            continue;                        }
                        for (EventHandler eventHandler : mapTypeHandlers.get(event.getEventType())) {
                            eventHandler.doHandle(event);
                        }
                    }
                }
            }
        });
        thread.start();
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
