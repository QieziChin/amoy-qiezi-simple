package com.amoy.service.admin.dao;

import com.amoy.service.admin.entity.AttachmentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


/**
 * 附件表
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@Mapper
public interface AttachmentDao extends BaseMapper<AttachmentEntity> {


    @Insert("insert into fa_attachment (admin_id, url, imagewidth, imageheight, imagetype, filename, filesize, mimetype, createtime, updatetime, uploadtime, sha1) values " +
            "(#{adminId}, #{url}, #{imagewidth}, #{imageheight}, #{imagetype}, #{filename}, #{filesize}, #{mimetype}, #{createtime}, #{updatetime}, #{uploadtime}, #{sha1})")
    void upload(AttachmentEntity attachmentEntity);
}
