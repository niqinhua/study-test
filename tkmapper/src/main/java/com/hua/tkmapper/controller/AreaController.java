package com.hua.tkmapper.controller;

import com.github.pagehelper.PageInfo;
import com.hua.tkmapper.pojo.Area;
import com.hua.tkmapper.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 倪勤华
 * @date 2020-03-04 20:09
 */
@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @GetMapping("/page")
    public PageInfo<Area> findUserList(int page, int size) {
        return areaService.findAreaList(page, size);
    }
}
