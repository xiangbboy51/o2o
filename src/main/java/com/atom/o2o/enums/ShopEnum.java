package com.atom.o2o.enums;

import lombok.Getter;

/**
 * @Author: li xiang
 * Date: 2020/6/14 0:50
 */
@Getter
public enum ShopEnum {
    CHECK(0, "审核中"),
    OFFLINE(-1, "非法店铺"),
    SUCCESS(1, "操作成功"),
    PASS(2, "通过认证"),
    INNER_ERROR(1001, "内部错误"),
    SHOP_ID_NULL(1002, "商铺id为空"),
    NULL_SHOP(1003,"shop信息为空");
    private Integer state;
    private String msg;

    ShopEnum(Integer state, String msg) {
        this.state = state;
        this.msg = msg;
    }


    public static ShopEnum getShopEnum(Integer state) {
        for (ShopEnum shopEnum : values()) {
            if (state == shopEnum.getState()) {
                return shopEnum;
            }
        }
        return null;
    }

}
