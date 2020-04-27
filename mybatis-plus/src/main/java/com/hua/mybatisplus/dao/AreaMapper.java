package com.hua.mybatisplus.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hua.mybatisplus.entity.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 倪勤华
 * @date 2020-03-04 18:59
 */
@Repository
public interface AreaMapper extends BaseMapper<Area> {

    Area selectByLevel (Integer level);
    List<Area> selectAll ();
    List<Area> selectWithUser();

    List<Area> selectByIds(@Param("ids") List<Long> ids);
}
