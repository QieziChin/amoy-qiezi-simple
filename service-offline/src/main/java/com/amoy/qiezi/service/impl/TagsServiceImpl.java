package com.amoy.qiezi.service.impl;

import com.amoy.qiezi.dao.TagsDao;
import com.amoy.qiezi.entity.TagsEntity;
import com.amoy.qiezi.service.TagsService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("tagsService")
public class TagsServiceImpl extends ServiceImpl<TagsDao, TagsEntity> implements TagsService {


}