package com.atom.o2o.service.impl;

import com.atom.o2o.dto.ShopExecution;
import com.atom.o2o.entity.Shop;
import com.atom.o2o.enums.ShopEnum;
import com.atom.o2o.service.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

/**
 * @Author: li xiang
 * Date: 2020/6/14 1:08
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Transactional
    @Override
    public ShopExecution addShop(Shop shop, File shopImg) {
        if (shopImg == null) {
            return new ShopExecution(ShopEnum.NULL_SHOP);
        }




        return null;
    }
}
