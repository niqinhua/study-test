package com.hua.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@TableName("area")
@Data
public class Area implements Serializable {


    @TableId
    private Long id;


    private String areaCode;

    private String areaName;

    private Integer level;

    private Long parentCode;

    private String target;

    @TableField(exist = false)
    private List<User> users;

    @Getter
    @AllArgsConstructor
    public enum StatusEnum {
        STATUS_NORMAL("normal", "正常"),
        STATUS_DISABLE("disable", "禁用");

        private String value;
        private String description;
    }


}