package com.hua.tkmapper.dao;

import com.hua.tkmapper.pojo.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author 倪勤华
 * @date 2020-03-04 18:59
 */
@Repository
public interface UserMapper extends Mapper<User>, MySqlMapper<User> {

}
