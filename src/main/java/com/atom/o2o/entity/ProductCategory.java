package com.atom.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: li xiang
 * Date: 2020/6/13 0:14
 */
@Data
public class ProductCategory {
    private Long productCategoryId;
    private Long shopId;
    private String productCategoryName;
    private Integer priority;
    private Date createTime;
}
