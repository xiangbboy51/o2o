package com.atom.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: li xiang
 * Date: 2020/6/12 20:36
 */
@Data
public class Area {
    private Integer areaId;
    private String areaName;
    /**
     * 优先级
     */
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;


}
