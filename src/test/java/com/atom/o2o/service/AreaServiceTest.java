package com.atom.o2o.service;

import com.atom.o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @Author: li xiang
 * Date: 2020/6/13 15:11
 */
public class AreaServiceTest extends BaseTest {
    @Autowired
    AreaService areaService;

    @Test
    public void tesQueryService(){
        Assert.isTrue(areaService.getAreaList().size()==2,"数量不匹配");

    }

}
