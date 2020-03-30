package com.hua.shardingjdbc.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@EqualsAndHashCode
@Data
public class Order implements Serializable {

    @TableId
    private Long orderId;

    private BigDecimal price;

    private Long userId;

    private Integer status;

    private LocalDateTime createTime;


}