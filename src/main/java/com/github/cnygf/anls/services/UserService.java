package com.github.cnygf.anls.services;


import com.baomidou.mybatisplus.extension.service.IService;
import com.github.cnygf.anls.entity.User;

/**
 * 用户业接口
 *
 * @author YGF
 * @since 2019-09-12
 */
public interface UserService extends IService<User> {

    /**
     * 根据用户名获取密码
     * @param userName 用户名
     * @return 密码
     */
    String getPasswordByUserName(String userName);
}
