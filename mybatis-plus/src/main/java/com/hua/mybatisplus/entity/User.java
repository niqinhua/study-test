package com.hua.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author 倪勤华
 * @date 2020-03-04 18:55
 */
@Data
public class User {
    @TableId(type = IdType.AUTO)
    Long id;
    String name;
    Integer age;
    String tel;
    Integer sex;
    Long areaId;
}
