package com.example.redisasyncmassage.async;

import java.util.List;

/**
 * @author lanjiao.luo
 * @date 2019/4/26 10:07
 **/
public interface EventHandler {

    /***
     * 处理事件的方法
     * @param event
     */
   void doHandle(Event event);

    /***
     * 获取所能处理的事件类型
     * @return
     */
   List<EventType> getHandleEventTypes();
}
