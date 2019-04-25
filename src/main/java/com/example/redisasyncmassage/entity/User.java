package com.example.redisasyncmassage.entity;

import java.util.Date;

/**
 * @author lanjiao.luo
 * @date 2019/4/25 14:49
 **/
public class User {
 private int id;
 private String name;
 private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Date createTime;
}
