package com.jiangdong.minprogram.web;

import com.jiangdong.minprogram.entity.Area;
import com.jiangdong.minprogram.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    private Map<String,Object> listArea(){
        HashMap<String, Object> modelMap = new HashMap<>();
        List<Area> list = areaService.queryAreas();
        modelMap.put("areaList",list);
        return modelMap;
    }

    @RequestMapping(value = "/getareabyid",method = RequestMethod.POST)
    private Map<String,Object> getAreaById(@RequestParam(required = true,value = "areaid")  Integer areaId){
        HashMap<String, Object> modelMap = new HashMap<>();
        Area area = areaService.queryAreaById(areaId);
        modelMap.put("area",area);
        return modelMap;
    }

    @RequestMapping(value = "/addarea",method = RequestMethod.POST)
    private Map<String,Object> addArea(@RequestBody Area area){
        HashMap<String, Object> modelMap = new HashMap<>();
        modelMap.put("success",areaService.insertArea(area));
        return modelMap;
    }

    @RequestMapping(value = "/modifyarea",method = RequestMethod.POST)
    private Map<String,Object> modifyArea(@RequestBody Area area){
        HashMap<String, Object> modelMap = new HashMap<>();
        modelMap.put("success",areaService.updateArea(area));
        return modelMap;
    }

    @RequestMapping(value = "/deletearea",method = RequestMethod.POST)
    private Map<String,Object> deleteArea(@RequestParam(required = true,value = "areaid") Integer areaId){
        HashMap<String, Object> modelMap = new HashMap<>();
        modelMap.put("success",areaService.deleteArea(areaId));
        return modelMap;
    }


}
