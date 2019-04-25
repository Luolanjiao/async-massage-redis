package com.example.redisasyncmassage.dao;

import com.example.redisasyncmassage.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lanjiao.luo
 * @date 2019/4/25 14:47
 **/
@Mapper
@Component
public interface UserDAO {
   List<User> getUsers();
}
