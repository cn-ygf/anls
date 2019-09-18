package com.github.cnygf.anls.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 角色实体
 *
 * @author YGF
 * @since 2019-09-18
 */
@Data
@TableName("al_role")
public class Role {
    /**
     * 角色编号
     */
    private long id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String description;
}
