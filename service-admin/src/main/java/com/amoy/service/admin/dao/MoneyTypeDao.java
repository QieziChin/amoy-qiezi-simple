package com.amoy.service.admin.dao;

import com.amoy.service.admin.entity.MoneyTypeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * 
 * 
 * @author qiezi
 * @email qiezi.chin@gmail.com
 * @date 2024-08-10 23:59:16
 */
@Mapper
public interface MoneyTypeDao extends BaseMapper<MoneyTypeEntity> {



    @Update("update fa_money_type set recharge_is_show=#{rechargeIsShow}, extract_is_show=#{extractIsShow}, status=#{status} where id=#{id}")
    void updateStatus(MoneyTypeEntity moneyType);
}
