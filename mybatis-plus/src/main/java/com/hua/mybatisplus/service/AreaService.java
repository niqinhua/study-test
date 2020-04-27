package com.hua.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hua.mybatisplus.entity.Area;

import java.util.List;

/**
 * @author 倪勤华
 * @date 2020-03-04 19:07
 */

public interface  AreaService  extends  IService<Area> {
    Area getByLevel(Integer level);
    List<Area> selectAll ();
    List<Area> selectWithUser();
     List<Area> selectByIds(List<Long> ids);

    }
