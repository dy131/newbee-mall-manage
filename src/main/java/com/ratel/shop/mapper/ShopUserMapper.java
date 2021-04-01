package com.ratel.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ratel.shop.entity.ShopUser;
import com.ratel.shop.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopUserMapper extends BaseMapper<ShopUser> {

    List<ShopUser> queryShopUserPageList(PageQueryUtil pageQueryUtil);

    int queryShopUserPageCount(PageQueryUtil pageQueryUtil);

    int lockUserBatch(@Param("userIds") Integer[] userIds, @Param("lockStatus") int lockStatus);




    int deleteByPrimaryKey(Long userId);

    int insert(ShopUser record);

    int insertSelective(ShopUser record);

    ShopUser selectByPrimaryKey(Long userId);

    ShopUser selectByLoginName(String loginName);

    ShopUser selectByLoginNameAndPasswd(@Param("loginName") String loginName, @Param("password") String password);

    int updateByPrimaryKeySelective(ShopUser record);

    int updateByPrimaryKey(ShopUser record);
}