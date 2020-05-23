package com.example.sens.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.sens.entity.Report;

/**
 * @author 言曌
 * @date 2020/5/15 10:24 下午
 */
public interface ReportService {


    /**
     * 新增/修改案件
     *
     * @param report report
     * @return Role
     */
    void saveByReport(Report report);

    /**
     * 根据案件Id获得案件
     *
     * @param reportId 案件名
     * @return 案件
     */
    Report findByReportId(Long reportId);

    /**
     * 删除案件
     *
     * @param reportId 案件Id
     */
    void removeReport(Long reportId);


    /**
     * 分页获取案件
     *
     * @param page 分页
     * @return 分页数据
     */
    Page<Report> findAll( String keywords, Integer state, Page<Report> page);

    Page<Report> findAll(Long userId, String keywords, Integer state, Page<Report> page);
}
