package com.github.cnygf.anls.controller;

import com.github.cnygf.anls.services.UserService;
import com.github.cnygf.anls.util.RestApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;

/**
 * 用户控制器
 * @author YGF
 * @since 2019-09-12
 */
@RestController
public class UserController {

    /**
     * 用户业务
     */
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "/api/login",method = RequestMethod.POST)
    @ResponseBody
    public RestApiResult login(
            @Size(min = 2,max = 32) String username,
            @Size(min = 4,max = 32) String password){
        // 计算md5
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        // 查询用户密码对应的密码
        String databsePassword = userService.getPasswordByUserName(username);
        // 判断用户提交的密码是否正常
        if(!databsePassword.equals(password)){
            return RestApiResult.create(10000,"failed","用户名或密码错误");
        }
        RestApiResult result = RestApiResult.create(10000,"ok","登录成功");
        result.setData("access_token","c262e61cd13ad99fc650e6908c7e5e65b63d2f32185ecfed6b801ee3fbdd5c0a");
        return result;
    }

}
