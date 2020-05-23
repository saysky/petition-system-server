package com.example.sens.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.sens.config.annotation.SystemLog;
import com.example.sens.entity.Report;
import com.example.sens.entity.User;
import com.example.sens.enums.ApprovalState;
import com.example.sens.enums.LogTypeEnum;
import com.example.sens.enums.UserType;
import com.example.sens.service.ReportService;
import com.example.sens.service.UserService;
import com.example.sens.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Objects;

/**
 * @author 言曌
 * @date 2020-05-08 13:10
 */

@RestController
@RequestMapping("/api/report")
public class ReportController {


    @Autowired
    private ReportService reportService;

    @Autowired
    private UserService userService;


    /**
     * 分页列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/paging")
    public Response<Page<Report>> paging(@RequestParam(value = "keywords", required = false, defaultValue = "") String keywords,
                                         @RequestParam(value = "state", required = false, defaultValue = "") Integer state,
                                         @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                                         @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                         HttpSession session) {
        User user = (User) session.getAttribute("session_user");
        if (user == null) {
            return Response.no("请先登录");
        }
        Page pageable = new Page(pageNo, pageSize);
        Page<Report> page;
        if (UserType.USER.getValue().equalsIgnoreCase(user.getType())) {
            // 用户
            page = reportService.findAll(user.getId(), keywords, state, pageable);
        } else {
            // 管理员
            page = reportService.findAll(keywords, state, pageable);
        }


        return Response.yes(page);
    }


    /**
     * 创建
     *
     * @param report
     * @return
     */
    @PostMapping("/create")
    @SystemLog(type = LogTypeEnum.CREATE_REPORT)
    public Response createReport(@RequestBody Report report, HttpSession session) {
        User user = (User) session.getAttribute("session_user");
        if (user == null) {
            return Response.no("请先登录");
        }
        report.setUserId(user.getId());
        report.setCreateTime(new Date());
        report.setApprovalState(ApprovalState.NOT_APPROVAL.getValue());
        report.setApprovalTime(null);
        reportService.saveByReport(report);
        return Response.yes();
    }


    /**
     * 案件详情
     *
     * @param id
     * @return
     */
    @GetMapping("/details")
    public Response<Report> details(@RequestParam("id") Long id, HttpSession session) {
        Report report = reportService.findByReportId(id);
        if (report == null) {
            return Response.no("案件不存在");
        }
        report.setUser(userService.findByUserId(report.getUserId()));

        User user = (User) session.getAttribute("session_user");
        if (user == null) {
            return Response.no("请先登录");
        }
        Boolean allowApproval = false;
        if (Objects.equals(user.getType(), UserType.STAFF.getValue())) {
            // 待审核，普通员工
            if (user.getStaffLevel() == 1 && report.getApprovalState() == 0) {
                allowApproval = true;
            } else if (user.getStaffLevel() == 2 && report.getApprovalState() == 1) {
                allowApproval = true;
            }
        } else if (Objects.equals(user.getType(), UserType.ADMIN.getValue())) {
            allowApproval = true;
        }
        report.setAllowApproval(allowApproval);
        return Response.yes(report);
    }

    /**
     * 审批通过案件
     *
     * @param reportParam
     * @return
     */
    @PostMapping("/pass")
    @SystemLog(type = LogTypeEnum.PASS_REPORT)
    public Response<Boolean> pass(@RequestBody Report reportParam,
                                  HttpSession session) {
        User user = (User) session.getAttribute("session_user");
        if (user == null) {
            return Response.no("请先登录");
        }
        if (Objects.equals(user.getType(), UserType.USER.getValue())) {
            return Response.no("只有管理员可以审批");
        }

        Report report = reportService.findByReportId(reportParam.getId());
        if (report == null) {
            return Response.no("案件不存在");
        }
        report.setApprovalSuggestion(reportParam.getApprovalSuggestion());
        if (user.getStaffLevel() == 1) {
            report.setApprovalState(1);
        } else {
            report.setApprovalState(2);
            report.setApprovalTime(new Date());
        }
        reportService.saveByReport(report);
        return Response.yes(true);
    }


    /**
     * 审批驳回案件
     *
     * @param reportParam
     * @return
     */
    @PostMapping("/refuse")
    @SystemLog(type = LogTypeEnum.REFUSE_REPORT)
    public Response<Boolean> refuse(@RequestBody Report reportParam,
                                    HttpSession session) {
        User user = (User) session.getAttribute("session_user");
        if (user == null) {
            return Response.no("请先登录");
        }
        if (Objects.equals(user.getType(), UserType.USER.getValue())) {
            return Response.no("没有权限");
        }

        Report report = reportService.findByReportId(reportParam.getId());
        report.setApprovalSuggestion(reportParam.getApprovalSuggestion());
        if (report == null) {
            return Response.no("案件不存在");
        }
        report.setApprovalState(ApprovalState.REFUSE.getValue());
        report.setApprovalTime(new Date());
        reportService.saveByReport(report);
        return Response.yes(true);
    }

    /**
     * 审查案件
     *
     * @param id
     * @return
     */
    @PostMapping("/delete")
    @SystemLog(type = LogTypeEnum.DELETE_REPORT)
    public Response<Boolean> deleteReport(@RequestParam("id") Long id,
                                          HttpSession session) {
        User user = (User) session.getAttribute("session_user");
        if (user == null) {
            return Response.no("请先登录");
        }
        if (!Objects.equals(user.getType(), UserType.ADMIN.getValue())) {
            return Response.no("没有权限");
        }
        reportService.removeReport(id);
        return Response.yes(true);
    }

}
