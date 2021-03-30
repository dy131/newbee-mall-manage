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
    private ShopUserMapper mallUserMapper;

    @Override
    public PageResult getNewBeeMallUsersPage(PageQueryUtil pageUtil) {
        List<ShopUser> mallUsers = mallUserMapper.findMallUserList(pageUtil);
        int total = mallUserMapper.getTotalMallUsers(pageUtil);
        PageResult pageResult = new PageResult(mallUsers, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public Boolean lockUsers(Integer[] ids, int lockStatus) {
        if (ids.length < 1) {
            return false;
        }
        return mallUserMapper.lockUserBatch(ids, lockStatus) > 0;
    }
}
