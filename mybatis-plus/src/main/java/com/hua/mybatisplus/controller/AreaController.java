package com.hua.mybatisplus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hua.mybatisplus.entity.Area;
import com.hua.mybatisplus.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public IPage<Area> findByAreaCode(Page<Area> page, Area area) {

        areaService.page(page,  Wrappers.<Area>lambdaQuery().eq(
                Area::getAreaCode,
                area.getAreaCode()).eq(Area::getAreaName, area.getAreaName()));
        return areaService.page(page);
    }

    @GetMapping("/areaId/{areaId}")
    public R getById(@PathVariable String areaId) {
        R<Area> ok = R.ok(areaService.getById(areaId));
        System.out.println(ok.toString());
        return ok;
    }

    @GetMapping("/areaName/{areaName}")
    public R getByAreaName(@PathVariable("areaName") String areaName) {
        return R.ok(areaService.getOne(Wrappers.<Area>query().eq("",areaName)));
    }

    @PostMapping("/save")
    public R save(@RequestBody Area area) {
        return R.ok(areaService.save(area));
    }

    @PostMapping("/updateById")
    public R updateById(@RequestBody Area area) {
        areaService.update(area,Wrappers.<Area>update().lambda().eq(Area::getAreaName,"1"));
        return R.ok(areaService.updateById(area));
    }

    @DeleteMapping("/{areaId}")
    public R deleteById(@PathVariable String areaId) {
        return R.ok(areaService.removeById(areaId));
    }

    @PutMapping("/delBatch")
    public R delBatch(@RequestBody List<String> areaId) {
        return R.ok(areaService.removeByIds(areaId));
    }

    /**
     * 用xml调用
     */
    @GetMapping("/level/{level}")
    public R getByLevel(@PathVariable Integer level) {
        return R.ok(areaService.getByLevel(level));
    }

    @GetMapping("/onToMany")
    public R onToMany() {
        return R.ok(areaService.selectWithUser());
    }

    @GetMapping("/all")
    public R selectAll(){
        return R.ok(areaService.selectAll());
    }

    @GetMapping("/ids")
    public R selectByIds(){
        List<Long> ids = new ArrayList<>();
//        ids.add(33L);
//        ids.add(11L);
//        ids=null;
        return R.ok(areaService.selectByIds(ids));
    }

}
