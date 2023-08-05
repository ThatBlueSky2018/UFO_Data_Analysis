package com.yhls.controller;

import com.yhls.pojo.PageBean;
import com.yhls.pojo.Report;
import com.yhls.pojo.ResponseResult;
import com.yhls.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    /**
     * 分页查询已经通过审核的报告
     * @param page 第几页
     * @param pageSize 每页数量
     * @return 响应
     */
    @GetMapping("/list")
    public ResponseResult pageApproved(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("获取通过审核的UFO目击报告");
        PageBean pageBean=reportService.listApproved(page,pageSize);
        return ResponseResult.success(pageBean);
    }

    /**
     * 分页查询待审核的报告
     * @param page 第几页
     * @param pageSize 每一页数量
     * @return 响应
     */
    @GetMapping("/check")
    public ResponseResult pageNotApproved(@RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("获取待审核的UFO目击报告");
        PageBean pageBean=reportService.listNotApproved(page,pageSize);
        return ResponseResult.success(pageBean);
    }

    /**
     * 报告审核通过
     * @param id 审核的报告id
     * @return 审核通过的信息
     */
    @PutMapping("/pass")
    public ResponseResult passReport(@RequestParam Integer id) {
        log.info("id为{}的报告通过审核",id);
        String msg= reportService.passReport(id);
        return ResponseResult.success(msg);
    }

    /**
     * 提交目击报告
     * @param report 目击报告信息
     * @return 提交成功的信息
     */
    @PostMapping("/submit")
    public ResponseResult submit(@RequestBody Report report) {
        log.info("提交目击报告");
        reportService.submit(report);
        return ResponseResult.success("提交成功!");
    }
}
