package com.yhls.service.impl;

import com.yhls.mapper.LatLonNumMapper;
import com.yhls.pojo.LatLonNum;
import com.yhls.service.LatLonNumService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LatLonNumServiceImpl implements LatLonNumService {
    @Autowired
    private LatLonNumMapper latLonNumMapper;

    public List<List<Object>> list() {
        List<LatLonNum> records = this.latLonNumMapper.selectList(null);
        List<List<Object>> list = new ArrayList<>();
        for (LatLonNum record : records) {
            List<Object> row = new ArrayList<>();
            row.add(record.getLongitude());
            row.add(record.getLatitude());
            row.add(record.getNum());
            list.add(row);
        }
        return list;
    }
}