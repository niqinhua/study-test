package com.hua.tkmapper.pojo;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class Area implements Serializable {

    @Id
    private String id;

    private String areaCode;

    private String areaName;

    private Integer level;

    private String parentCode;

    private String target;


}