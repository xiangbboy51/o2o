package com.atom.o2o.dao;

import com.atom.o2o.entity.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: li xiang
 * Date: 2020/6/13 3:14
 */
@Repository
public interface AreaDao {
    List<Area> queryArea();
}
