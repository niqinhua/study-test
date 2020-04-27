package com.hua.tkmapper.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hua.tkmapper.dao.AreaMapper;
import com.hua.tkmapper.pojo.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 倪勤华
 * @date 2020-03-04 19:07
 */
@Service
public class AreaService {
    @Autowired
    AreaMapper areaMapper;

    public PageInfo<Area> findAreaList(int page, int size) {
        // 开启分页插件,放在查询语句上面
        PageHelper.startPage(page, size);
        List<Area> listUser = areaMapper.selectAll();
        // 封装分页之后的数据
        PageInfo<Area> pageInfoUser = new PageInfo<Area>(listUser);
        return pageInfoUser;
    }


}
