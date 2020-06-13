package com.atom.o2o.service;

import com.atom.o2o.dto.ShopExecution;
import com.atom.o2o.entity.Shop;

import java.io.File;

/**
 * @Author: li xiang
 * Date: 2020/6/14 1:05
 */
public interface ShopService {
    /**
     * 新增店铺
     *
     * @param shopImg 商铺图片
     * @param shop
     * @return
     */
    ShopExecution addShop(Shop shop, File shopImg);

}
