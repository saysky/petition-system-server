package com.example.sens.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 言曌
 * @date 2020/5/15 10:26 下午
 */
@Data
@TableName("category")
public class Category implements Serializable {

    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    private String title;
}
