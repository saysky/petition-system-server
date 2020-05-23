package com.example.sens.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author
 */
@Data
@TableName("log")
public class Log  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 日志类型
     */
    private String logType;

    /**
     * 请求用户
     */
    private Long userId;

    /**
     * ip
     */
    private String ip;


    private Date createTime;


}
