package com.ratel.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ratel.shop.entity.ShopUser;
import com.ratel.shop.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopUserMapper extends BaseMapper<ShopUser> {
    int deleteByPrimaryKey(Long userId);

    int insert(ShopUser record);

    int insertSelective(ShopUser record);

    ShopUser selectByPrimaryKey(Long userId);

    ShopUser selectByLoginName(String loginName);

    ShopUser selectByLoginNameAndPasswd(@Param("loginName") String loginName, @Param("password") String password);

    int updateByPrimaryKeySelective(ShopUser record);

    int updateByPrimaryKey(ShopUser record);

    List<ShopUser> findMallUserList(PageQueryUtil pageUtil);

    int getTotalMallUsers(PageQueryUtil pageUtil);

    int lockUserBatch(@Param("ids") Integer[] ids, @Param("lockStatus") int lockStatus);
}