package com.github.cnygf.anls.controller;

import com.github.cnygf.anls.mapper.UserMapper;
import com.github.cnygf.anls.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/api/hello",method = RequestMethod.GET)
    public String hello(){
        return "Hello 安d络";
    }

    @RequestMapping(value = "/api/hello2",method = RequestMethod.GET)
    public List<User> hello2(){
        List<User> userList = userMapper.selectList(null);
        return userList;
    }
}
