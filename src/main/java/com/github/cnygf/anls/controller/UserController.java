package com.github.cnygf.anls.controller;

import com.github.cnygf.anls.entity.Role;
import com.github.cnygf.anls.entity.User;
import com.github.cnygf.anls.services.RoleService;
import com.github.cnygf.anls.services.UserService;
import com.github.cnygf.anls.util.RestApiResult;
import com.github.cnygf.anls.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 角色业务
     */
    @Autowired
    private RoleService roleService;

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
        // 获取用户实体
        User user = userService.getByUserName(username);
        // 判断用户提交的密码是否正常
        if(!user.getPassword().equals(password)){
            return RestApiResult.create(10000,"failed","用户名或密码错误");
        }
        RestApiResult result = RestApiResult.create(10000,"ok","登录成功");
        String token = TokenUtil.sign(user);
        Map<String,String> data = new HashMap<>();
        data.put("access_token",token);
        result.setData(data);
        return result;
    }

    /**
     * 获取角色列表
     * @return
     */
    @RequestMapping(value = "/api/roleList",method = RequestMethod.GET)
    @ResponseBody
    public RestApiResult roleList(@RequestHeader("Authorization") String authHeader){
        System.out.println(authHeader);
        RestApiResult result = RestApiResult.create(10000,"ok","获取成功");
        List<Role> list = roleService.getRoleList();
        result.setData(list);
        result.setCount(list.size());
        return result;
    }

}
