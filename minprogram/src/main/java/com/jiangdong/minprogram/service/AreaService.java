package com.jiangdong.minprogram.service;

import com.jiangdong.minprogram.entity.Area;

import java.util.List;

public interface AreaService {
    /**
     * 查询所有
     * @return
     */
    List<Area> queryAreas();

    /**
     * 依据id查询
     * @param areaId
     * @return
     */
    Area queryAreaById(int areaId);

    /**
     * 插入
     * @param area
     * @return
     */
    boolean insertArea(Area area);

    /**
     * 更新
     * @param area
     * @return
     */
    boolean updateArea(Area area);

    /**
     * 删除
     * @param areaId
     * @return
     */
    boolean deleteArea(int areaId);
}
