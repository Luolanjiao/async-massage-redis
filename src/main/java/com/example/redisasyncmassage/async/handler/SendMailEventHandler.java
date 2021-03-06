package com.example.redisasyncmassage.async.handler;

import com.alibaba.fastjson.JSON;
import com.example.redisasyncmassage.async.Event;
import com.example.redisasyncmassage.async.EventHandler;
import com.example.redisasyncmassage.async.EventType;
import com.example.redisasyncmassage.dao.MailMessageDAO;
import com.example.redisasyncmassage.entity.MailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author lanjiao.luo
 * @date 2019/4/26 11:02
 **/
@Component
public class SendMailEventHandler implements EventHandler {
    @Autowired
    private MailMessageDAO mailMassageDAO;

    /***
     * 保存消息并发送
     * @param event
     */
    @Override
    public void doHandle(Event event) {
        MailMessage mailMassage = JSON.parseObject(JSON.toJSONString(event.getEventObj()), MailMessage.class);
        mailMassageDAO.saveMailMessage(mailMassage);
        System.out.println("发送短信=====" + mailMassageDAO.getMailMessage(1));
    }

    @Override
    public List<EventType> getHandleEventTypes() {
        return Arrays.asList(EventType.SEND_MAIL);
    }
}
