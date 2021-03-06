package com.atom.o2o.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: li xiang
 * Date: 2020/6/12 23:42
 */
@Data
@Builder
public class Shop {
    private Long shopId;
    private String shopName;
    private String shopDesc;
    private String shopAddr;
    private String phone;
    private String shopImg;
    private Date createTime;
    private Date lastEditTime;
    private Integer priority;
    private Integer enableStatus;
    private String advice;
    private Area area;
    private PersonInfo owner;
    private ShopCategory shopCategory;
}
