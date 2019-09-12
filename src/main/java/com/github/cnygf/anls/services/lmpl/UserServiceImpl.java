package com.github.cnygf.anls.services.lmpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.cnygf.anls.entity.User;
import com.github.cnygf.anls.mapper.UserMapper;
import com.github.cnygf.anls.services.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现
 *
 * @author YGF
 * @since 2019-09-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 根据用户名获取用户密码
     * @param userName 用户名
     * @return 密码
     */
    @Override
    public String getPasswordByUserName(String userName){
        User user = this.lambdaQuery().eq(User::getUsername,userName).one();
        if(user == null){
            return "";
        }
        return user.getPassword();
    }

}
