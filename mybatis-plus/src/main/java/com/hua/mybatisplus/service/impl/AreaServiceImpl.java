package com.hua.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.mybatisplus.dao.AreaMapper;
import com.hua.mybatisplus.entity.Area;
import com.hua.mybatisplus.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 倪勤华
 * @date 2020-03-04 22:06
 */
@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements AreaService {

    @Resource
    AreaMapper areaMapper;

    public Area getByLevel(Integer level){

        return areaMapper.selectByLevel(level);
    }

    public  List<Area> selectAll (){
        return areaMapper.selectList(null);
    }
    public List<Area> selectWithUser(){
        return areaMapper.selectWithUser();
    }
    public List<Area> selectByIds(List<Long> ids){
        return areaMapper.selectByIds( ids);
    }
}
