package com.atom.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: li xiang
 * Date: 2020/6/13 0:33
 * 商品详情图
 */
@Data
public class ProductImg {
    private Long productImgId;
    private String imgDesc;
    private String imgUrl;
    private Integer priority;
    private Date createTime;
    private Long productId;
}
