package com.example.redisasyncmassage.dao;

import com.example.redisasyncmassage.entity.MailMessage;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author lanjiao.luo
 * @date 2019/4/26 11:39
 **/
@Mapper
public interface MailMessageDAO {
   long saveMailMessage(MailMessage mailMassage);
   MailMessage getMailMessage(int mailMsgId);
}
