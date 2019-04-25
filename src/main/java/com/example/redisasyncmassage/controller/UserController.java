package com.example.redisasyncmassage.controller;

import com.example.redisasyncmassage.dao.UserDAO;
import com.example.redisasyncmassage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lanjiao.luo
 * @date 2019/4/25 15:06
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDAO userDAO;
    @RequestMapping("/get")
    public List<User> getUsers(){
      return  userDAO.getUsers();
    }
}
