package com.example.sens.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.sens.entity.Log;

import java.util.List;

/**
 * @author 言曌
 * @date 2020/5/15 10:24 下午
 */
public interface LogService {


    /**
     * 新增/修改日志
     *
     * @param log log
     * @return Role
     */
    void saveByLog(Log log);

    /**
     * 根据日志Id获得日志
     *
     * @param logId 日志名
     * @return 日志
     */
    Log findByLogId(Long logId);

    /**
     * 删除日志
     *
     * @param logId 日志Id
     */
    void removeLog(Long logId);


    /**
     * 分页获取日志
     *
     * @param page 分页
     * @return 分页数据
     */
    Page<Log> findAll(Page<Log> page);

}
