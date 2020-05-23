package com.example.sens.config.annotation;


import com.example.sens.enums.LogTypeEnum;

import java.lang.annotation.*;

/**
 * 系统日志自定义注解
 * @author liuyanzhao
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})//作用于参数或方法上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {

        /**
         * 日志类型
         * @return
         */
        LogTypeEnum type();
}
