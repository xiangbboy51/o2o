package com.atom.o2o.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: li xiang
 * Date: 2020/6/13 0:46
 */
@Data
public class Product {
    private Long productId;
    private String productName;
    private String productDesc;
    private String productThumb;
    private BigDecimal productPrice;
    private BigDecimal discountPrice;
    private Integer priority;
    private Integer enableStatus;
    private Date createTime;
    private Date lastEditTime;
    private List<ProductImg> productImgList;
    private ProductCategory productCategory;
    private Shop shop;


}
