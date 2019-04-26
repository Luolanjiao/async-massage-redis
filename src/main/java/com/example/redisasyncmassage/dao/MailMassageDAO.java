package com.example.redisasyncmassage.dao;

import com.example.redisasyncmassage.entity.MailMassage;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author lanjiao.luo
 * @date 2019/4/26 11:39
 **/
@Mapper
public interface MailMassageDAO {
   long saveMailMassage(MailMassage mailMassage);
   MailMassage getMailMassage(int mailMsgId);
}
