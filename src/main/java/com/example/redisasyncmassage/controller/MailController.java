package com.example.redisasyncmassage.controller;

import com.example.redisasyncmassage.async.Event;
import com.example.redisasyncmassage.async.EventType;
import com.example.redisasyncmassage.async.SendMailEventProducer;
import com.example.redisasyncmassage.entity.MailMessage;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author lanjiao.luo
 * @date 2019/4/26 14:50
 **/
@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private SendMailEventProducer sendMailEventProducer;

    @RequestMapping("/send")
    public String sendMail() {
        String currentUserId = "1";
        String sendToUserId = "2";
        MailMessage mailMassage=new MailMessage(1, "974292612@qq.com", "hello,my friends", Integer.parseInt(currentUserId), new Date()
        );
        sendMailEventProducer.fireEvent(new Event()
                .setActorId(currentUserId)
                .setRecieverId(sendToUserId)
                .setEventType(EventType.SEND_MAIL)
                .setEventObj(mailMassage));
        return "ok";
    }
}
