package com.example.redisasyncmassage.async;

/**
 * @author lanjiao.luo
 * @date 2019/4/26 10:06
 **/
public enum EventType {
    SEND_MAIL(0);
    private int value;

    EventType(int value) {
        this.value = value;
    }
}
