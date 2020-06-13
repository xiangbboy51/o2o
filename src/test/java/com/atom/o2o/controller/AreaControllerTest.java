package com.atom.o2o.controller;

import com.atom.o2o.BaseTest;
import com.atom.o2o.BaseWebTest;
import com.atom.o2o.web.superadmin.AreaController;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Map;

/**
 * @Author: li xiang
 * Date: 2020/6/13 16:16
 */
@WebAppConfiguration
public class AreaControllerTest extends BaseWebTest {
    @Autowired
    AreaController areaController;


    @Test
    public void testArealist() {
        Map<String, Object> map = areaController.areaList();
        Assert.assertEquals(map.size(), 2);
    }
}
