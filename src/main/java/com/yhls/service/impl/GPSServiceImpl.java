package com.yhls.service.impl;

import com.yhls.mapper.GPSMapper;
import com.yhls.pojo.GPS;
import com.yhls.service.GPSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GPSServiceImpl implements GPSService {
    @Autowired
    private GPSMapper gpsMapper;

    @Override
    public List<Float> getGPS() {
        List<GPS> gpsList=gpsMapper.selectList(null);
        List<Float> gpsData=new ArrayList<>();
        for(GPS gps:gpsList) {
            gpsData.add(gps.getLongitude());
            gpsData.add(gps.getLatitude());
        }
        return gpsData;
    }
}
