package com.yhls.service;

import com.yhls.pojo.PageBean;
import com.yhls.pojo.Report;


public interface ReportService {
    PageBean listApproved(Integer page,Integer pageSize);

    PageBean listNotApproved(Integer page,Integer pageSize);

    String passReport(Integer id);

    void submit(Report report);
}
