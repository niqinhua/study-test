package com.hua.tkmapper.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hua.tkmapper.dao.UserMapper;
import com.hua.tkmapper.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 倪勤华
 * @date 2020-03-04 19:07
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public PageInfo<User> findUserList(int page, int size) {
        // 开启分页插件,放在查询语句上面
        PageHelper.startPage(page, size);
        List<User> listUser = userMapper.selectAll();
        // 封装分页之后的数据
        PageInfo<User> pageInfoUser = new PageInfo<User>(listUser);
        return pageInfoUser;
    }
}
