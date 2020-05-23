package com.example.sens.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 *     用户信息
 * </pre>
 */
@Data
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = -5144055068797033748L;

    /**
     * 用户ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String realName;
    /**
     * 性别
     */
    private String sex;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 身份证号码
     */
    private String card;
    /**
     * 地址
     */
    private String address;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 用户类型：群众user,  员工staff，管理员 amdin
     */
    private String type;

    /**
     * 员工等级：普通1，领导2
     */
    private Integer staffLevel;
    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 生日
     */
    private Date birth;

}
