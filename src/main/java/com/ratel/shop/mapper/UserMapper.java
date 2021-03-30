package com.ratel.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ratel.shop.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {
    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer adminUserId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}