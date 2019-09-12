package com.github.cnygf.anls.services.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.cnygf.anls.entity.User;
import com.github.cnygf.anls.mapper.UserMapper;
import com.github.cnygf.anls.services.UserService;

/**
 * 用户业务实现
 *
 * @author YGF
 * @since 2019-09-12
 */
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    public String getPasswordByUserName(String userName){
        
        return "";
    }
}
