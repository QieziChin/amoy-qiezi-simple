package com.amoy.qiezi.service.impl;

import com.amoy.qiezi.dao.FulltextDao;
import com.amoy.qiezi.entity.FulltextEntity;
import com.amoy.qiezi.service.FulltextService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("fulltextService")
public class FulltextServiceImpl extends ServiceImpl<FulltextDao, FulltextEntity> implements FulltextService {

}