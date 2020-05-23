package com.example.sens.enums;

/**
 * @author liuyanzhao
 */
public enum LogTypeEnum {

    /**
     * 登录
     */
    LOGIN("登录"),

    /**
     * 登录
     */
    ADMIN_LOGIN("管理员登录"),

    /**
     * 注册
     */
    REGISTER("注册"),

    /**
     * 注册
     */
    CREATE_REPORT("发布信访"),

    /**
     * 删除用户
     */
    DELETE_USER("删除用户"),

    /**
     * 添加用户
     */
    ADD_USER("添加用户"),

    /**
     * 更新用户
     */
    UPDATE_USER("更新用户"),

    /**
     * 修改个人信息
     */
    UPDATE_PROFILE("修改个人信息"),

    /**
     * 修改个人信息
     */
    UPDATE_PASSWORD("修改个人密码"),

    /**
     * 审批通过案件
     */
    PASS_REPORT("审批通过案件"),

    /**
     * 上传附件
     */
    UPLOAD_FILE("上传附件"),


    /**
     * 审批驳回案件
     */
    REFUSE_REPORT("审批驳回案件"),


    /**
     * 删除案件
     */
    DELETE_REPORT("删除案件");


    private String value;

    LogTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
