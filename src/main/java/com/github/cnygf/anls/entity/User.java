package com.github.cnygf.anls.entity;

import lombok.Data;


/**
 * 用户实体
 *
 * @author YGF
 * @since 2019-09-12
 */
@Data
public class User {
    /**
     * 用户编号
     */
    private long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String passWord;
    /**
     * 姓名
     */
    private String fullname;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 角色编号
     */
    private long roleId;
    /**
     * 是否启用
     */
    private int enable;
}