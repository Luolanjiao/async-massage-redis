package com.example.redisasyncmassage.async;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lanjiao.luo
 * @date 2019/4/26 9:48
 **/
@Component
public class Event {
    //事件触发者
    private String actorId;
    //事件接受者
    private String recieverId;
    //事件类型
    private EventType eventType;

    public Object getEventObj() {
        return eventObj;
    }

    public Event setEventObj(Object eventObj) {
        this.eventObj = eventObj;
        return this;
    }

    //触发对象
    private Object eventObj;

    private Map<String, String> mapMsg = new HashMap<>();

    public String getActorId() {
        return actorId;
    }

    public Event setActorId(String actorId) {
        this.actorId = actorId;
        return this;
    }

    public String getRecieverId() {
        return recieverId;
    }

    public Event setRecieverId(String recieverId) {
        this.recieverId = recieverId;
        return this;
    }

    public EventType getEventType() {
        return eventType;
    }

    public Event setEventType(EventType eventType) {
        this.eventType = eventType;
        return this;
    }

    public Map<String, String> getMapMsg() {
        return mapMsg;
    }

    public Event setMapMsg(Map<String, String> mapMsg) {
        this.mapMsg = mapMsg;
        return this;
    }

    /***
     * 返回this,实现set链路操作  如：setMsg().setMsg()
     * @param key
     * @param value
     * @return
     */
    public Event setMsg(String key, String value) {
        this.mapMsg.put(key, value);
        return this;
    }
}
