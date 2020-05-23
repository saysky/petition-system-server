package com.example.sens.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.sens.entity.Log;
import com.example.sens.mapper.LogMapper;
import com.example.sens.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <pre>
 *     日志业务逻辑实现类
 * </pre>
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired(required = false)
    private LogMapper logMapper;

    @Override
    public void saveByLog(Log log) {
        if (log != null && log.getId() != null) {
            logMapper.updateById(log);
        } else {
            logMapper.insert(log);
        }
    }

   
    @Override
    public Log findByLogId(Long logId) {
        return logMapper.selectById(logId);
    }


    @Override
    public void removeLog(Long logId) {
        logMapper.deleteById(logId);
    }

    @Override
    public Page<Log> findAll(Page<Log> page) {
        return page.setRecords(logMapper.findAll(page));
    }

}
