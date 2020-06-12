package com.atom.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: li xiang
 * Date: 2020/6/12 21:51
 */
@Data
public class LocalAuth {
    private Integer localAuthId;
    private String userName;
    private String password;
    private Date createTime;
    private Date lastEditTime;
    private PersonInfo personInfo;

}
