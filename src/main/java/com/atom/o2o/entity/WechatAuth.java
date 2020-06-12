package com.atom.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: li xiang
 * Date: 2020/6/12 21:48
 */
@SuppressWarnings("ALL")
@Data
public class WechatAuth {
    private Integer wechatAuthId;
    private String openId;
    private Date createTime;
    private PersonInfo personInfo;
}
