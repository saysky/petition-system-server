package com.example.sens.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.sens.entity.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 言曌
 * @date 2020/5/15 10:25 下午
 */
@Mapper
public interface ReportMapper extends BaseMapper<Report> {

    Report findById(Long id);

    List<Report> findAll(@Param("keywords") String keywords,
                         @Param("state") Integer state,
                         Pagination pagination);

    List<Report> findByUserId(@Param("userId") Long userId,
                              @Param("keywords") String keywords,
                              @Param("state") Integer state,
                              Pagination pagination);
}
