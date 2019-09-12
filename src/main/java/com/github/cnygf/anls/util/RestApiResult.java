package com.github.cnygf.anls.util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * API返回结果数据结构
 *
 * @author YGF
 * @since 2019-09-12
 */
@Data
public class RestApiResult  {
    /**
     * 调用结果代码
     */
    private int code;
    /**
     * 状态
     */
    private String status;
    /**
     * 返回消息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Map<String,String>data;

    /**
     * 设置返回对象的数据
     * @param key 键
     * @param values 值
     */
    public void setData(String key,String values){
        this.data.put(key,values);
    }

    /**
     * 创建API返回对象
     * @param code 状态码
     * @param msg 消息
     * @return 对象
     */
    public static RestApiResult create(int code,String status,String msg){
        RestApiResult r = new RestApiResult();
        r.setCode(code);
        r.setStatus(status);
        r.setMsg(msg);
        r.data = new HashMap<String,String>();
        return r;
    }
}
