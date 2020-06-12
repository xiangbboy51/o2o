package com.atom.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: li xiang
 * Date: 2020/6/12 22:28
 */
@Data
public class HeadLine {
    private Long lineId;
    private String lineName;
    private String lineImg;
    private String lineLink;
    private Integer priority;
    private Integer enableStatus;
    private Date createTime;
    private Date lastEditTime;
}
