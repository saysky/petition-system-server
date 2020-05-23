package com.example.sens.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.sens.entity.Report;
import com.example.sens.mapper.ReportMapper;
import com.example.sens.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 *     阿那件业务逻辑实现类
 * </pre>
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired(required = false)
    private ReportMapper reportMapper;

    @Override
    public void saveByReport(Report report) {
        if (report != null && report.getId() != null) {
            reportMapper.updateById(report);
        } else {
            reportMapper.insert(report);
        }
    }


    @Override
    public Report findByReportId(Long reportId) {
        return reportMapper.findById(reportId);
    }


    @Override
    public void removeReport(Long reportId) {
        reportMapper.deleteById(reportId);
    }

    @Override
    public Page<Report> findAll( String keywords, Integer state, Page<Report> page) {
        return page.setRecords(reportMapper.findAll(keywords, state, page));
    }

    @Override
    public Page<Report> findAll(Long userId, String keywords, Integer state,  Page<Report> page) {
        return page.setRecords(reportMapper.findByUserId(userId,keywords, state, page));
    }
}
