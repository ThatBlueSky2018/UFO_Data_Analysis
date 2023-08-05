package com.yhls.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yhls.mapper.ReportMapper;
import com.yhls.pojo.PageBean;
import com.yhls.pojo.Report;
import com.yhls.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;

    //分页查询已经通过审核的
    @Override
    public PageBean listApproved(Integer page,Integer pageSize) {
        //设置分页参数
        PageHelper.startPage(page,pageSize);

        //查询
        QueryWrapper<Report> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("approved",1);
        List<Report> reports = reportMapper.selectList(queryWrapper);

        Page<Report> p=(Page<Report>) reports;
        return new PageBean(p.getTotal(),p.getResult());
    }

    //分页查询未通过审核的
    @Override
    public PageBean listNotApproved(Integer page, Integer pageSize) {
        //设置分页参数
        PageHelper.startPage(page,pageSize);

        //查询
        QueryWrapper<Report> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("approved",0);
        List<Report> reports = reportMapper.selectList(queryWrapper);

        Page<Report> p=(Page<Report>) reports;
        return new PageBean(p.getTotal(),p.getResult());
    }

    @Override
    public String passReport(Integer id) {
        LambdaUpdateWrapper<Report> lambdaUpdateWrapper=new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(Report::getId,id).set(Report::getApproved,1);
        int rows=reportMapper.update(null,lambdaUpdateWrapper);
        return "成功审批"+rows+"条记录";
    }

    @Override
    public void submit(Report report) {
        report.setApproved(0);
        reportMapper.insert(report);
    }
}
