package com.hua.mybatisplus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hua.mybatisplus.pojo.Area;
import com.hua.mybatisplus.service.AreaService;
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
    public IPage<Area> findUserList(Page<Area> page,Area areaCond) {
        areaService.page(page,  Wrappers.<Area>lambdaQuery().eq(
                Area::getAreaCode,
                areaCond.getAreaCode()));
        return areaService.page(page);
    }


}
