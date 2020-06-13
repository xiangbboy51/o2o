package com.atom.o2o.dao;

import com.atom.o2o.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: li xiang
 * Date: 2020/6/13 14:30
 */
public class AreaDaoTest extends BaseTest {
    @Autowired
    private AreaDao dao;

    @Test
    public void testQueryArea(){
        Assert.assertEquals(2,dao.queryArea().size());
    }

}
