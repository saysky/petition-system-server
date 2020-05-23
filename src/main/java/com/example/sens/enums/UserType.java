package com.example.sens.enums;

/**
 * 用户类型
 * @author 言曌
 */

public enum UserType {

    /**
     * 用户
     */
    USER("user"),

    /**
     * 普通员工
     */
    STAFF("staff"),

    /**
     * 管理员
     */
    ADMIN("admin");



    private String value;

    UserType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
