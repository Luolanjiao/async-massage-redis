package com.example.redisasyncmassage.entity;

import java.util.Date;

/**
 * @author lanjiao.luo
 * @date 2019/4/26 11:34
 **/
public class MailMessage{
    public int getId() {
        return id;
    }

    public MailMessage(){}

    public MailMessage(int id, String mail, String massage, int createUserId, Date createTime) {
        this.id = id;
        this.mail = mail;
        this.massage = massage;
        this.createUserId = createUserId;
        this.createTime = createTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public int getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(int createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private int id;
 private String mail;
 private String massage;
 private int createUserId;
 private Date createTime;
}
