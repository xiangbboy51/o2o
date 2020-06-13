package com.atom.o2o.dao;

import com.atom.o2o.entity.Shop;
import org.springframework.stereotype.Repository;

/**
 * @Author: li xiang
 * Date: 2020/6/13 18:18
 */
@Repository
public interface ShopDao {
    /**
     * 新增店铺
     *
     * @param shop {@link Shop}
     * @return 1成功 -1 失败
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
