package com.github.cnygf.anls.services;


import com.baomidou.mybatisplus.extension.service.IService;
import com.github.cnygf.anls.entity.Role;

import java.util.List;

/**
 * 角色接口
 *
 * @author YGF
 * @since 2019-09-18
 */
public interface RoleService extends IService<Role> {

    /**
     * 获取角色
     * @return 角色列表
     */
    List<Role> getRoleList();

}
