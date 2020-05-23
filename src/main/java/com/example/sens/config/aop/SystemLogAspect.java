package com.example.sens.config.aop;

import com.example.sens.config.annotation.SystemLog;
import com.example.sens.entity.Log;
import com.example.sens.entity.User;
import com.example.sens.enums.LogTypeEnum;
import com.example.sens.service.LogService;
import com.example.sens.util.IpInfoUtil;
import com.example.sens.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Spring AOP实现日志管理
 *
 * @author liuyanzhao
 */
@Aspect
@Component
@Slf4j
public class SystemLogAspect {

    @Autowired
    private LogService logService;

    @Autowired(required = false)
    private HttpServletRequest request;

    @Autowired
    private IpInfoUtil ipInfoUtil;

    /**
     * Controller层切点,注解方式
     */
    @Pointcut("@annotation(com.example.sens.config.annotation.SystemLog)")
    public void controllerAspect() {

    }

    /**
     * 前置通知 (在方法执行之前返回)用于拦截Controller层记录用户的操作的开始时间
     *
     * @param joinPoint 切点
     * @throws InterruptedException
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) throws InterruptedException {

    }


    /**
     * 后置通知(在方法执行之后并返回数据) 用于拦截Controller层无异常的操作
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "controllerAspect()", returning = "rvt")
    public void after(JoinPoint joinPoint, Object rvt) {

        System.out.println(rvt);
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            Log log = new Log();
            String logType = String.valueOf(getControllerMethodInfo(joinPoint).get("type"));
            if (LogTypeEnum.LOGIN.getValue().equals(logType) || LogTypeEnum.REGISTER.getValue().equals(logType)) {
                Response<User> response = (Response<User>) rvt;
                User user = response.getData();
                log.setUserId(user.getId());
            } else {
                Long userId = (Long) request.getSession().getAttribute("session_userId");
                log.setUserId(userId);
            }
            log.setLogType(logType);
            //请求IP
            log.setIp(ipInfoUtil.getIpAddr(request));
            log.setCreateTime(new Date());
            logService.saveByLog(log);
        } catch (Exception e) {
            log.error("AOP后置通知异常", e);
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static Map<String, Object> getControllerMethodInfo(JoinPoint joinPoint) throws Exception {

        Map<String, Object> map = new HashMap<String, Object>(16);
        //获取目标类名
        String targetName = joinPoint.getTarget().getClass().getName();
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        //获取相关参数
        Object[] arguments = joinPoint.getArgs();
        //生成类对象
        Class targetClass = Class.forName(targetName);
        //获取该类中的方法
        Method[] methods = targetClass.getMethods();

        String type = "";
        for (Method method : methods) {
            if (!method.getName().equals(methodName)) {
                continue;
            }
            Class[] clazzs = method.getParameterTypes();
            if (clazzs.length != arguments.length) {
                //比较方法中参数个数与从切点中获取的参数个数是否相同，原因是方法可以重载哦
                continue;
            }
            type = method.getAnnotation(SystemLog.class).type().getValue();
            map.put("type", type);
        }
        return map;
    }

}
