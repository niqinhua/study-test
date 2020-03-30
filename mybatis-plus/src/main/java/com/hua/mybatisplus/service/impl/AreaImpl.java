package com.hua.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.mybatisplus.dao.AreaMapper;
import com.hua.mybatisplus.pojo.Area;
import com.hua.mybatisplus.service.AreaService;
import org.springframework.stereotype.Service;

/**
 * @author 倪勤华
 * @date 2020-03-04 22:06
 */
@Service
public class AreaImpl extends ServiceImpl<AreaMapper, Area> implements AreaService {
    public IPage selectPage(Page page) {
        return baseMapper.selectPage(page, null);
    }
}
