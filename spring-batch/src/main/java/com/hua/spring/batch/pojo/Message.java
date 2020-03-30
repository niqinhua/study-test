package com.hua.spring.batch.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author niqinhua
 * @date 2020/3/30 16:02
 */
@Data
public class Message {
    private String objectId;
    private String content;
    private LocalDateTime lastModifiedTime;
    private LocalDateTime createdTime;
}