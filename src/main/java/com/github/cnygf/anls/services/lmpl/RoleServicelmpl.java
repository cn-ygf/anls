package com.github.cnygf.anls.services.lmpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.cnygf.anls.entity.Role;
import com.github.cnygf.anls.mapper.RoleMapper;
import com.github.cnygf.anls.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色业务实验
 *
 * @author YGF
 * @since 2019-09-18
 */
@Service
public class RoleServicelmpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    /**
     * 获取所有角色
     * @return 角色列表
     */
    @Override
    public List<Role> getRoleList() {
        return this.list();
    }
}
