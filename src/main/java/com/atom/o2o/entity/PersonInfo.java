package com.atom.o2o.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @Author: li xiang
 * Date: 2020/6/12 21:14
 */
@Data
@Builder
public class PersonInfo {
    private Long userId;
    private String name;
    private String profileImg; //用户图像
    private String email;
    private String gender; //性别
    private Integer status;
    private Integer userType; // 1 顾客 2店家 3 管理员
    private Date createTime;
    private Date lastEditTime;


}
