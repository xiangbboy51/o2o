package com.atom.o2o.dao;

import com.atom.o2o.BaseTest;
import com.atom.o2o.entity.Area;
import com.atom.o2o.entity.PersonInfo;
import com.atom.o2o.entity.Shop;
import com.atom.o2o.entity.ShopCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Author: li xiang
 * Date: 2020/6/13 18:57
 */
public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao dao;

    @Test
    public void testInsertShop() {
        Shop shop = Shop.builder()
                .shopDesc("新开的店")
                .shopName("电脑i9")
                .shopAddr("北京四巷口")
                .advice("不知道")
                .phone("110")
                .priority(1)
                .shopImg("http://www.jd.com")
                .area(Area.builder().areaId(1).build())
                .createTime(new Date())
                .shopCategory(ShopCategory.builder().shopCategoryId(1L).build())
                .enableStatus(1)
                .lastEditTime(new Date())
                .owner(PersonInfo.builder().userId(1L).build())
                .build();
        int i = dao.insertShop(shop);
        Assert.assertEquals(1, i);
    }


    @Test
    public void testUpdateShop() {
        Shop shop = Shop.builder()
                .shopDesc("新开的店")
                .shopId(1L)
                .advice("审核中")
                .shopAddr("天空之城旧址")
                .build();
        int i = dao.updateShop(shop);
        Assert.assertEquals(1, i);
    }
}
