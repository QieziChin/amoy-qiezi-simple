package com.amoy.qiezi.service.impl;

import com.amoy.qiezi.dao.VideoCategoryDao;
import com.amoy.qiezi.entity.VideoCategoryEntity;
import com.amoy.qiezi.service.CategoryService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<VideoCategoryDao, VideoCategoryEntity> implements CategoryService {

}