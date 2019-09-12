package com.github.cnygf.anls.entity;

        import lombok.Data;


@Data
public class Limits {
    private long id;                // 权限编号
    private String limitsName;      // 权限名称
    private String description;     // 描述信息
}
