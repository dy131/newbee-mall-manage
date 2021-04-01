package com.ratel.shop.service.impl;

import com.ratel.shop.entity.ShopUser;
import com.ratel.shop.mapper.ShopUserMapper;
import com.ratel.shop.service.ShopUserService;
import com.ratel.shop.util.PageQueryUtil;
import com.ratel.shop.util.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopUserServiceImpl implements ShopUserService {

    @Resource
    private ShopUserMapper shopUserMapper;

    @Override
    public PageResult queryShopUserPageList(PageQueryUtil pageQueryUtil) {
        List<ShopUser> mallUsers = shopUserMapper.queryShopUserPageList(pageQueryUtil);
        int total = shopUserMapper.queryShopUserPageCount(pageQueryUtil);
        PageResult pageResult = new PageResult(mallUsers, total, pageQueryUtil.getLimit(), pageQueryUtil.getPage());
        return pageResult;
    }

    @Override
    public Boolean lockUsers(Integer[] userIds, int lockStatus) {
        if (userIds.length < 1) {
            return false;
        }
        return shopUserMapper.lockUserBatch(userIds, lockStatus) > 0;
    }
}
