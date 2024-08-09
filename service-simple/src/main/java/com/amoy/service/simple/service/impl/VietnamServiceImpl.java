package com.amoy.service.simple.service.impl;


import com.amoy.common.entity.Draw;
import com.amoy.service.simple.mapper.DrawMapper;
import com.amoy.service.simple.service.VietnamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VietnamServiceImpl implements VietnamService {

    @Autowired
    private DrawMapper drawMapper;
    @Override
    public Draw findByPage(String page) {
        return drawMapper.findByPage(page);
    }
}
