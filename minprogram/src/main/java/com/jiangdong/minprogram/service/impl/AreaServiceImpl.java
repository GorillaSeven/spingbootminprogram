package com.jiangdong.minprogram.service.impl;

import com.jiangdong.minprogram.dao.AreaDao;
import com.jiangdong.minprogram.entity.Area;
import com.jiangdong.minprogram.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryAreas() {
        return areaDao.queryAreas();
    }

    @Override
    public Area queryAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean insertArea(Area area) {
        if(area != null && area.getAreaName() != null && !"".equals(area.getAreaName())){
            area.setLastEditTime(new Date());
            area.setCreateTime(new Date());
            try {
                Integer count = areaDao.insertArea(area);
                if(count > 0){
                    return true;
                }else{
                    throw new RuntimeException("插入区域信息失败！");
                }
            }catch (RuntimeException e){
                throw new RuntimeException("插入区域信息失败！"+e.toString());
            }
        }else{
            throw new RuntimeException("区域名字不能为空！");
        }
    }

    @Override
    public boolean updateArea(Area area) {
        if(area != null && area.getAreaName() != null && !"".equals(area.getAreaName())){
            area.setLastEditTime(new Date());
            area.setCreateTime(new Date());
            try {
                Integer count = areaDao.updateArea(area);
                if(count > 0){
                    return true;
                }else{
                    throw new RuntimeException("更新区域信息失败！");
                }
            }catch (RuntimeException e){
                throw new RuntimeException("更新区域信息失败！"+e.toString());
            }
        }else{
            throw new RuntimeException("更新名字不能为空！");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if(areaId > 0){
            try {
                Integer count = areaDao.deleteArea(areaId);
                if(count > 0){
                    return true;
                }else{
                    throw new RuntimeException("删除区域信息失败！");
                }
            }catch (RuntimeException e){
                throw new RuntimeException("删除区域信息失败！"+e.toString());
            }
        }else{
            throw new RuntimeException("区域Id不能为空！");
        }
    }
}
