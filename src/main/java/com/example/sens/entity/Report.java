package com.example.sens.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (Report)实体类
 *
 * @since 2020-05-12 23:04:12
 */
@Data
public class Report implements Serializable {
    private static final long serialVersionUID = -63046033306671906L;
    /**
     * 案件ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 类型
     */
    private Long categoryId;
    /**
     * 审批时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date approvalTime;
    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 审批状态：0待审批，1已完成初级审批，2领导审批通过，-1驳回
     */
    private Integer approvalState;

    /**
     * 发送地点
     */
    private String place;

    /**
     * 附件URL
     */
    private String attachmentUrl;

    /**
     * 审批意见
     */
    private String approvalSuggestion;

    @TableField(exist = false)
    private String userRealName;

    @TableField(exist = false)
    private String categoryTitle;

    @TableField(exist = false)
    private User user;

    /**
     * 登录用户是否可以继续审核
     */
    @TableField(exist = false)
    private Boolean allowApproval;


}