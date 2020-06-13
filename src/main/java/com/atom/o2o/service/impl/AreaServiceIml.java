package com.atom.o2o.service.impl;

import com.atom.o2o.dao.AreaDao;
import com.atom.o2o.entity.Area;
import com.atom.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: li xiang
 * Date: 2020/6/13 15:07
 */
@Service
public class AreaServiceIml implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
