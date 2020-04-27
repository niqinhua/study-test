package com.hua.tkmapper.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 倪勤华
 * @date 2020-03-04 18:55
 */
@Data
@Table
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
    Integer id;
    String name;
    Integer age;

    String tel;
    int sex;
}
