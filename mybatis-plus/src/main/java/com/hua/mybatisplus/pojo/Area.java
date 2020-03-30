package com.hua.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class Area implements Serializable {

    @TableId
    private String id;

    private String areaCode;

    private String areaName;

    private Integer level;

    private String parentCode;

    private String target;


}