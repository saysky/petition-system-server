package com.example.sens.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.sens.entity.Log;

import java.util.List;

/**
 * @author 言曌
 * @date 2020/5/15 10:25 下午
 */

public interface LogMapper extends BaseMapper<Log> {

    List<Log> findAll(Pagination pagination);
}
