package com.jiangdong.minprogram.dao;

import com.jiangdong.minprogram.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    @Ignore
    public void queryAreas() {
        List<Area> areas = areaDao.queryAreas();
        assertEquals(2,areas.size());
    }

    @Test
    @Ignore
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("东苑",area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("北苑");
        area.setPriority(10);
        area.setCreateTime(new Date());
        area.setLastEditTime(new Date());
        Integer count = areaDao.insertArea(area);
//        assertEquals(1l,(long)count);
    }

    @Test
    public void updateArea() {
        Area area = new Area();
        area.setAreaId(1);
        area.setAreaName("南苑");
        area.setLastEditTime(new Date());
        Integer integer = areaDao.updateArea(area);
//        assertEquals(1l,(long)integer);
    }

    @Test
    public void deleteArea() {
        areaDao.deleteArea(2);
    }
}