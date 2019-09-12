package com.github.cnygf.anls.controller;

import com.github.cnygf.anls.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 * @author YGF
 * @since 2019-09-12
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @param vfcode 验证码
     * @return
     */
    @RequestMapping(value = "/api/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(String username,String password,String vfcode){
        System.out.println(username);
        return "Hello 安d络";
    }

}
