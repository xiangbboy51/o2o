package com.atom.o2o.dto;

import com.atom.o2o.entity.Shop;
import com.atom.o2o.enums.ShopEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author : li xiang
 * Date: 2020/6/14 0:46
 */
@Getter
@Setter
public class ShopExecution {
    private Integer state;
    private String msg;
    //商家店铺数量
    private Integer count;
    private Shop shop;
    private List<Shop> shopList;

    //操作商铺失败时候的构造器
    public ShopExecution(ShopEnum shopEnum) {
        this.state = shopEnum.getState();
        this.msg = shopEnum.getMsg();
    }

    //操作商铺失败时候的构造器
    public ShopExecution(ShopEnum shopEnum, Shop shop) {
        this.state = shopEnum.getState();
        this.msg = shopEnum.getMsg();
        this.shop = shop;
    }


    //操作商铺失败时候的构造器
    public ShopExecution(ShopEnum shopEnum, List<Shop> shopList) {
        this.state = shopEnum.getState();
        this.msg = shopEnum.getMsg();
        this.shopList = shopList;
    }

}
