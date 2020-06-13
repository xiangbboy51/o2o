package com.atom.o2o.web.superadmin;

import com.atom.o2o.dao.AreaDao;
import com.atom.o2o.entity.Area;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: li xiang
 * Date: 2020/6/13 3:22
 */

@Controller
@RequestMapping("/superadmin")
public class AreaController {
    Logger logger = LoggerFactory.getLogger(AreaController.class);
    final AreaDao areaDao;
    public AreaController(AreaDao areaDao) {
        this.areaDao = areaDao;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/arealist")
    @ResponseBody
    public Map<String, Object> areaList() {
        Map<String, Object> map = new HashMap<>();
        logger.debug("输出debug ={}","hello debug");
        logger.info("输出info ={}","hello info");
        logger.error("输出error ={}","hello error");

        try {
            List<Area> areas = areaDao.queryArea();
            map.put("rows", areas);
            map.put("size", areas.size());
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("size", e.getMessage());
            return map;
        }

        return map;
    }

}
